package edu.lnu.web;

import edu.lnu.domain.Score;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.ScoreService;
import edu.lnu.util.IOUtils;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**ckedit 上传图片
 * Created by Meiling on 2016/9/21.
 */
@WebServlet("/UploadImgCKServlet")
public class UploadImgCKServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //ck 重要的参数
        String callback = request.getParameter("CKEditorFuncNum");

        System.out.println(request);


        ScoreService scoreService= BasicFactory.getFactory().getService(ScoreService.class);
        String encode = this.getServletContext().getInitParameter("encode");
        Map<String, String> paramMap = new HashMap<String, String>();
        //1.上传图片
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024 * 100);
        factory.setRepository(new File(this.getServletContext().getRealPath("WEB-INF/temp")));

        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        fileUpload.setHeaderEncoding(encode);
        fileUpload.setFileSizeMax(1024 * 1024 * 5);
        fileUpload.setSizeMax(1024 * 1024 * 10);

        if (!fileUpload.isMultipartContent(request)) {
            throw new RuntimeException("请使用正确的表单进行上传!");
        }

        List<FileItem> list = null;
        try {
            list = fileUpload.parseRequest(request);
           // List<String> imgurls=new ArrayList<>();
            for (FileItem item : list) {


                if (item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString(encode);
                    paramMap.put(name, value);
                } else {

String uploadContentType=item.getContentType();
                    //文件上传项
                    String realname = item.getName();
                    int index=realname.lastIndexOf("\\");
                    if(index!=-1) {
                        realname=realname.substring(index+1);
                    }
                    String uuidname = UUID.randomUUID().toString()+"_"+realname;
                    System.out.println("=====uuidname====ck=====> "+uuidname);
                    String hash = Integer.toHexString(uuidname.hashCode());
                    String upload = this.getServletContext().getRealPath("reportImg/upload");
                    String imgurl = "reportImg/upload";
                    for(char c : hash.toCharArray()){
                        upload+="/"+c;
                        imgurl+="/"+c;
                    }
                    imgurl +="/"+uuidname;
                    //imgurls.add(imgurl);
                    File uploadFile = new File(upload);
                    if(!uploadFile.exists())
                        uploadFile.mkdirs();


                    String expandedName = "";  //文件扩展名
                    if (uploadContentType.equals("image/pjpeg") || uploadContentType.equals("image/jpeg")) {
                        //IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg
                        expandedName = ".jpg";
                    }else if(uploadContentType.equals("image/png") || uploadContentType.equals("image/x-png")){
                        //IE6上传的png图片的headimageContentType是"image/x-png"
                        expandedName = ".png";
                    }else if(uploadContentType.equals("image/gif")){
                        expandedName = ".gif";
                    }else if(uploadContentType.equals("image/bmp")){
                        expandedName = ".bmp";
                    }else{
                        response.getWriter().println("<script type=\"text/javascript\">");
                        response.getWriter().println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",''," + "'文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");
                        response.getWriter().println("</script>");
                        return  ;
                    }

                    if(new File(upload,uuidname).length() > 600*1024){
                        response.getWriter().println("<script type=\"text/javascript\">");
                        response.getWriter().println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",''," + "'文件大小不得大于600k');");
                        response.getWriter().println("</script>");
                        return  ;
                    }







                    InputStream in = item.getInputStream();
                    OutputStream out = new FileOutputStream(new File(upload,uuidname));

                    IOUtils.In2Out(in, out);
                    IOUtils.close(in, out);

                    item.delete();
                    // 返回“图像”选项卡并显示图片
                    response.getWriter().println("<script type=\"text/javascript\">");
                    response.getWriter().println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'"  + imgurl + "','')");
                    response.getWriter().println("</script>");
                }
            }


        } catch (FileUploadException e1) {
            e1.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

package edu.lnu.phone;

import edu.lnu.domain.EvaluateStandard;
import edu.lnu.domain.Question;
import edu.lnu.domain.Score;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.ScoreService;
import edu.lnu.util.IOUtils;
import jxl.Sheet;
import jxl.Workbook;
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

/**
 * Created by Meiling on 2016/7/27.
 */
@WebServlet("/GradeServletP")
public class GradeServletP extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            List<String> imgurls=new ArrayList<>();
            for (FileItem item : list) {


                if (item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString(encode);
                    paramMap.put(name, value);
                } else {


                    //文件上传项
                    String realname = item.getName();
                    int index=realname.lastIndexOf("\\");
                    if(index!=-1) {
                        realname=realname.substring(index+1);
                    }

                    String uuidname = UUID.randomUUID().toString()+"_"+realname;
                    System.out.println("=====uuidname=========> "+uuidname);
                    String hash = Integer.toHexString(uuidname.hashCode());
                    String upload = this.getServletContext().getRealPath("WEB-INF/upload");
                    String imgurl = "/WEB-INF/upload";
                    for(char c : hash.toCharArray()){
                        upload+="/"+c;
                        imgurl+="/"+c;
                    }
                    imgurl +="/"+uuidname;
                   // paramMap.put("imgurl", imgurl);
                    imgurls.add(imgurl);
                    File uploadFile = new File(upload);
                    if(!uploadFile.exists())
                        uploadFile.mkdirs();

                    InputStream in = item.getInputStream();
                    OutputStream out = new FileOutputStream(new File(upload,uuidname));

                    IOUtils.In2Out(in, out);
                    IOUtils.close(in, out);

                    item.delete();
                }
            }

            paramMap.put("picture", JSONArray.fromObject(imgurls).toString());
            System.out.println("图片。。。上传完成！");
             //picture eno  sno  evaResult
            Score score =new Score();
            BeanUtils.populate(score,paramMap);
            scoreService.addOrUpdateScore(score);
        } catch (FileUploadException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

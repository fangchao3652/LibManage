package edu.lnu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**ckedit 上传图片
 * Created by Meiling on 2016/9/21.
 */
@WebServlet("/UploadImgCKServlet")
public class UploadImgCKServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //ck 重要的参数
        String callback = request.getParameter("CKEditorFuncNum");
        System.out.println(request);
        if(false ){
            response.getWriter().println("<script type=\"text/javascript\">");
            response.getWriter().println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",''," + "'文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");
            response.getWriter().println("</script>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

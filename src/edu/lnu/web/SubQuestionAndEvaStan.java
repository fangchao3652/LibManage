package edu.lnu.web;

import edu.lnu.domain.EvaluateStandard;
import edu.lnu.domain.Question;
import edu.lnu.domain.User;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.EvaluateService;
import edu.lnu.service.QuestionService;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * 老师 提交某门课的 题库及评价标准
 * Created by Meiling on 2016/7/20.
 */
@WebServlet("/SubQuestionAndEvaStan")
public class SubQuestionAndEvaStan extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionService questionService = BasicFactory.getFactory().getService(QuestionService.class);
        EvaluateService evaluateService = BasicFactory.getFactory().getService(EvaluateService.class);
            //获取eno
        String eno = request.getParameter("eno");
        //上传选择的文件
        try {
            String encode = this.getServletContext().getInitParameter("encode");
            Map<String, String> paramMap = new HashMap<String, String>();
            //1.上传图片
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1024 * 100);
            factory.setRepository(new File(this.getServletContext().getRealPath("WEB-INF/temp")));

            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            fileUpload.setHeaderEncoding(encode);
            fileUpload.setFileSizeMax(1024 * 1024 * 1);
            fileUpload.setSizeMax(1024 * 1024 * 10);

            if (!fileUpload.isMultipartContent(request)) {
                throw new RuntimeException("请使用正确的表单进行上传!");
            }

            List<FileItem> list = fileUpload.parseRequest(request);
            for (FileItem item : list) {
                if (item.isFormField()) {
                    //普通字段
                    String name = item.getFieldName();
                    String value = item.getString(encode);
                    paramMap.put(name, value);
                } else {

                    //属性名称
                    String fiedlName = item.getFieldName();// tk :题库  pjzx :评价标准
                    if ("tk".equals(fiedlName)&&item.getFieldName()!=null&&!"".equals(item.getFieldName())) {//题库
                        InputStream in = item.getInputStream();
                        //解析 xls 并添加到数据库
                        List<Question> questionList = new ArrayList<Question>();
                        Workbook rwb = Workbook.getWorkbook(in);
                        Sheet rs = rwb.getSheet(0);//或者rwb.getSheet(0)
                        int clos = rs.getColumns();//得到所有的列
                        int rows = rs.getRows();//得到所有的行
                        for (int i = 1; i < rows; i++) {
                            //第一个是列数，第二个是行数
                            String id1 = rs.getCell(0, i).getContents();//默认最左边编号也算一列 所以这里得j++
                            String eno1 = rs.getCell(1, i).getContents();
                            String quesNUm1 = rs.getCell(2, i).getContents();
                            String topic1 = rs.getCell(3, i).getContents();
                            String answer1 = rs.getCell(4, i).getContents();
                            String options1 = rs.getCell(5, i).getContents();

                            Question question = new Question();
                            question.setEno(Integer.parseInt(eno1));
                            question.setTopic(topic1);
                            question.setQuesNum(Integer.parseInt(quesNUm1));
                            question.setOptions(options1);
                            question.setAnswer(Integer.parseInt(answer1));
                            questionList.add(question);
                        }
                        questionService.addQuestons(questionList);

                        item.delete();
                    } else if("pjzx".equals(fiedlName)&&item.getFieldName()!=null&&!"".equals(item.getFieldName())){//评价标准


                        InputStream in = item.getInputStream();
                        //解析 xls 并添加到数据库
                        List<EvaluateStandard> standardList = new ArrayList<EvaluateStandard>();
                        Workbook rwb = Workbook.getWorkbook(in);
                        Sheet rs = rwb.getSheet(0);//或者rwb.getSheet(0)
                        int clos = rs.getColumns();//得到所有的列
                        int rows = rs.getRows();//得到所有的行
                        for (int i = 1; i < rows; i++) {
                            //第一个是列数，第二个是行数
                            String id1 = rs.getCell(0, i).getContents();//默认最左边编号也算一列 所以这里得j++
                            String eno1 = rs.getCell(1, i).getContents();
                            String stanDesc1 = rs.getCell(2, i).getContents();
                            String options1 = rs.getCell(3, i).getContents();
                            EvaluateStandard standard = new EvaluateStandard();
                            standard.setId(Integer.parseInt(id1));
                            standard.setEno(Integer.parseInt(eno1));
                            standard.setStanDesc(stanDesc1);
                            standard.setOptions(options1);
                            standardList.add(standard);
                        }
                        evaluateService.addEvaluateStandars(standardList);

                        item.delete();
                    }
                }
            }


            //3.提示成功,回到主页
            response.getWriter().write("添加成功!3秒回到主页..");
            response.setHeader("Refresh", "3;url=" + request.getContextPath() + "/teacher.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
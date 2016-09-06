package edu.lnu.service;

import edu.lnu.dao.QuestionDao;
import edu.lnu.domain.Page;
import edu.lnu.domain.Question;
import edu.lnu.domain.QuestionDetail;
import edu.lnu.factory.BasicFactory;

import java.util.List;

/**
 * Created by Meiling on 2016/7/11.
 */
public class QuestionServiceImpl implements QuestionService {
    QuestionDao dao= BasicFactory.getFactory().getDao(QuestionDao.class);
    @Override
    public List<Question> findQuestionsByEno(int eno) {
        return dao.findQuestionsByEno(eno);
    }

    @Override
    public Question findQuestionsById(int id) {
        return dao.findQuestionsById(id);
    }

    @Override
    public void addQuestons(List<Question> questionList) {
        for(Question question:questionList){
            dao.addQuestion(question);
        }
    }

    @Override
    public List<QuestionDetail> findQuestionsByTno(int tno) {
        return dao.findQuestionsByTno(tno);
    }

    @Override
    public QuestionDetail findQuestionDetailById(int  id) {
        return dao.findQuestionDetailById(id);
    }

    @Override
    public void updateQuestion(QuestionDetail detail) {
        dao.updateQuestion(detail);
    }

    @Override
    public void delQuestionByID(String id) {
        dao.delQuestionByID(id);
    }

    @Override
    public Page findQuestionsByTnoPage(int tno, int thispage, int rowperpage) {

        Page page = new Page();
        page.setThispage(thispage);
        page.setRowperpage(rowperpage);
        // 共多少行
        int rowcount = dao.getRowCount(tno);
        page.setCountrow(rowcount);
        // 共多少页
        int pageCount = rowcount / rowperpage + (rowcount % rowperpage == 0 ? 0
                : 1);
        page.setCountpage(pageCount);
        // 首页
        page.setFirstpage(1);
        // 尾页
        page.setLastpage(pageCount);
        // 下一页
        page.setNextpage(thispage + 1 > pageCount ? pageCount : thispage + 1);//注意优先级
        // 上一页
        page.setPrepage(thispage - 1 < 1 ? 1 : thispage - 1);

        // 当前页 数据
        List<QuestionDetail> list = dao.getQUestionsBypage(tno,(thispage - 1) * rowperpage,
                rowperpage);
        page.setList(list);
        return page;
    }
}

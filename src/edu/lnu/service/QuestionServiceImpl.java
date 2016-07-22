package edu.lnu.service;

import edu.lnu.dao.QuestionDao;
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
}

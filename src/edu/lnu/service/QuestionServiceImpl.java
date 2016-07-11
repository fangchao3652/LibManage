package edu.lnu.service;

import edu.lnu.dao.QuestionDao;
import edu.lnu.domain.Question;
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
}
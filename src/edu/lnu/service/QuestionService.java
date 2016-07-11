package edu.lnu.service;

import edu.lnu.domain.Question;

import java.util.List;

/**
 * Created by Meiling on 2016/7/11.
 */
public interface QuestionService extends  Service  {
    List<Question> findQuestionsByEno(int eno);
}

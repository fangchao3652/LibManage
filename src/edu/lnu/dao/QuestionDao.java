package edu.lnu.dao;

import edu.lnu.domain.Question;
import edu.lnu.domain.QuestionDetail;

import java.util.List;

/**
 * Created by Meiling on 2016/7/11.
 */
public interface QuestionDao  extends  Dao{
    List<Question> findQuestionsByEno(int eno);

    Question findQuestionsById(int id);

    void addQuestion(Question question);

    List<QuestionDetail> findQuestionsByTno(int tno);

    QuestionDetail findQuestionDetailById(int id);

    void updateQuestion(QuestionDetail detail);

    void delQuestionByID(String id);
}

package edu.lnu.service;

import edu.lnu.annotation.Tran;
import edu.lnu.domain.Question;

import java.util.List;

/**
 * Created by Meiling on 2016/7/11.
 */
public interface QuestionService extends Service {
    /**
     * 在 题库表里根据 eno 查找对应的QestionList
     *
     * @param eno
     * @return
     */
    List<Question> findQuestionsByEno(int eno);

    /**
     * 根据id 查找唯一 question
     *
     * @param id
     * @return
     */
    Question findQuestionsById(int id);

    @Tran
    void addQuestons(List<Question> questionList);
}

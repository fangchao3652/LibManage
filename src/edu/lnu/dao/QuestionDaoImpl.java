package edu.lnu.dao;

import edu.lnu.domain.Question;
import edu.lnu.util.TransactionManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Created by Meiling on 2016/7/11.
 */
public class QuestionDaoImpl implements QuestionDao {


    @Override
    public List<Question> findQuestionsByEno(int eno) {
        String sql = "select * from question where eno =?";
        try {
            QueryRunner runner = new QueryRunner(TransactionManager.getSource());
            return runner.query(sql, new BeanListHandler<>(Question.class), eno);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Question findQuestionsById(int id) {
        String sql = "select * from question where id =?";
        try {
            QueryRunner runner = new QueryRunner(TransactionManager.getSource());
            return runner.query(sql, new BeanHandler<>(Question.class), id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

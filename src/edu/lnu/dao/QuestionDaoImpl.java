package edu.lnu.dao;

import edu.lnu.domain.Question;
import edu.lnu.domain.QuestionDetail;
import edu.lnu.util.TransactionManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
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

    @Override
    public void addQuestion(Question question) {
        String sql = "insert into question values(null,?,?,?,?,?)";
        try {
            QueryRunner runner = new QueryRunner(TransactionManager.getSource());
          runner.update(sql, question.getEno(), question.getQuesNum(), question.getTopic(), question.getAnswer(), question.getOptions());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<QuestionDetail> findQuestionsByTno(int tno) {
        String sql = "select * from question q natural join experiment e where q.eno  in(select eno from experiment where cno in(select cno from class where tno=?))";
        try {
            QueryRunner runner1 = new QueryRunner(TransactionManager.getSource());

            return runner1.query(sql, new BeanListHandler<>(QuestionDetail.class), tno);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public QuestionDetail findQuestionDetailById(int id) {
        String sql = "select * from question q natural join experiment e where id=?";
        try {
            QueryRunner runner1 = new QueryRunner(TransactionManager.getSource());

            return runner1.query(sql, new BeanHandler<>(QuestionDetail.class), id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateQuestion(QuestionDetail detail) {
        String sql = "update question set topic=?,options=?,answer=? where id=? ";
        try {
            QueryRunner runner1 = new QueryRunner(TransactionManager.getSource());

              runner1.update(sql,detail.getTopic(),detail.getOptions(),detail.getAnswer(),detail.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delQuestionByID(String id) {
        String sql = "delete from question where id=?";
        try {
            QueryRunner queryRunner = new QueryRunner(TransactionManager.getSource());
            queryRunner.update(sql, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int getRowCount(int tno) {
        String sql = "select count(*) from question q natural join experiment e where q.eno  in(select eno from experiment where cno in(select cno from class where tno=?))";

        try {
            QueryRunner runner = new QueryRunner(TransactionManager.getSource());

            return Integer.parseInt(String.valueOf(((Long) runner.query(sql,
                    new ScalarHandler(),tno))));// 第一行第一列的数据 long型的 要转为 int
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public List<QuestionDetail> getQUestionsBypage(int tno,int from, int rowperpage) {
        String sql = "select * from question q natural join experiment e where q.eno  in(select eno from experiment where cno in(select cno from class where tno=?)) limit ?,?";

        try {
            QueryRunner runner = new QueryRunner(TransactionManager.getSource());

            return runner.query(sql, new BeanListHandler<>( QuestionDetail.class),tno,from,
                    rowperpage);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}

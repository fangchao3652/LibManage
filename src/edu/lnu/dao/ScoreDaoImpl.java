package edu.lnu.dao;

import edu.lnu.domain.Score;
import edu.lnu.util.TransactionManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * Created by Meiling on 2016/7/11.
 */
public class ScoreDaoImpl implements ScoreDao {
    @Override
    public Score findScoreBySnoEno(int sno, int eno) {
        String sql = "select * from score where sno = ? and eno = ?";
        try {
            QueryRunner runner = new QueryRunner(TransactionManager.getSource());
            Score score = runner.query(sql, new BeanHandler<Score>(Score.class), sno, eno);
            //  System.out.println(score);
            return score;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addScore(Score score) {
        String sql = "insert into score(sno,eno,preResult,preStatus) values(?,?,?,1)";
        try {

            QueryRunner runner = new QueryRunner(TransactionManager.getSource());
            runner.update(sql, score.getSno(), score.getEno(), score.getPreResult());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatePreReport(Score score, String preReport) {
        String sql = "update  score set preReport =?,preStatus=2 where sno=? and eno=?";
        try {
            QueryRunner runner = new QueryRunner(TransactionManager.getSource());
            runner.update(sql, preReport, score.getSno(), score.getEno());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCodeReport(Score score, String code, String report) {
        String sql = "update  score set code=?,report =? where sno=? and eno=?";
        try {
            QueryRunner runner = new QueryRunner(TransactionManager.getSource());
            runner.update(sql, code, report, score.getSno(), score.getEno());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateScore(float preScore, float evaScore, float reportScore, int sno, int eno) {
        String sql = "update  score set preScore=?,evaScore =?,reportScore=?,score=?,evaStatus=1 where sno=? and eno=?";
        try {
            QueryRunner runner = new QueryRunner(TransactionManager.getSource());
            runner.update(sql, preScore, evaScore, reportScore, (preScore+evaScore+reportScore)/3,sno,eno);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateloginStatus(int sno, int eno) {
        String sql = "update  score set  login=1 where sno= ? and eno=?";
        try {
            QueryRunner runner = new QueryRunner(TransactionManager.getSource());
            runner.update(sql, sno,eno);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

package edu.lnu.service;

import edu.lnu.dao.ScoreDao;
import edu.lnu.domain.Score;
import edu.lnu.factory.BasicFactory;

/**
 * Created by Meiling on 2016/7/11.
 */
public class ScoreServiceImpl implements ScoreService {
    ScoreDao scoreDao = BasicFactory.getFactory().getDao(ScoreDao.class);

    @Override
    public void addScore(Score score) {
        Score score1 = scoreDao.findScoreBySnoEno(score.getSno(), score.getEno());
        if (score1 != null) {
            System.out.println("该学生已经预习！");
            throw new RuntimeException("该学生已经预习！");
        }
        //  System.out.println("该学生已经预习！");
        scoreDao.addScore(score);
    }

    @Override
    public void updatePreReport(Score score, String preReport) {
        Score score1 = scoreDao.findScoreBySnoEno(score.getSno(), score.getEno());
        //有记录才更新
        if (score1 != null) {
            scoreDao.updatePreReport(score, preReport);
        }else{
            throw new RuntimeException("请先预习并答题！");
        }
    }

    @Override
    public Score findScoreBySnoEno(int sno, int eno) {
        return  scoreDao.findScoreBySnoEno(sno, eno);
    }

    @Override
    public void updateCodeReport(Score score, String code, String report) {
        Score score1 = scoreDao.findScoreBySnoEno(score.getSno(), score.getEno());
        //有记录才更新
        if (score1 != null) {
            scoreDao.updateCodeReport(score,code,report);
        }else{
            throw new RuntimeException("请先预习并答题！");
        }
    }


    @Override
    public void updateScore(float preScore, float evaScore, float reportScore, int sno, int eno) {
        scoreDao.updateScore(preScore,evaScore,reportScore,sno,eno);
    }

    @Override
    public void updateloginStatus(int sno, int eno) {
        scoreDao.updateloginStatus(sno,eno);
    }

    @Override
    public void addOrUpdateScore(Score score) {
        //先查找是否存在
        Score sc=scoreDao.findScoreBySnoEno(score.getSno(),score.getEno());
        if(sc!=null){
            //更新
            scoreDao.updateEvaResultPictures(score);
        }else{
            //新插入
            scoreDao.addScoreByTeacher(score);
        }
    }

}

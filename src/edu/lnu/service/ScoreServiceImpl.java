package edu.lnu.service;

import edu.lnu.dao.ScoreDao;
import edu.lnu.domain.Score;
import edu.lnu.factory.BasicFactory;
import org.apache.commons.logging.Log;

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
        }
    }
}
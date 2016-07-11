package edu.lnu.service;

import edu.lnu.annotation.Tran;
import edu.lnu.domain.Score;

/**
 * Created by Meiling on 2016/7/11.
 */
public interface ScoreService extends Service {
    @Tran
    void addScore(Score score);

    /**
     * 根据 sno  eno  找到score 项 并更新preReport 字段
     *
     * @param score
     * @param preReport
     */
    @Tran
    void updatePreReport(Score score, String preReport);
}
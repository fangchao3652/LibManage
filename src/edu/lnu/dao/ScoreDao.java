package edu.lnu.dao;

import edu.lnu.domain.Score;

/**
 * Created by Meiling on 2016/7/11.
 */
public interface ScoreDao extends  Dao{
    /**
     * 查找该学生是否已经答题  答题完成时会存入score表
     * @param sno
     * @param eno
     * @return
     */
    Score findScoreBySnoEno(int sno, int eno);

    /**
     * 答题完成 添加一条成绩记录 只初始化三个字段 sno eno preResult(预习答题情况) ，其他默认
     * @param score
     */
    void addScore(Score score);

    /**
     * 添加预习报告
     * @param score
     * @param preReport
     */
    void updatePreReport(Score score, String preReport);

    void updateCodeReport(Score score, String code,String report);

    void updateScore(float preScore, float evaScore, float reportScore, int sno, int eno);
}

package edu.lnu.dao;

import edu.lnu.domain.Score;

/**
 * Created by Meiling on 2016/7/11.
 */
public interface ScoreDao extends Dao {
    /**
     * 查找该学生是否已经答题  答题完成时会存入score表
     *
     * @param sno
     * @param eno
     * @return
     */
    Score findScoreBySnoEno(int sno, int eno);

    /**
     * 答题完成 添加一条成绩记录 只初始化三个字段 sno eno preResult(预习答题情况) ，其他默认
     *
     * @param score
     */
    void addScore(Score score);

    /**
     * 添加预习报告
     *
     * @param score
     * @param preReport
     */
    void updatePreReport(Score score, String preReport);

    void updateCodeReport(Score score, String code, String report);

    void updateScore(float preScore, float evaScore, float reportScore, float score, int sno, int eno);

    void updateloginStatus(int sno, int eno);

    /**
     * 学生未预习 但老师已经过来评价 这是由老师在成绩表里插入一条数据
     *
     * @param score
     */
    void addScoreByTeacher(Score score);

    /**
     * 老师评价时  更新 评价状况 及 图片信息
     *
     * @param score
     */
    void updateEvaResultPictures(Score score);
}

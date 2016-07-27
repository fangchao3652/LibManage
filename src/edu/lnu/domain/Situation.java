package edu.lnu.domain;

import java.io.Serializable;

/**
 * 某节课的 所有学生的出席情况表
 * Created by Meiling on 2016/7/14.
 */
public class Situation implements Serializable {
    private int sid;// 即sno
    private String name;
    private String sex;
    private String level;
    private String profession;
    private String limitation;
    private int eno;
    private int tno;
    private int preStatus;
    private String preResult;
    private String preReport;
    private float preScore;
    private int login;
    private int evaStatus;
    private float evaScore;
    private String picture;
    private String code;
    private String video;
    private String report;
    private float reportScore;
    private float score;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getLimitation() {
        return limitation;
    }

    public void setLimitation(String limitation) {
        this.limitation = limitation;
    }

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public int getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(int preStatus) {
        this.preStatus = preStatus;
    }

    public String getPreResult() {
        return preResult;
    }

    public void setPreResult(String preResult) {
        this.preResult = preResult;
    }

    public String getPreReport() {
        return preReport;
    }

    public void setPreReport(String preReport) {
        this.preReport = preReport;
    }

    public float getPreScore() {
        return preScore;
    }

    public void setPreScore(float preScore) {
        this.preScore = preScore;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public int getEvaStatus() {
        return evaStatus;
    }

    public void setEvaStatus(int evaStatus) {
        this.evaStatus = evaStatus;
    }

    public float getEvaScore() {
        return evaScore;
    }

    public void setEvaScore(float evaScore) {
        this.evaScore = evaScore;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public float getReportScore() {
        return reportScore;
    }

    public void setReportScore(float reportScore) {
        this.reportScore = reportScore;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}

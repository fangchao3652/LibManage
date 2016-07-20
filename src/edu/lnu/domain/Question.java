package edu.lnu.domain;

import java.io.Serializable;

/**
 * Created by Meiling on 2016/7/11.
 */
public class Question implements Serializable {
    private int id;
    private int eno;
    private int quesNum;
    private String topic;
    private String options;
    private int answer;

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public int getQuesNum() {
        return quesNum;
    }

    public void setQuesNum(int quesNum) {
        this.quesNum = quesNum;
    }
}

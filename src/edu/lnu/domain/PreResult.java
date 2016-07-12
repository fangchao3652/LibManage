package edu.lnu.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 预习答题情况表(单个)
 * Created by Meiling on 2016/7/12.
 */
public class PreResult implements Serializable {
    private int id; //题号
    private String topic;//题目
    private List<String> options;//选项
    private int answer = 0;//正确答案
    private int userAnswer = 0;//用户答案


    public boolean isCorrect() {
        if (getAnswer() == 0 || getUserAnswer() == 0) {
            return false;
        } else
            return this.getAnswer() == this.getUserAnswer();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }
}

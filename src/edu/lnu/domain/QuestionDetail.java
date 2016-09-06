package edu.lnu.domain;

import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Meiling on 2016/7/21.
 */
public class QuestionDetail {
    private int id;
    private int eno;
    private int quesNum;
    private String topic;
    private String options;
    private int answer;
    private int lesson;
    private int cno;
    private Timestamp time;
    private String name;//实验课名
    private List<String> optionList;

    public void setOptionList(List<String> optionList) {
        this.optionList = optionList;
    }

    //将json 数组解析成 list 然后 在jstl 可以直接用
    public List<String> getOptionList() {
        List<String> optionList = new ArrayList<>();
        if(StringUtils.isEmpty(this.getOptions())){
            this.setOptions("[]");
        }
        JSONArray jsonArray = JSONArray.fromObject(this.getOptions());
        for (int i = 0; i < jsonArray.size(); i++) {
            String option = jsonArray.getString(i);
            optionList.add(option);
        }
        return optionList;
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

    public int getQuesNum() {
        return quesNum;
    }

    public void setQuesNum(int quesNum) {
        this.quesNum = quesNum;
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

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getLesson() {
        return lesson;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

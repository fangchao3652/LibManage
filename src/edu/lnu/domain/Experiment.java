package edu.lnu.domain;
import java.sql.Timestamp;

/**
 * Created by Meiling on 2016/7/10.
 */
public class Experiment {
    private  int  eno;
    private  int  lesson;
    private  int  cno;
    private Timestamp time;
    private String name;

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
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

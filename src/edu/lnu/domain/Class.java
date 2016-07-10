package edu.lnu.domain;

import java.util.List;

/**
 * Created by Meiling on 2016/7/10.
 */
public class Class {
    private int cno;
    private String name;
    private int tno;
    private int total;
    private String classrooom;
    private List<Experiment> list;

    public List<Experiment> getList() {
        return list;
    }

    public void setList(List<Experiment> list) {
        this.list = list;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getClassrooom() {
        return classrooom;
    }

    public void setClassrooom(String classrooom) {
        this.classrooom = classrooom;
    }

    private String credit;
}

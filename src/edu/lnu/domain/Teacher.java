package edu.lnu.domain;

/**
 * Created by Meiling on 2016/7/13.
 */
public class Teacher {
    private int tno;
    private String name;
    private String sex;
    private String title;//职位
    private String password;
    private String limitation;

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLimitation() {
        return limitation;
    }

    public void setLimitation(String limitation) {
        this.limitation = limitation;
    }
}

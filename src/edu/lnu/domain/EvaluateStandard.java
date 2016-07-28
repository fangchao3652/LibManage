package edu.lnu.domain;

import net.sf.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Meiling on 2016/7/19.
 */
public class EvaluateStandard implements Serializable {
    int id;//评价 id
    int eno;//哪一门实验课的标准
    String stanDesc;//评价标准
    String options;//评价选项


    private int select;//用户选择的哪一项

    public List<String> getOptionList() {
        List<String> optionList = new ArrayList<>();
        JSONArray jsonArray = JSONArray.fromObject(this.getOptions());
        for (int i = 0; i < jsonArray.size(); i++) {
            String option = jsonArray.getString(i);
            optionList.add(option);
        }
        return optionList;
    }


    public int getSelect() {
        return select;
    }

    public void setSelect(int select) {
        this.select = select;
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

    public String getStanDesc() {
        return stanDesc;
    }

    public void setStanDesc(String stanDesc) {
        this.stanDesc = stanDesc;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}

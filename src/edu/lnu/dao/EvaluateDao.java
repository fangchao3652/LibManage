package edu.lnu.dao;

import edu.lnu.domain.EvaluateStandard;

import java.util.List;

/**
 * Created by Fang on 2016/7/19.
 */
public interface EvaluateDao  extends  Dao{
    List<EvaluateStandard> findEvaByEno(String eno);
}

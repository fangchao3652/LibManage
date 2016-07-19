package edu.lnu.service;

import edu.lnu.domain.EvaluateStandard;

import java.util.List;

/**
 * Created by Meiling on 2016/7/19.
 */
public interface EvaluateService extends Service {
    /**
     * 根据 eno 查找 这门实验课 对应的评价标准
     * @return
     * @param eno
     */
    List<EvaluateStandard> findEvaByEno(String eno);
}

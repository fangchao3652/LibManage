package edu.lnu.service;

import edu.lnu.annotation.Tran;
import edu.lnu.domain.EvaluateStandard;

import java.util.List;

/**
 * Created by Meiling on 2016/7/19.
 */
public interface EvaluateService extends Service {
    /**
     * 根据 eno 查找 这门实验课 对应的评价标准
     *
     * @param eno
     * @return
     */
    List<EvaluateStandard> findEvaByEno(String eno);

    /**
     * 上传 评价标准
     *
     * @param standardList
     */
    @Tran
    void addEvaluateStandars(List<EvaluateStandard> standardList);
}

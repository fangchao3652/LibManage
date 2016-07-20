package edu.lnu.service;

import edu.lnu.dao.EvaluateDao;
import edu.lnu.domain.EvaluateStandard;
import edu.lnu.factory.BasicFactory;

import java.util.List;

/**
 * Created by Fang on 2016/7/19.
 */
public class EvaluateServiceImpl implements EvaluateService {
    EvaluateDao dao= BasicFactory.getFactory().getDao(EvaluateDao.class);
    @Override
    public List<EvaluateStandard> findEvaByEno(String eno) {
        return dao.findEvaByEno(eno);
    }

    @Override
    public void addEvaluateStandars(List<EvaluateStandard> standardList) {
        for(EvaluateStandard e:standardList){
            dao.addEvaluateStandar(e);
        }
    }
}

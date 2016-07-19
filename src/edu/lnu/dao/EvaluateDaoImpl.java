package edu.lnu.dao;

import edu.lnu.domain.EvaluateStandard;
import edu.lnu.domain.Question;
import edu.lnu.util.TransactionManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Created by Fang on 2016/7/19.
 */
public class EvaluateDaoImpl implements EvaluateDao {
    @Override
    public List<EvaluateStandard> findEvaByEno(String eno) {
        String sql = "select * from evaluate_standard where eno =?";
        try {
            QueryRunner runner = new QueryRunner(TransactionManager.getSource());
            return runner.query(sql, new BeanListHandler< >(EvaluateStandard.class), eno);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

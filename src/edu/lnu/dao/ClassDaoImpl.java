package edu.lnu.dao;

import edu.lnu.domain.Class;
import edu.lnu.domain.Experiment;
import edu.lnu.domain.TakeClass;
import edu.lnu.util.TransactionManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Created by Meiling on 2016/7/10.
 */
public class ClassDaoImpl implements ClassDao {
    @Override
    public List<TakeClass> findTakeClassItem(int sno) {
        String sql = "select * from take_class where sno=?";
        try {
            QueryRunner queryRunner = new QueryRunner(TransactionManager.getSource());
            return queryRunner.query(sql, new BeanListHandler<TakeClass>(TakeClass.class), sno);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Class findClassByCno(int cno) {
        String sql = "select * from class where cno=?";
        try {
            QueryRunner queryRunner = new QueryRunner(TransactionManager.getSource());
            return queryRunner.query(sql, new BeanHandler<Class>(Class.class), cno);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Experiment> findExpsByCno(int cno) {
        String sql = "select * from experiment where cno=?";
        try {
            QueryRunner queryRunner = new QueryRunner(TransactionManager.getSource());
            return queryRunner.query(sql, new BeanListHandler<Experiment>(Experiment.class), cno);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

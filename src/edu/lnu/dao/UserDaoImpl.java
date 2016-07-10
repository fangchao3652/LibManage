package edu.lnu.dao;

import edu.lnu.domain.User;
import edu.lnu.util.TransactionManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * Created by Meiling on 2016/7/10.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User finUserByNameAndPsw(String username, String password) {
        String sql = "select * from student where name = ? and password = ?";
        try{
            QueryRunner runner = new QueryRunner(TransactionManager.getSource());
            return runner.query(sql, new BeanHandler<User>(User.class) ,username ,password);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

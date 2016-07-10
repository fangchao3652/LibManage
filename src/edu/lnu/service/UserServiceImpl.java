package edu.lnu.service;

import edu.lnu.dao.UserDao;
import edu.lnu.domain.User;
import edu.lnu.factory.BasicFactory;
import edu.lnu.util.TransactionManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * Created by Meiling on 2016/7/10.
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = BasicFactory.getFactory().getDao(UserDao.class);
    @Override
    public User getUserByNameAndPsw(String username, String password) {

        return dao.finUserByNameAndPsw(username,password);


    }
}

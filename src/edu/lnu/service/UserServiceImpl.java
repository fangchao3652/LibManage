package edu.lnu.service;

import edu.lnu.dao.UserDao;
import edu.lnu.domain.Teacher;
import edu.lnu.domain.User;
import edu.lnu.factory.BasicFactory;

/**
 * Created by Meiling on 2016/7/10.
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = BasicFactory.getFactory().getDao(UserDao.class);
    @Override
    public User getUserByNameAndPsw(String username, String password, String role) {

        return dao.finUserByNameAndPsw(username,password,role);


    }

    @Override
    public Teacher getTeacherByNameAndPsw(String username, String password, String role) {
        return dao.getTeacherByNameAndPsw(username,password,role);
    }
}

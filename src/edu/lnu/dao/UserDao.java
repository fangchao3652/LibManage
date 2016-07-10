package edu.lnu.dao;

import edu.lnu.domain.User;

/**
 * Created by Meiling on 2016/7/10.
 */
public interface UserDao extends Dao {
    User finUserByNameAndPsw(String username, String password);
}

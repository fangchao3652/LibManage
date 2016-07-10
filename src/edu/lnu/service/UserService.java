package edu.lnu.service;

import edu.lnu.domain.User;

/**
 * Created by Meiling on 2016/7/10.
 */
public interface UserService extends   Service {
    User getUserByNameAndPsw(String username, String password);
}

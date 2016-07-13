package edu.lnu.service;

import edu.lnu.domain.Teacher;
import edu.lnu.domain.User;

/**
 * Created by Meiling on 2016/7/10.
 */
public interface UserService extends   Service {
    /**
     * 学生用
     * @param username
     * @param password
     * @param role
     * @return
     */
    User getUserByNameAndPsw(String username, String password, String role);

    /**
     * 老师用
     * @param username
     * @param password
     * @param role
     * @return
     */
    Teacher getTeacherByNameAndPsw(String username, String password, String role);
}

package edu.lnu.service;

import edu.lnu.domain.Situation;
import edu.lnu.domain.Teacher;
import edu.lnu.domain.User;

import java.util.List;

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

    /**
     * 老师获取 学生列表
     * @param cno
     * @param eno
     * @return
     */
    List<Situation> getSituationsByCnoEno(int cno, int eno);
}

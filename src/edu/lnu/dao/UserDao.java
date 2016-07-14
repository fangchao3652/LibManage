package edu.lnu.dao;

import edu.lnu.domain.Situation;
import edu.lnu.domain.Teacher;
import edu.lnu.domain.User;

import java.util.List;

/**
 * Created by Meiling on 2016/7/10.
 */
public interface UserDao extends Dao {
    User finUserByNameAndPsw(String username, String password, String role);

    Teacher getTeacherByNameAndPsw(String username, String password, String role);

    List<Situation> getSituationsByCnoEno(int cno, int eno);
}

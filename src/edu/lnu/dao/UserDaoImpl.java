package edu.lnu.dao;

import edu.lnu.domain.Situation;
import edu.lnu.domain.Teacher;
import edu.lnu.domain.User;
import edu.lnu.util.TransactionManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Created by Meiling on 2016/7/10.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User finUserByNameAndPsw(String username, String password, String limitation) {
        String sql = "select * from student where name = ? and password = ? and limitation=?";
        try{
            QueryRunner runner = new QueryRunner(TransactionManager.getSource());
            return runner.query(sql, new BeanHandler<User>(User.class) ,username ,password,limitation);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Teacher getTeacherByNameAndPsw(String username, String password, String limitation) {
        String sql = "select * from teacher where name = ? and password = ? and limitation=?";
        try{
            QueryRunner runner = new QueryRunner(TransactionManager.getSource());
            return runner.query(sql, new BeanHandler<Teacher>(Teacher.class) ,username ,password,limitation);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Situation> getSituationsByCnoEno(int cno, int eno) {
        String sql = "select * from  (select sno as sid,name ,sex,level,profession from student where sno in(select sno from take_class where cno=?)) as S left join( select * from score where eno =?) AS SC on S.sid= SC.sno";
        try{
            QueryRunner runner = new QueryRunner(TransactionManager.getSource());
            return runner.query(sql, new BeanListHandler<>(Situation.class) ,cno,eno);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

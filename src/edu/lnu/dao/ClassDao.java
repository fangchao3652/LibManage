package edu.lnu.dao;

import edu.lnu.domain.Class;
import edu.lnu.domain.Experiment;
import edu.lnu.domain.Score;
import edu.lnu.domain.TakeClass;

import java.util.List;

/**
 * Created by Meiling on 2016/7/10.
 */
public interface ClassDao extends Dao {

    List<TakeClass> findTakeClassItem(int sno);

    /**
     * 根据课程号 查找课程
     *
     * @param cno
     * @return
     */
    Class findClassByCno(int cno);

    /**
     * 查找指定课程的所有的实验课
     *
     * @return
     * @param cno
     */
    List<Experiment> findExpsByCno(int cno);

    List<Class> findClassByTno(int tno);


    List<Experiment> findExpsByCnoUnPred(int sno, int cno);

    List<Experiment> findExperimentsByCnoPred(int sno, int cno);

    List<Score> findExperimentsBySnoTime(int sno);
}

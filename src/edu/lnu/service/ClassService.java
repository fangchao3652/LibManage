package edu.lnu.service;

import edu.lnu.domain.Class;
import edu.lnu.domain.Experiment;
import edu.lnu.domain.Score;

import java.util.List;

/**
 * Created by Meiling on 2016/7/10.
 */
public interface ClassService extends Service {
    List<Class> findClassesBySno(int sno);


    List<Experiment> findExperimentsByCno(int cno);

    List<Class> findClassesByTno(int tno);

    /**
     * 查找 所有未预习的
     *
     * @param sno
     * @param cno
     * @return
     */
    List<Experiment> findExperimentsByCnoUnRep(int sno, int cno);

    List<Experiment> findExperimentsByCnoPred(int sno, int cno);

    List<Score> findExperimentsBySnoTime(int sno);

    /**
     * 根据eno获取单个 Experiment 从而 获取实验报告预置表格html
     * @param eno
     * @return
     */
    Experiment findExperimentByEno(int eno);


}

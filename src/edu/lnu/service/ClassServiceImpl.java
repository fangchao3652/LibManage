package edu.lnu.service;

import edu.lnu.dao.ClassDao;
import edu.lnu.domain.Class;
import edu.lnu.domain.Experiment;
import edu.lnu.domain.TakeClass;
import edu.lnu.factory.BasicFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Meiling on 2016/7/10.
 */
public class ClassServiceImpl implements ClassService {
    ClassDao classDao = BasicFactory.getFactory().getDao(ClassDao.class);

    @Override
    public List<Class> findClassesBySno(int sno) {
        List<Class> classList = new ArrayList<>();
        //根据学生编号 查找所有的takeclass 项
        List<TakeClass> takeClassList = classDao.findTakeClassItem(sno);
        //遍历 所有takeclass项 获取课程id 查找课程

        for (TakeClass takeClass : takeClassList) {
            int cno = takeClass.getCno();
            Class cla = classDao.findClassByCno(cno);
            List<Experiment> experimentList = classDao.findExpsByCno(cno);
            cla.setList(experimentList);
            classList.add(cla);
        }
        return classList;
    }

    @Override
    public List<Experiment> findExperimentsByCno(int cno) {
        return   classDao.findExpsByCno(cno);
    }

    @Override
    public List<Class> findClassesByTno(int tno) {
        return  classDao.findClassByTno(tno);
    }

    @Override
    public List<Experiment> findExperimentsByCnoUnRep(int sno, int cno) {
       return classDao.findExpsByCnoUnPred(sno,cno);
    }

    @Override
    public List<Experiment> findExperimentsByCnoPred(int sno, int cno) {
        return classDao.findExperimentsByCnoPred(sno,cno);
    }
}

package edu.lnu.service;

import edu.lnu.domain.Class;

import java.util.List;

/**
 * Created by Meiling on 2016/7/10.
 */
public interface ClassService extends Service {
    List<Class> findClassesBySno(int sno);
}

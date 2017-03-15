package edu.nju.hostelworld.dao.inf;

import org.hibernate.Session;

import java.util.List;

/**
 * Created by Hanz on 2017/3/15.
 *
 * @author Hanz
 */
public interface BaseDao {
    Session getSession();

    Session getNewSession();

    void flush();

    void clear() ;

    Object load(Class c, String id) ;

    List getAllList(Class c) ;

    int getTotalCount(Class c) ;

    void save(Object bean) ;

    void update(Object bean) ;

    void delete(Object bean) ;

    void delete(Class c, String id) ;

    void delete(Class c, String[] ids) ;
}

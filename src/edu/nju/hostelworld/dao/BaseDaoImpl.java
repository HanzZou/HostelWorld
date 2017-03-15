package edu.nju.hostelworld.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Hanz on 2017/3/15.
 *
 * @author Hanz
 */
public class BaseDaoImpl implements BaseDao {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        try {
            return sessionFactory.getCurrentSession();
        } catch (Exception e) {
            return sessionFactory.openSession();
        }
    }

    @Override
    public Session getNewSession() {
        return sessionFactory.openSession();
    }

    @Override
    public void flush() {
        getSession().flush();
    }

    @Override
    public void clear() {
        getSession().clear();
    }

    @Override
    public Object load(Class c, String id) {
        return getSession().get(c, id);
    }

    @Override
    public List getAllList(Class c) {
        String hql = "from" + c.getName();
        Session session = getSession();
        return session.createQuery(hql).list();
    }

    @Override
    public int getTotalCount(Class c) {
        Session session = getNewSession();
        String hql = "select count(*) from " + c.getName();
        Long count = (Long) session.createQuery(hql).uniqueResult();
        session.close();
        return count != null ? count.intValue() : 0;
    }

    @Override
    public void save(Object bean) {
        try {
            Session session = getSession();
            Transaction tx = session.beginTransaction();
            session.save(bean);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object bean) {
        Session session = getNewSession();
        Transaction tx = session.beginTransaction();
        session.update(bean);
        tx.commit();
        session.flush();
        session.clear();
        session.close();
    }

    @Override
    public void delete(Object bean) {
        Session session = getNewSession();
        Transaction tx = session.beginTransaction();
        session.delete(bean);
        tx.commit();
        session.flush();
        session.clear();
        session.close();
    }

    @Override
    public void delete(Class c, String id) {
        Session session = getNewSession();
        Transaction tx = session.beginTransaction();
        Object obj = session.get(c, id);
        session.delete(obj);
        tx.commit();
        flush();
        clear();
    }

    @Override
    public void delete(Class c, String[] ids) {
        for (String id : ids) {
            Object obj = getSession().get(c, id);
            if (obj != null) {
                getSession().delete(obj);
            }
        }
    }
}

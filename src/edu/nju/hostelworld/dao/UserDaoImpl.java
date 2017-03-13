package edu.nju.hostelworld.dao;

import edu.nju.hostelworld.model.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hanz on 2017/3/6.
 *
 * @author Hanz
 */
@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;
    private Transaction tx;

    public UserDaoImpl() {}

    @Override
    /**
     * 根据用户名和密码获取用户
     */
    public CustomerEntity getCustomerByIDAndPassword(CustomerEntity customer) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (Exception e) {
            session = sessionFactory.openSession();
        }
        tx = session.beginTransaction();
        String hql = "from edu.nju.hostelworld.model.CustomerEntity where id = :id and password = :pwd";
        List<CustomerEntity> list;
        try {
            list = (List<CustomerEntity>) session.createQuery(hql).setParameter("id", customer.getId()).setParameter("pwd", customer.getPassword()).list();
        } catch (Exception e) {
            list = (List<CustomerEntity>) session.createQuery(hql).setParameter("id", customer.getId()).setParameter("pwd", customer.getPassword()).list();
        }
        if (list.size() > 0) {
            return list.get(0);
        }
        tx.commit();
        session.close();
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

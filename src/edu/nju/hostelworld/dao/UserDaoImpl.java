package edu.nju.hostelworld.dao;

import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.model.ManagerEntity;
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
        list = (List<CustomerEntity>) session.createQuery(hql).setParameter("id", customer.getId()).setParameter("pwd", customer.getPassword()).list();
        tx.commit();
        session.close();
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    /**
     * 根据用户名和密码获取经理
     */
    public ManagerEntity getManagerByIDAndPassword(ManagerEntity manager) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (Exception e) {
            session = sessionFactory.openSession();
        }
        tx = session.beginTransaction();
        String hql = "from edu.nju.hostelworld.model.ManagerEntity where id = :id and password = :pwd";
        List<ManagerEntity> list = session.createQuery(hql).setParameter("id", manager.getId()).setParameter("pwd", manager.getPassword()).list();
        tx.commit();
        session.close();
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public HotelEntity getHotelByIDAndPassword(HotelEntity hotel) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (Exception e) {
            session = sessionFactory.openSession();
        }
        tx = session.beginTransaction();
        String hql = "from edu.nju.hostelworld.model.HotelEntity where id = :id and password = :pwd";
        List<HotelEntity> list = session.createQuery(hql).setParameter("id", hotel.getId()).setParameter("pwd", hotel.getPassword()).list();
        tx.commit();
        session.close();
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public CustomerEntity registerCustomer(CustomerEntity customer) {
        return null;
    }

    @Override
    public HotelEntity hotelCustomer(HotelEntity hotel) {
        return null;
    }

    @Override
    public String getCustomerNumber() {
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

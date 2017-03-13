package edu.nju.hostelworld.dao;

import edu.nju.hostelworld.model.CustomerEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hanz on 2017/3/6.
 *
 * @author Hanz
 */
@Repository("userDao")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    public UserDaoImpl() {}

    @Override
    /**
     * 根据用户名和密码获取用户
     */
    public CustomerEntity getCustomerByIDAndPassword(CustomerEntity customer) {
        System.out.println(customer.getId());
        String hql = "from edu.nju.hostelworld.model.CustomerEntity where id = ? and password = ?";
        List<CustomerEntity> list = (List<CustomerEntity>) this.getHibernateTemplate().findByNamedQuery(hql, customer.getId(), customer.getPassword());
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}

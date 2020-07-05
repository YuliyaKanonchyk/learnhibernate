package by.hiber.dao;

import by.hiber.model.Address;
import by.hiber.model.User;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public class UserDAO {

    private final HibernateTemplate hibernateTemplate;

    public UserDAO(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void updateUser(User user) {
        User merge = hibernateTemplate.merge(user);
    }

    public void save(User user) {
        hibernateTemplate.save(user);
    }

    public User getUser(Long id) {
        return hibernateTemplate.get(User.class, id);
    }

    public void delete(Long id) {
        User user = hibernateTemplate.get(User.class, id);
        hibernateTemplate.delete(user);

    }
}

package by.hiber.dao;

import by.hiber.model.Abonent;
import lombok.Data;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Data
public class AbonentDAO {
    private final SessionFactory sessionFactory;
    private final HibernateTemplate hibernateTemplate;

//    public void save(Abonent abonent, String title) {
//        TeleBook singleResult = sessionFactory
//                .getCurrentSession()
//                .createQuery("from TeleBook where title = :title", TeleBook.class)
//                .setParameter("title", title)
//                .getSingleResult();
//        singleResult.getAbonentList().add(abonent);
//        sessionFactory.getCurrentSession().update(singleResult);
//    }


    public void save(Abonent abonent) {
        hibernateTemplate.save(abonent);
    }

    public void delete(Long id) {
        Abonent abonent1 = hibernateTemplate.get(Abonent.class, id);
        hibernateTemplate.delete(abonent1);
    }

    public Abonent getAbonent(Long id) {
//        return hibernateTemplate.get(Abonent.class, id);
        return null;
    }

    public List<Abonent> getAllAbonentsByName(String name) {
        return hibernateTemplate
                .getSessionFactory()
                .getCurrentSession()
                .createQuery("from Abonent where name = :name", Abonent.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Abonent> getAllAbonentsByTeleBookTitle(String title) {
        return hibernateTemplate
                .getSessionFactory()
                .getCurrentSession()
                .createNamedQuery("Abonent.getAllAbonentsByTeleBookTitle", Abonent.class)
                .setParameter("title", title)
                .getResultList();
    }

    public void updateAbonentById(Abonent abonent) {
        Abonent abonentById = hibernateTemplate.getSessionFactory()
                .getCurrentSession()
                .createNamedQuery("Abonent.getAbonentById", Abonent.class)
                .setParameter("id", abonent.getId())
                .getSingleResult();
//        System.out.println(abonentById);
        if (abonentById!=null) {
            System.out.println("UPD start");
            abonentById.setName(abonent.getName());
            abonentById.setSurName(abonent.getSurName());
            abonentById.setTeleBook(abonentById.getTeleBook());
            abonentById.setTelNum(abonent.getTelNum());
            hibernateTemplate.update(abonentById);
        }
    }
}

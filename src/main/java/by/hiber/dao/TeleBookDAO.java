package by.hiber.dao;

import by.hiber.model.TeleBook;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class TeleBookDAO {
    private final HibernateTemplate hibernateTemplate;

    public TeleBookDAO(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void save(TeleBook teleBook){
//        TeleBook teleBook1 = hibernateTemplate.get(TeleBook.class, teleBook.getId());
//        if (teleBook1==null) {
            hibernateTemplate.save(teleBook);
//        }
    }

    public void delete (Long id){
        TeleBook teleBook = hibernateTemplate.get(TeleBook.class, id);
            hibernateTemplate.delete(teleBook);
    }

    public TeleBook get(Long id){
       return hibernateTemplate.get(TeleBook.class, id);
    }
}

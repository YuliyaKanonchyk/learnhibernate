//package by.hiber.dao;
//
//import by.hiber.model.Address;
//import org.springframework.orm.hibernate5.HibernateTemplate;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Repository
//@Transactional
//public class AddressDAO {
//    private final HibernateTemplate hibernateTemplate;
//
//    public AddressDAO(HibernateTemplate hibernateTemplate) {
//        this.hibernateTemplate = hibernateTemplate;
//    }
//
//    public void save(List<Address> address) {
//        for (Address a : address) {
//            if (!hibernateTemplate.contains(a)) {
//                hibernateTemplate.save(a);
//            }
//        }
//    }
//
//    public Address getAddress(Long id) {
//        return hibernateTemplate.get(Address.class, id);
//    }
//
//    public void update(Address address) {
//        hibernateTemplate.update(address);
//    }
//
//    public void delete(Long id) {
//        hibernateTemplate.delete(id);
//    }
//
//}

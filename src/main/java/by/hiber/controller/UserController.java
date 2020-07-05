package by.hiber.controller;

import by.hiber.dao.UserDAO;
import by.hiber.model.Address;
import by.hiber.model.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserController {

    private final UserDAO userDAO;

    @GetMapping(path = "/test")
    public void test(@RequestBody User user){
        System.out.println(user);
    }

    @GetMapping(path = "/test2")
    public User test2(){
        return new User(1L, "Vasya", null);
    }

    @GetMapping(path = "/save")
    public void save() {
        User user = new User();
        user.setName("Vasya");

        ArrayList<Address> objects = new ArrayList<>();

        Address address = new Address();
        address.setAddress("Mayak");
        Address address1 = new Address();
        address1.setAddress("Malina");

        objects.add(address);
        objects.add(address1);

        user.setAddresses(objects);
        userDAO.save(user);
    }

    @GetMapping(path = "/update")
    public void update() {
        User user = new User();
        user.setId(1L);
        user.setName("Vasya");

        ArrayList<Address> objects = new ArrayList<>();

        Address address = new Address();
        address.setAddress("Truda");

        Address address2 = new Address();
        address2.setAddress("Mayakovka");

        objects.add(address);
        objects.add(address2);

        user.setAddresses(objects);
        userDAO.updateUser(user);
    }

    @GetMapping(path = "/get/{id}")
    @Transactional
    public String get(@PathVariable("id") Long id) {
        return userDAO.getUser(id).toString();
    }

    @PostMapping(path = "delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userDAO.delete(id);
    }
}

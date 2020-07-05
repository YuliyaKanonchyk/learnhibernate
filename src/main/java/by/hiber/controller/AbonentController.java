package by.hiber.controller;

import by.hiber.dao.AbonentDAO;
import by.hiber.model.Abonent;
import by.hiber.model.TeleBook;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/abonent")
@AllArgsConstructor
public class AbonentController {

    private final AbonentDAO abonentDAO;

    @GetMapping(path = "save")
    public void save() {
        Abonent abonent = new Abonent();
        abonent.setName("Petia");
        abonent.setSurName("Pupkin");

        TeleBook teleBook = new TeleBook();
        teleBook.setId(1L);
        abonent.setTeleBook(teleBook);

        abonentDAO.save(abonent);
    }

    @GetMapping(path = "delete/{id}")
    public void delete(@PathVariable Long id) {
        abonentDAO.delete(id);
    }

    @GetMapping(path = "find/{id}")
    public void find(@PathVariable Long id) {
        abonentDAO.getAbonent(id);
    }

    @GetMapping(path = "findByName/{name}")
    public void getAllAbonentsByName(@PathVariable String name) {
        System.out.println(abonentDAO.getAllAbonentsByName(name));
    }

    @GetMapping(path = "findByTitle/{title}")
    public void getAllAbonentsByTeleBookTitle(@PathVariable String title) {
        System.out.println(abonentDAO.getAllAbonentsByTeleBookTitle(title));
    }

    @PostMapping(path = "updateAbonentById")
    public void updateAbonentById(@RequestBody Abonent abonent) {
        abonentDAO.updateAbonentById(abonent);
    }
}

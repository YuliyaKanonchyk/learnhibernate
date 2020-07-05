package by.hiber.controller;

import by.hiber.dao.TeleBookDAO;
import by.hiber.model.Abonent;
import by.hiber.model.TeleBook;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/telebook")
@AllArgsConstructor
public class TeleBookController {
    private final TeleBookDAO teleBookDAO;

    @GetMapping(path = "save")
    public void save(){
        TeleBook teleBook = new TeleBook();
        teleBook.setTitle("Minsk");

        teleBookDAO.save(teleBook);
    }

    @GetMapping(path = "delete/{id}")
    public void delete(@PathVariable Long id){
        teleBookDAO.delete(id);
    }

    @GetMapping(path = "find/{id}")
    public void find(@PathVariable Long id){
        teleBookDAO.get(id);
    }
}

package by.hiber.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@NamedQueries({
//        @NamedQuery(name = "Abonent.getAllAbonentsByTeleBookTitle", query = "from Abonent where teleBook.title = :title"),
        @NamedQuery(name = "Abonent.getAbonentById", query = "from Abonent where id = :id"),
        @NamedQuery(name = "Abonent.getAllAbonentsByTeleBookTitle", query = "from Abonent where teleBook.title = :title")
})
public class Abonent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surName;

    @ManyToOne
    private TeleBook teleBook;

    private String telNum;

    
}
package by.hiber.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TeleBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Setter
//    @Getter
    private Long id;

//    @Setter
//    @Getter
    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teleBook", fetch = FetchType.EAGER, orphanRemoval = true)
//    @Setter
    private List<Abonent> abonentList;
}
package models;

import javax.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name ="yakuza_table")
public class Yakuza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "secondName",
            unique = false,
            insertable = true,
            updatable = true,
            nullable = true,
            length = 250)
    private String surname;

    public Yakuza(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Yakuza(String name) {
        this.name = name;
    }
}

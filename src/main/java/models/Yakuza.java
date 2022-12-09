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

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fightstyle_id",referencedColumnName = "id")
    private FightStyle fightStyle;

    public Yakuza(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Yakuza(String name) {
        this.name = name;
    }

    public Yakuza(String name, String surname, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    public Yakuza(String name, String surname, Gender gender, FightStyle fightStyle) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.fightStyle = fightStyle;
    }
}

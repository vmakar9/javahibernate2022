package models;

import javax.persistence.*;
import lombok.*;

import java.util.List;


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

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
            name ="yakuza_expierence",
            joinColumns = @JoinColumn(name ="yakuza_id"),
            inverseJoinColumns = @JoinColumn(name ="expierence_id")
    )
    private List<Expirence> cards;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="yakuza_weapon",
            joinColumns = @JoinColumn(name = "yakuza_id"),
            inverseJoinColumns = @JoinColumn(name = "weapon_id")
    )
    private List<Weapon> weapons;

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

    public Yakuza(String name, String surname, Gender gender, FightStyle fightStyle, List<Expirence> cards) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.fightStyle = fightStyle;
        this.cards = cards;
    }

    public Yakuza(String name, String surname, List<Weapon> weapons) {
        this.name = name;
        this.surname = surname;
        this.weapons = weapons;
    }
}

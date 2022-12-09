package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public Weapon(String name) {
        this.name = name;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="yakuza_weapon",
            joinColumns = @JoinColumn(name ="weapon_id"),
            inverseJoinColumns = @JoinColumn(name = "yakuza_id")
    )
    private List<Yakuza> yakuza;
}

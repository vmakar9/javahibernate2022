package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Expirence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
                    name ="yakuza_expierence",
                    joinColumns = @JoinColumn(name ="yakuza_id"),
                    inverseJoinColumns = @JoinColumn(name ="expierence_id")
    )
    private Yakuza yakuza;

    public Expirence(String number) {
        this.number = number;
    }


}

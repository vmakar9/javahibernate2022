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

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Yakuza yakuza;
    private String number;

    public Expirence(String number) {
        this.number = number;
    }

    public Expirence(Yakuza yakuza, String number) {
        this.yakuza = yakuza;
        this.number = number;
    }
}

package models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FightStyle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fightstyle;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "fightStyle")
    private Yakuza yakuza;
    public FightStyle(String fightstyle) {
        this.fightstyle = fightstyle;
    }
}

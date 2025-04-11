package it.epicode.ProgettoSettimanaleS17L5.postazioni;

import it.epicode.ProgettoSettimanaleS17L5.edifici.Edificio;
import it.epicode.ProgettoSettimanaleS17L5.prenotazioni.Prenotazione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "postazioni")
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 50)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipologia;

    @Column(nullable = false)
    private int numMaxOccupanti;

    @OneToMany(mappedBy = "postazione", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioni;

    @ManyToOne
    private Edificio edificio;

    @Column(nullable = false)
    private boolean disponibile;


}

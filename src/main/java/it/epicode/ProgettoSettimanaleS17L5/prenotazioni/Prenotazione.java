package it.epicode.ProgettoSettimanaleS17L5.prenotazioni;

import it.epicode.ProgettoSettimanaleS17L5.postazioni.Postazione;
import it.epicode.ProgettoSettimanaleS17L5.utenti.Utente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prenotazioni")
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataPrenotazione;

    @Column(nullable = false)
    private LocalDate dataFinePrenotazione;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

}

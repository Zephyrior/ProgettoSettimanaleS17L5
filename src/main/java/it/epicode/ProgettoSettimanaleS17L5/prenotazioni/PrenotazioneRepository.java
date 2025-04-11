package it.epicode.ProgettoSettimanaleS17L5.prenotazioni;

import it.epicode.ProgettoSettimanaleS17L5.utenti.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrenotazioneRepository extends JpaRepository <Prenotazione, Long> {
    List<Prenotazione> findByUtente(Utente utente);
}

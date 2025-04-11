package it.epicode.ProgettoSettimanaleS17L5.prenotazioni;

import it.epicode.ProgettoSettimanaleS17L5.postazioni.Postazione;
import it.epicode.ProgettoSettimanaleS17L5.utenti.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void createPrenotazione(Postazione postazione, Utente utente, LocalDate dataPrenotazione) {
        boolean utentePrenotato = postazione.getPrenotazioni().stream()
                .anyMatch(prenotazione1 -> prenotazione1.getUtente().equals(utente));
        if (utentePrenotato) {
            throw new IllegalArgumentException("Utente già prenotato");
        }
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setPostazione(postazione);
        prenotazione.setUtente(utente);
        prenotazione.setDataPrenotazione(dataPrenotazione);
        prenotazione.setDataFinePrenotazione(dataPrenotazione.plusDays(1));
        prenotazioneRepository.save(prenotazione);
    }
}

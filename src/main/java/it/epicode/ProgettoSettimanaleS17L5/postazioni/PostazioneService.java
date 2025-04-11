package it.epicode.ProgettoSettimanaleS17L5.postazioni;

import it.epicode.ProgettoSettimanaleS17L5.utenti.Utente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public List<Postazione> findByTipologiaAndCitta(TipoPostazione tipologia, String citta) {
        return postazioneRepository.findByTipologiaAndCitta(tipologia, citta);
    }

    @Transactional
    public boolean isPostazioneDisponibile(Postazione postazione, int numOccupanti, LocalDate dataPrenotazione) {
        if (numOccupanti > postazione.getNumMaxOccupanti() ) {
            return false;
        }
        boolean ePrenotata = postazione.getPrenotazioni().stream()
                .anyMatch(prenotazione1 -> prenotazione1.getDataPrenotazione().equals(dataPrenotazione));
        return !ePrenotata && postazione.isDisponibile();
    }
}

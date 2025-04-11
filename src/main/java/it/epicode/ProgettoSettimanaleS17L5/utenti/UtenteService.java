package it.epicode.ProgettoSettimanaleS17L5.utenti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public boolean canReserve(Utente utente, LocalDate dataPrenotazione) {
        if(utente.getPrenotazioni().stream()
                .anyMatch(prenotazione -> prenotazione.getDataPrenotazione().equals(dataPrenotazione))) {
            return false;
        }
        return true;
    }
}

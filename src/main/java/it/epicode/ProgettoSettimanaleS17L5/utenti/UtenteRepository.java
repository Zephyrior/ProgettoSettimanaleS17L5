package it.epicode.ProgettoSettimanaleS17L5.utenti;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, String> {
    Utente findByUsername(String username);
}

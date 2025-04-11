package it.epicode.ProgettoSettimanaleS17L5.postazioni;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    @Query("SELECT p FROM Postazione p WHERE p.tipologia = :tipologia AND p.edificio.citta = :citta")
    List<Postazione> findByTipologiaAndCitta(@Param("tipologia") TipoPostazione tipologia, @Param("citta") String citta);
}

package it.epicode.ProgettoSettimanaleS17L5.postazioni;

import it.epicode.ProgettoSettimanaleS17L5.edifici.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class PostazioneConfig {

//    @Autowired
//    private EdificioRepository edificioRepository;

    @Bean
    public Postazione postazione1() {
        return new Postazione(null, "Postazione 1", TipoPostazione.OPENSPACE, 10, new ArrayList<>() , null, true);
    }

    @Bean
    public Postazione postazione2() {
        return new Postazione(null, "Postazione 2", TipoPostazione.PRIVATO, 3, null , null, true);
    }

    @Bean
    public Postazione postazione3() {
        return new Postazione(null, "Postazione 3", TipoPostazione.SALA_RIUNIONI, 20, null , null, true);
    }
}

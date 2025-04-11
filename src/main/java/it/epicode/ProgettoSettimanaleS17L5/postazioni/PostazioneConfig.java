package it.epicode.ProgettoSettimanaleS17L5.postazioni;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostazioneConfig {

    @Bean
    public Postazione postazione1() {
        return new Postazione(null, "Postazione 1", TipoPostazione.OPENSPACE, 10, null , null, true);
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

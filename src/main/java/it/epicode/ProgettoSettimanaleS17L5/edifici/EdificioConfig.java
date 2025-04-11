package it.epicode.ProgettoSettimanaleS17L5.edifici;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class EdificioConfig {

    @Bean
    public Edificio edificio1() {
        return new Edificio(null, "Edificio 1", "Via Roma 1", "Roma", new ArrayList<>());
    }

    @Bean
    public Edificio edificio2() {
        return new Edificio(null, "Edificio 2", "Via Milano 2", "Milano", new ArrayList<>());
    }
}

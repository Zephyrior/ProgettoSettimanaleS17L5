package it.epicode.ProgettoSettimanaleS17L5.edifici;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EdificioRunner implements CommandLineRunner {

    @Autowired
    private Edificio edificio1;

    @Autowired
    private Edificio edificio2;

    @Autowired
    private EdificioRepository edificioRepository;

    @Override
    public void run(String... args) throws Exception {
        edificioRepository.saveAll(List.of(edificio1, edificio2));
    }
}

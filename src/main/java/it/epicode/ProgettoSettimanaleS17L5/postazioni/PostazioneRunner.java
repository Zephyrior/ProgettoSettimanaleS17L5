package it.epicode.ProgettoSettimanaleS17L5.postazioni;

import it.epicode.ProgettoSettimanaleS17L5.edifici.Edificio;
import it.epicode.ProgettoSettimanaleS17L5.edifici.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostazioneRunner implements CommandLineRunner {

    @Autowired
    private Postazione postazione1;

    @Autowired
    private Postazione postazione2;

    @Autowired
    private Postazione postazione3;

//    @Autowired
//    private Edificio edificio1;
//
//    @Autowired
//    private Edificio edificio2;

    @Autowired
    private PostazioneRepository postazioneRepository;

//    @Autowired
//    private EdificioRepository edificioRepository;

    @Override
    public void run(String... args) throws Exception {

//        Edificio edificio1 = edificioRepository.findById(1L).orElse(null);
//        Edificio edificio2 = edificioRepository.findById(2L).orElse(null);
//
//        postazione1.setEdificio(edificio1);
//        postazione2.setEdificio(edificio1);
//        postazione3.setEdificio(edificio2);

        postazioneRepository.saveAll(List.of(postazione1, postazione2, postazione3));
    }
}

package it.epicode.ProgettoSettimanaleS17L5.postazioni;

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

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Override
    public void run(String... args) throws Exception {
        postazioneRepository.saveAll(List.of(postazione1, postazione2, postazione3));
    }
}

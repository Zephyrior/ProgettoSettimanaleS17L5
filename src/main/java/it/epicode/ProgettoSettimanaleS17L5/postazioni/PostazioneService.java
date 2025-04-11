package it.epicode.ProgettoSettimanaleS17L5.postazioni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public List<Postazione> findByTipologiaAndCitta(TipoPostazione tipologia, String citta) {
        return postazioneRepository.findByTipologiaAndCitta(tipologia, citta); }
}

package it.epicode.ProgettoSettimanaleS17L5.common;

import it.epicode.ProgettoSettimanaleS17L5.edifici.EdificioRepository;
import it.epicode.ProgettoSettimanaleS17L5.edifici.EdificioRunner;
import it.epicode.ProgettoSettimanaleS17L5.postazioni.Postazione;
import it.epicode.ProgettoSettimanaleS17L5.postazioni.PostazioneRepository;
import it.epicode.ProgettoSettimanaleS17L5.postazioni.PostazioneService;
import it.epicode.ProgettoSettimanaleS17L5.postazioni.TipoPostazione;
import it.epicode.ProgettoSettimanaleS17L5.prenotazioni.Prenotazione;
import it.epicode.ProgettoSettimanaleS17L5.prenotazioni.PrenotazioneRepository;
import it.epicode.ProgettoSettimanaleS17L5.prenotazioni.PrenotazioneService;
import it.epicode.ProgettoSettimanaleS17L5.utenti.Utente;
import it.epicode.ProgettoSettimanaleS17L5.utenti.UtenteRepository;
import it.epicode.ProgettoSettimanaleS17L5.utenti.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class CommonRunner implements CommandLineRunner {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private EdificioRepository edificioRepository;

//    @Autowired
//    private EdificioRunner edificioRunner;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("********************************");
        System.out.println("*                              *");
        System.out.println("*     Gestione Prenotazioni    *");
        System.out.println("*                              *");
        System.out.println("********************************");



        System.out.println("*** Effettua il login ***");



        System.out.println("Inserisci il tuo username:");
        String username = scanner.nextLine();

        Utente utente = utenteRepository.findByUsername(username);

        if (utente == null) {
            System.out.println("*** Username non trovato ***");
            System.out.println("Effettua la registrazione:");

            System.out.println("Inserisci il tuo username desiderato:");
            String nuovoUsername = scanner.nextLine();

            System.out.println("Inserisci il tuo nome completo:");
            String nuovoNome = scanner.nextLine();

            System.out.println("Inserisci la tua email:");
            String nuovaEmail = scanner.nextLine();

            utente = new Utente( nuovoUsername, nuovoNome, nuovaEmail, null);

            utenteRepository.save(utente);
        } else {
            System.out.println("Benvenuto, " + utente.getNome());
        }

        System.out.println("Digita l'operazione da eseguire:");
        System.out.println("1 - Prenotare una postazione.");
        System.out.println("2 - Visualizzare tutte le prenotazioni.");
        System.out.println("3 - Cercare una postazione.");
        int risposta = scanner.nextInt();
        scanner.nextLine();

        switch (risposta) {
            case 1:
                System.out.println("Inserisci la data in cui vuoi prenotare la postazione (formatto data: aaaa-mm-gg):");
                String dataInput = scanner.nextLine();

                LocalDate dataPrenotazione = LocalDate.parse(dataInput);


                System.out.println("Seleziona la postazione da prenotare:");
                System.out.println("1 - Postazione1");
                System.out.println("2 - Postazione2");
                System.out.println("3 - Postazione3");
                int sceltaPostazione = scanner.nextInt();
                scanner.nextLine();

                Postazione postazione = postazioneRepository.findById(Long.valueOf(sceltaPostazione)).orElse(null);

//                switch (sceltaPostazione) {
//                    case 1:
//                        postazione = postazioneRepository.findById(1L).orElse(null);
//                        break;
//                    case 2:
//                        postazione = postazioneRepository.findById(2L).orElse(null);
//                        break;
//                    case 3:
//                        postazione = postazioneRepository.findById(3L).orElse(null);
//                        break;
//                    default:
//                        System.out.println("Operazione non valida.");
//                }


                System.out.println("Inserisci il numero di persone:");
                int persone = scanner.nextInt();
                scanner.nextLine();

                if(!postazioneService.isPostazioneDisponibile(postazione, persone, dataPrenotazione)) {
                    System.out.println("Postazione non disponibile per la data o il numero di persone richiesto.");
                    break;
                } prenotazioneService.createPrenotazione(postazione, utente, dataPrenotazione);
                break;
            case 2:
                System.out.println("Lista di prenotazioni effettuate da " + utente.getNome() + ":");
                List<Prenotazione> prenotazioni = prenotazioneRepository.findByUtente(utente);
                if(prenotazioni.isEmpty()) {
                    System.out.println("Non ci sono prenotazioni.");
                } else {
                    prenotazioni.forEach(System.out::println);
                }
                break;
            case 3:
                System.out.println("Digita la città dove vuoi cercare la postazione:");
                String citta = scanner.nextLine();

                System.out.println("Seleziona il tipo di postazione:");
                System.out.println("1 - Privato");
                System.out.println("2 - Open Space");
                System.out.println("3 - Sala Reunione");
                int sceltaTipologia = scanner.nextInt();
                scanner.nextLine();

                switch (sceltaTipologia) {
                    case 1:
                        postazioneRepository.findByTipologiaAndCitta(TipoPostazione.PRIVATO, citta).forEach(System.out::println);
                        break;
                    case 2:
                        postazioneRepository.findByTipologiaAndCitta(TipoPostazione.OPENSPACE, citta).forEach(System.out::println);
                        break;
                    case 3:
                        postazioneRepository.findByTipologiaAndCitta(TipoPostazione.SALA_RIUNIONI, citta).forEach(System.out::println);
                        break;
                    default:
                        System.out.println("Operazione non valida.");
                }
                break;
            default:
                System.out.println("Operazione non valida.");
        }

    }
}

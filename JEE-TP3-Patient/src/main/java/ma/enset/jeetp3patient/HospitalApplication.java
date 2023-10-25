package ma.enset.jeetp3patient;
import ma.enset.jeetp3patient.entities.*;
import ma.enset.jeetp3patient.repositories.ConsultationRepository;
import ma.enset.jeetp3patient.repositories.MedecinRepository;
import ma.enset.jeetp3patient.repositories.PatientRepository;
import ma.enset.jeetp3patient.repositories.RendezVousRepository;
import ma.enset.jeetp3patient.service.HospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;
@SpringBootApplication
public class HospitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
    @Bean
    CommandLineRunner start(HospitalService hospitalService,
                            PatientRepository patientRepository,
                            RendezVousRepository rendezVousRepository,
                            MedecinRepository medecinRepository) {
        return args -> {
            Stream.of("Soyeon", "J-Cole", "Taeyang").forEach(name -> {
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setMalade(false);
                patient.setDateNaissance(new Date());
                patient.setScore((int)(Math.random() * 100));
                hospitalService.savePatient(patient);
            });
            Stream.of("Tablo", "Hwasa", "Crush").forEach(name -> {
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name + "@gmail.com");
                medecin.setSpecialite(Math.random() > 0.5 ? "Cardio" : "Dentiste");
                hospitalService.saveMedecin(medecin);
            });
            Patient patient = patientRepository.findByNom("Soyeon");
            Medecin medecin = medecinRepository.findByNom("Tablo");
            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDINNG);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            hospitalService.saveRendezVous(rendezVous);
            RendezVous rdv = rendezVousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setRapport("Something something");
            consultation.setRendezVous(rdv);
            consultation.setDateConsultation(rdv.getDate());
            hospitalService.saveConsultation(consultation);
            Patient p = patientRepository.findAll().get(0);
            Long id = p.getId();
            // Mettre a jour
            p.setNom("Another name");
            p.setMalade(true);
            hospitalService.savePatient(p);
            // Chercher
            p = patientRepository.findByNom("Another name");
            System.out.println(p.getId() + " : " + p.getNom() + " : " + p.getScore());
            // Supprimer
            //patientRepository.deleteById(id);
        };
    }
}



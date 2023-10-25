package ma.enset.jeetp3patient.service;
import jakarta.transaction.Transactional;
import ma.enset.jeetp3patient.entities.Consultation;
import ma.enset.jeetp3patient.entities.Medecin;
import ma.enset.jeetp3patient.entities.Patient;
import ma.enset.jeetp3patient.entities.RendezVous;
import ma.enset.jeetp3patient.repositories.ConsultationRepository;
import ma.enset.jeetp3patient.repositories.MedecinRepository;
import ma.enset.jeetp3patient.repositories.PatientRepository;
import ma.enset.jeetp3patient.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.rmi.server.UID;
import java.util.UUID;
@Service
@Transactional
public class HospitalServiceImpl implements HospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId_rendezVous(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}



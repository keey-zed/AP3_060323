package ma.enset.jeetp3patient.service;

import ma.enset.jeetp3patient.entities.Consultation;
import ma.enset.jeetp3patient.entities.Medecin;
import ma.enset.jeetp3patient.entities.Patient;
import ma.enset.jeetp3patient.entities.RendezVous;

public interface HospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}



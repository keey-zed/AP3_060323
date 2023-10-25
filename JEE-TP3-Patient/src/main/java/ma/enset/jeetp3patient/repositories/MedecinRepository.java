package ma.enset.jeetp3patient.repositories;

import ma.enset.jeetp3patient.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    public Medecin findByNom(String name);
}



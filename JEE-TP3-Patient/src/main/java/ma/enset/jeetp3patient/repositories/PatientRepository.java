package ma.enset.jeetp3patient.repositories;
import ma.enset.jeetp3patient.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
public interface PatientRepository extends JpaRepository<Patient, Long> {
    public List<Patient> findByMalade(boolean malade);
    public Patient findByNom(String name);
    public Page<Patient> findByMalade(boolean malade, Pageable pageable);
    public List<Patient> findByMaladeAndScoreLessThan(boolean malade, int score);
    public List<Patient> findByMaladeIsTrueAndScoreLessThan(int score);
    public List<Patient> findByDateNaissanceBetweenAndMaladeIsTrueOrNomLike(Date d1, Date d2, String kw);
    @Query("select p from Patient p where p.nom like :x and p.score < :y")
    public List<Patient> chercherPatients(@Param("x") String nom, @Param("y") int scoreMin);
    Page<Patient> findByNomContains(String kw, Pageable pageable);
    public void deleteById(Long id);
    public Patient searchByNomContains(String kw);
}

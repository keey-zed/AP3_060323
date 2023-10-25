package ma.enset.jeetp3patient.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class RendezVous {
    @Id
    private String id_rendezVous;
    private Date date;
    @Enumerated(EnumType.STRING)
    private StatusRDV status;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "id_patient") @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Patient patient;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "id_medecin") @OnDelete(action = OnDeleteAction.CASCADE)
    private Medecin medecin;
}



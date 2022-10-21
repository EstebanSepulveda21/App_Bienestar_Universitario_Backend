package unibague.sistemas.bienestar_universitario.offeredService.infrastructure.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import unibague.sistemas.bienestar_universitario.campus.infrastructure.entities.CampusEntity;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "OfferedService")
@Table(name = "OfferedService")
public class OfferedServiceEntity {
    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "campus_id")
    private CampusEntity campusId;

    @Column(name = "name",
            nullable = false,
            columnDefinition = "varchar(255)")
    private String name;
    @Column(name = "description",
            nullable = false,
            columnDefinition = "varchar(255)")
    private String description;
    @Column(name = "capacity",
            nullable = false)
    private Long capacity;
}

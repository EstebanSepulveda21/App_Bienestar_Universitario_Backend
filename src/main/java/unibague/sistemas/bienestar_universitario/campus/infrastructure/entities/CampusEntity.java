package unibague.sistemas.bienestar_universitario.campus.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Campus")
@Table(name = "Campus")
public class CampusEntity {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name",
            nullable = false,
            columnDefinition = "varchar(255)"
    )
    private String name;
    @Column(name = "address",
            nullable = false,
            columnDefinition = "varchar(255)")
    private String address;

}

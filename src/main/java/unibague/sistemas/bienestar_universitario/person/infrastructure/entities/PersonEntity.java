package unibague.sistemas.bienestar_universitario.person.infrastructure.entities;

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
@Entity(name = "Person")
@Table(name = "persona")
public class PersonEntity {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name",
            nullable = false,
            columnDefinition = "varchar(255)"
    )
    private String name;
    @Column(name = "lastname",
            nullable = false,
            columnDefinition = "varchar(255)"
    )
    private String lastName;
    @Column(name = "email",
            nullable = false,
            columnDefinition = "varchar(255)"
    )
    private String email;
    @Column(name = "usertype",
            nullable = false,
            columnDefinition = "varchar(255)"
    )
    private String userType;
    @Column(name = "password",
            nullable = false,
            columnDefinition = "varchar(255)"
    )
    private String password;
}

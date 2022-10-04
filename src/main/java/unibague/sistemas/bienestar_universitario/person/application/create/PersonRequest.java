package unibague.sistemas.bienestar_universitario.person.application.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
@Builder
public final class PersonRequest {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String userType;
    private String password;
}

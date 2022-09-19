package unibague.sistemas.bienestar_universitario.person.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import unibague.sistemas.bienestar_universitario.person.domain.valueObjects.*;

@Data
@AllArgsConstructor
@Builder
public class Person {
    public PersonId id;
    public PersonName name;
    public PersonLastName lastName;
    public PersonEmail email;
    public PersonUserType userType;
    public PersonPassword password;
}

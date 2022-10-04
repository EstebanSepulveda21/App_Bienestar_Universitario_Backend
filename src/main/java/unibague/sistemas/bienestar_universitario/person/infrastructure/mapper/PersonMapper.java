package unibague.sistemas.bienestar_universitario.person.infrastructure.mapper;

import org.mapstruct.Mapper;
import unibague.sistemas.bienestar_universitario.person.application.create.PersonRequest;
import unibague.sistemas.bienestar_universitario.person.domain.Person;
import unibague.sistemas.bienestar_universitario.person.domain.valueObjects.*;
import unibague.sistemas.bienestar_universitario.person.infrastructure.entities.PersonEntity;

@Mapper(componentModel = "spring")
public abstract class PersonMapper {
    public Person requestToPerson(PersonRequest request){
        return Person.builder()
                .id(new PersonId(request.getId()))
                .name(new PersonName(request.getName()))
                .lastName(new PersonLastName(request.getLastName()))
                .email(new PersonEmail(request.getEmail()))
                .userType(new PersonUserType(request.getUserType()))
                .password(new PersonPassword(request.getPassword()))
                .build();
    }

    public PersonEntity personToPersonEntity(Person person){
        return PersonEntity.builder()
                .id(person.getId().value())
                .name(person.getName().value())
                .lastName(person.getLastName().value())
                .email(person.getEmail().value())
                .userType(person.getUserType().value())
                .password(person.getPassword().value())
                .build();
    }
}

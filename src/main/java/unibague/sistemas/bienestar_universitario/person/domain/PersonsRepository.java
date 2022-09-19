package unibague.sistemas.bienestar_universitario.person.domain;

import unibague.sistemas.bienestar_universitario.person.infrastructure.entities.PersonEntity;

import java.util.List;
import java.util.Optional;

public interface PersonsRepository {
    void save(Person person);
    Optional<PersonEntity> findPersonById(Long id);
    Optional<PersonEntity> findPersonByEmailAndPassword(String email, String password);
    void delete(PersonEntity person);
    List<PersonEntity> getAll();
}

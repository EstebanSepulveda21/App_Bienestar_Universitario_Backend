package unibague.sistemas.bienestar_universitario.person.domain.create;

import unibague.sistemas.bienestar_universitario.person.application.create.PersonRequest;
import unibague.sistemas.bienestar_universitario.person.infrastructure.entities.PersonEntity;

import java.util.List;
import java.util.Optional;

public interface PersonCreator {
    void create(PersonRequest personRequest);
    Optional<PersonEntity> findPersonById(Long personId);
    Optional<PersonEntity> findPersonByEmailAndPassword(String email, String password);
    List<PersonEntity> getAll();
    void update(Long id, PersonRequest personRequest) throws Exception;
    void deletePersonById(Long personId) throws Exception;
}

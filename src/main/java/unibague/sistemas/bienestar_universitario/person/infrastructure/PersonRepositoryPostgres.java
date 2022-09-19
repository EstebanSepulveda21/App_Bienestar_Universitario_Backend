package unibague.sistemas.bienestar_universitario.person.infrastructure;

import lombok.AllArgsConstructor;
import unibague.sistemas.bienestar_universitario.person.domain.Person;
import unibague.sistemas.bienestar_universitario.person.domain.PersonsRepository;
import unibague.sistemas.bienestar_universitario.person.infrastructure.entities.PersonEntity;
import unibague.sistemas.bienestar_universitario.person.infrastructure.mapper.PersonMapper;
import unibague.sistemas.bienestar_universitario.shared.domain.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class PersonRepositoryPostgres implements PersonsRepository {

    private final PersonRepositoryJpa personRepositoryJpa;
    private final PersonMapper personMapper;

    @Override
    public void save(Person person) {
        personRepositoryJpa.save(personMapper.personToPersonEntity(person));
    }

    @Override
    public Optional<PersonEntity> findPersonById(Long id) {
        return personRepositoryJpa.findById(id);
    }

    @Override
    public Optional<PersonEntity> findPersonByEmailAndPassword(String email, String password) {
        return personRepositoryJpa.findByEmailAndPassword(email,password);
    }

    @Override
    public void delete(PersonEntity person) {
        personRepositoryJpa.deleteById(person.getId());
    }

    @Override
    public List<PersonEntity> getAll() {
        return personRepositoryJpa.findAll();
    }
}

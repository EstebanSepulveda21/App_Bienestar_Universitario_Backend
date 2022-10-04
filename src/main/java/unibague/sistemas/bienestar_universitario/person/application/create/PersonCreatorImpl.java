package unibague.sistemas.bienestar_universitario.person.application.create;

import lombok.AllArgsConstructor;
import unibague.sistemas.bienestar_universitario.person.domain.Person;
import unibague.sistemas.bienestar_universitario.person.domain.PersonsRepository;
import unibague.sistemas.bienestar_universitario.person.domain.create.PersonCreator;
import unibague.sistemas.bienestar_universitario.person.infrastructure.entities.PersonEntity;
import unibague.sistemas.bienestar_universitario.person.infrastructure.mapper.PersonMapper;
import unibague.sistemas.bienestar_universitario.shared.domain.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonCreatorImpl implements PersonCreator {

    private final PersonsRepository personsRepository;
    private final PersonMapper personMapper;

    @Override
    public void create(PersonRequest personRequest) {
        Person person = personMapper.requestToPerson(personRequest);
        personsRepository.save(person);
    }

    @Override
    public Optional<PersonEntity> findPersonById(Long personId) {
        return personsRepository.findPersonById(personId);
    }

    @Override
    public Optional<PersonEntity> findPersonByEmailAndPassword(String email, String password) {
        return personsRepository.findPersonByEmailAndPassword(email,password);
    }

    @Override
    public List<PersonEntity> getAll() {
        return personsRepository.getAll();
    }

    @Override
    public void update(Long id, PersonRequest personRequest) throws Exception {
        Optional<PersonEntity> personUpdate = findPersonById(id);
        if(!personUpdate.isPresent()){
            throw new Exception("The id does not exist: " + id);
        }else{
            Person person = personMapper.requestToPerson(personRequest);
            personsRepository.save(person);
        }
    }

    @Override
    public void deletePersonById(Long personId) throws Exception {
        Optional<PersonEntity> personDeleteById = findPersonById(personId);
        if(!personDeleteById.isPresent()){
            throw new Exception("The id does not exist: " + personId);
        }else{
            personsRepository.delete(personDeleteById.get());
        }
    }
}

package unibague.sistemas.bienestar_universitario.person.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unibague.sistemas.bienestar_universitario.person.aplication.create.PersonRequest;
import unibague.sistemas.bienestar_universitario.person.domain.create.PersonCreator;
import unibague.sistemas.bienestar_universitario.person.infrastructure.entities.PersonEntity;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonCreator personCreator;

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody Request person){
        PersonRequest personSave = new PersonRequest(person.getId(), person.getName(), person.getLastName(), person.getEmail(), person.getUserType(), person.getPassword());
        personCreator.create(personSave);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location","/api/v1/person/" + personSave.getName());
        return new ResponseEntity<HttpStatus>(httpHeaders,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PersonEntity> personById(@PathVariable("id") Long personId){
        Optional<PersonEntity> personById = personCreator.findPersonById(personId);
        if(!personById.isPresent()){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location","/api/v1/person/" + personId);
            return new ResponseEntity<PersonEntity>(httpHeaders,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PersonEntity>(personById.get(),HttpStatus.OK);
    }

    @GetMapping("/email/{email}/pass/{password}")
    public ResponseEntity<PersonEntity> personByEmail(@PathVariable("email") String personEmail, @PathVariable("password") String personPassword){
        Optional<PersonEntity> personByEmailAndPassword = personCreator.findPersonByEmailAndPassword(personEmail, personPassword);
        if(!personByEmailAndPassword.isPresent()){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location","/api/v1/person/email/" + personEmail + "/pass/" + personPassword);
            return new ResponseEntity<PersonEntity>(httpHeaders,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PersonEntity>(personByEmailAndPassword.get(),HttpStatus.OK);
    }
}

@Data
final class Request{
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String userType;
    private String password;
}

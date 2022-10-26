package unibague.sistemas.bienestar_universitario.person.domain.validation;

import unibague.sistemas.bienestar_universitario.person.domain.Person;

public class PersonValidate {
    public static boolean validate(String email, String password){
        Person person = new Person();
        return(email.equals(person.getEmail().getValue()) && password.equals(person.getPassword().getValue()));
    }
}

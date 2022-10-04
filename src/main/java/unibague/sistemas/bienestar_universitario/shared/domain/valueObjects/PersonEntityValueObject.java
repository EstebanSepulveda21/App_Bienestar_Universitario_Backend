package unibague.sistemas.bienestar_universitario.shared.domain.valueObjects;

import lombok.Data;
import unibague.sistemas.bienestar_universitario.person.infrastructure.entities.PersonEntity;

import java.util.Objects;

@Data
public abstract class PersonEntityValueObject {
    protected final PersonEntity value;

    public PersonEntityValueObject(PersonEntity value) {
        this.value = value;
    }

    public PersonEntity value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntityValueObject that = (PersonEntityValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

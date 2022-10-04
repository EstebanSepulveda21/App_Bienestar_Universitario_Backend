package unibague.sistemas.bienestar_universitario.booking.domain.valueObjects;

import unibague.sistemas.bienestar_universitario.person.infrastructure.entities.PersonEntity;
import unibague.sistemas.bienestar_universitario.shared.domain.valueObjects.PersonEntityValueObject;

public class BookingPersonId extends PersonEntityValueObject {
    public BookingPersonId(PersonEntity value) {
        super(value);
    }
}

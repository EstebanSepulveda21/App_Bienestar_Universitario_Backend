package unibague.sistemas.bienestar_universitario.booking.domain.valueObjects;

import unibague.sistemas.bienestar_universitario.shared.domain.valueObjects.CalendarValueObject;

import java.util.Calendar;

public class BookingDate extends CalendarValueObject {
    public BookingDate(Calendar value) {
        super(value);
    }
}

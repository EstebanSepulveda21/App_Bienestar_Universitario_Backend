package unibague.sistemas.bienestar_universitario.booking.domain.valueObjects;

import unibague.sistemas.bienestar_universitario.offeredService.infrastructure.entities.OfferedServiceEntity;
import unibague.sistemas.bienestar_universitario.shared.domain.valueObjects.OfferedServiceEntityValueObject;

public class BookingOfferedServiceId extends OfferedServiceEntityValueObject {
    public BookingOfferedServiceId(OfferedServiceEntity value) {
        super(value);
    }
}

package unibague.sistemas.bienestar_universitario.booking.application.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import unibague.sistemas.bienestar_universitario.offeredService.infrastructure.entities.OfferedServiceEntity;
import unibague.sistemas.bienestar_universitario.person.infrastructure.entities.PersonEntity;

import java.util.Calendar;

@Data
@AllArgsConstructor
@Getter
@Builder
public final class BookingRequest {
    private Long id;
    private Calendar date;
    private PersonEntity personId;
    private OfferedServiceEntity offeredServiceId;
}

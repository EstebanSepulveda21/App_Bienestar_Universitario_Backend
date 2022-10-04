package unibague.sistemas.bienestar_universitario.booking.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import unibague.sistemas.bienestar_universitario.booking.domain.valueObjects.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {
    public BookingId id;
    public BookingDate date;
    public BookingPersonId personId;
    public BookingOfferedServiceId offeredServiceId;
}

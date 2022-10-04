package unibague.sistemas.bienestar_universitario.booking.infrastructure.mapper;

import org.mapstruct.Mapper;
import unibague.sistemas.bienestar_universitario.booking.application.create.BookingRequest;
import unibague.sistemas.bienestar_universitario.booking.domain.Booking;
import unibague.sistemas.bienestar_universitario.booking.domain.valueObjects.BookingDate;
import unibague.sistemas.bienestar_universitario.booking.domain.valueObjects.BookingId;
import unibague.sistemas.bienestar_universitario.booking.domain.valueObjects.BookingOfferedServiceId;
import unibague.sistemas.bienestar_universitario.booking.domain.valueObjects.BookingPersonId;
import unibague.sistemas.bienestar_universitario.booking.infrastructure.entities.BookingEntity;

@Mapper(componentModel = "spring")
public abstract class BookingMapper {
    public Booking requestToBooking(BookingRequest request){
        return Booking.builder()
                .id(new BookingId(request.getId()))
                .date(new BookingDate(request.getDate()))
                .personId(new BookingPersonId(request.getPersonId()))
                .offeredServiceId(new BookingOfferedServiceId(request.getOfferedServiceId()))
                .build();
    }
    public BookingEntity bookingToBookingEntity(Booking booking){
        return BookingEntity.builder()
                .id(booking.getId().value())
                .date(booking.getDate().value())
                .personId(booking.getPersonId().value())
                .offeredServiceId(booking.getOfferedServiceId().value())
                .build();
    }
}

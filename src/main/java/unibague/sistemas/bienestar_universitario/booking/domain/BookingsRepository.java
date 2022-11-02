package unibague.sistemas.bienestar_universitario.booking.domain;


import org.springframework.data.jpa.repository.Query;
import unibague.sistemas.bienestar_universitario.booking.infrastructure.entities.BookingEntity;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookingsRepository {
    void save(Booking booking);
    Optional<BookingEntity> findBookingById(Long bookingId);


    Optional<List<BookingEntity>> findAllAngular();

    Optional<List<BookingEntity>> findBookingByDate(Date dateStart, Date dateEnd);

    Optional<List<BookingEntity>> findBookingByPersonId(Long personId);



    Optional<List<BookingEntity>> findBookingByOfferedServiceId(Long offeredServiceId);
    Optional<List<BookingEntity>> findBookingByPersonIdAndDate(Long personId, Calendar date);
    List<BookingEntity> getAll();
    void deleteById(BookingEntity bookingEntity);
    void deleteBookingById(Long id);
}

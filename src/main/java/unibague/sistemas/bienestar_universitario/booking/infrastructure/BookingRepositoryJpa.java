package unibague.sistemas.bienestar_universitario.booking.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import unibague.sistemas.bienestar_universitario.booking.infrastructure.entities.BookingEntity;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public interface BookingRepositoryJpa extends JpaRepository<BookingEntity, Long> {
    Optional<List<BookingEntity>> findByDate(Calendar date);
    Optional<List<BookingEntity>> findByPersonId(Long personId);
    Optional<List<BookingEntity>> findByOfferedServiceId(Long offeredServiceId);
    Optional<List<BookingEntity>> findByPersonIdAndDate(Long personId, Calendar date);
    void deleteByPersonId(BookingEntity bookingEntity);
}

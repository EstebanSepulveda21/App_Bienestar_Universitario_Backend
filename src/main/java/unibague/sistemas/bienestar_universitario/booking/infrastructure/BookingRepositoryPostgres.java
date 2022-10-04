package unibague.sistemas.bienestar_universitario.booking.infrastructure;

import lombok.AllArgsConstructor;
import unibague.sistemas.bienestar_universitario.booking.domain.Booking;
import unibague.sistemas.bienestar_universitario.booking.domain.BookingsRepository;
import unibague.sistemas.bienestar_universitario.booking.infrastructure.entities.BookingEntity;
import unibague.sistemas.bienestar_universitario.booking.infrastructure.mapper.BookingMapper;
import unibague.sistemas.bienestar_universitario.shared.domain.Repository;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class BookingRepositoryPostgres implements BookingsRepository {

    private final BookingRepositoryJpa bookingRepositoryJpa;
    private final BookingMapper bookingMapper;

    @Override
    public void save(Booking booking) {
        bookingRepositoryJpa.save(bookingMapper.bookingToBookingEntity(booking));
    }

    @Override
    public Optional<BookingEntity> findBookingById(Long bookingId) {
        return bookingRepositoryJpa.findById(bookingId);
    }

    @Override
    public Optional<List<BookingEntity>> findBookingByDate(Calendar date) {
        return bookingRepositoryJpa.findByDate(date);
    }

    @Override
    public Optional<List<BookingEntity>> findBookingByPersonId(Long personId) {
        return bookingRepositoryJpa.findByPersonId(personId);
    }

    @Override
    public Optional<List<BookingEntity>> findBookingByOfferedServiceId(Long offeredServiceId) {
        return bookingRepositoryJpa.findByOfferedServiceId(offeredServiceId);
    }

    @Override
    public Optional<List<BookingEntity>> findBookingByPersonIdAndDate(Long personId, Calendar date) {
        return bookingRepositoryJpa.findByPersonIdAndDate(personId, date);
    }

    @Override
    public List<BookingEntity> getAll() {
        return bookingRepositoryJpa.findAll();
    }

    @Override
    public void deleteById(BookingEntity bookingEntity) {
        bookingRepositoryJpa.deleteById(bookingEntity.getId());
    }

}

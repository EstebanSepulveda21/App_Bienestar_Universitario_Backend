package unibague.sistemas.bienestar_universitario.booking.application.create;

import lombok.AllArgsConstructor;
import unibague.sistemas.bienestar_universitario.booking.domain.Booking;
import unibague.sistemas.bienestar_universitario.booking.domain.BookingsRepository;
import unibague.sistemas.bienestar_universitario.booking.domain.create.BookingCreator;
import unibague.sistemas.bienestar_universitario.booking.infrastructure.entities.BookingEntity;
import unibague.sistemas.bienestar_universitario.booking.infrastructure.mapper.BookingMapper;
import unibague.sistemas.bienestar_universitario.shared.domain.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingCreatorImpl implements BookingCreator {

    private final BookingsRepository bookingsRepository;
    private final BookingMapper bookingMapper;

    @Override
    public void create(BookingRequest bookingRequest) {
        Booking booking = bookingMapper.requestToBooking(bookingRequest);
        bookingsRepository.save(booking);
    }

    @Override
    public Optional<BookingEntity> findBookingById(Long bookingId) {
        return bookingsRepository.findBookingById(bookingId);
    }

    @Override
    public Optional<List<BookingEntity>> findBookingByDate(Calendar date) {
        return bookingsRepository.findBookingByDate(date);
    }

    @Override
    public Optional<List<BookingEntity>> findBookingByPersonId(Long personId) {
        return bookingsRepository.findBookingByPersonId(personId);
    }

    @Override
    public Optional<List<BookingEntity>> findBookingByOfferedServiceId(Long offeredServiceId) {
        return bookingsRepository.findBookingByOfferedServiceId(offeredServiceId);
    }

    @Override
    public Optional<List<BookingEntity>> findBookingByPersonIdAndDate(Long personId, Calendar date) {
        return bookingsRepository.findBookingByPersonIdAndDate(personId, date);
    }

    @Override
    public List<BookingEntity> getAll() {
        return bookingsRepository.getAll();
    }

    @Override
    public void deleteBookingById(Long bookingId) throws Exception {
        Optional<BookingEntity> bookingDeleteById = findBookingById(bookingId);
        if(!bookingDeleteById.isPresent()){
            throw new Exception("The booking id does not exist: " + bookingId);
        }else{
            bookingsRepository.deleteById(bookingDeleteById.get());
        }
    }

}

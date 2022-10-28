package unibague.sistemas.bienestar_universitario.booking.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import unibague.sistemas.bienestar_universitario.booking.infrastructure.entities.BookingEntity;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public interface BookingRepositoryJpa extends JpaRepository<BookingEntity, Long> {
    Optional<List<BookingEntity>> findByDate(Calendar date);
    @Query(value = "select * from reservas, persona,offered_service\n" +
            "where reservas.personaid = persona.id and reservas.servicioofertadoid = offered_service.id \n" +
            "and reservas.personaid = ?1 order by date ASC", nativeQuery = true)
    Optional<List<BookingEntity>> findByPersonId(Long personId);

    @Query(value = "select * from reservas, persona,offered_service\n" +
            "where cast(reservas.date as date) = CURRENT_DATE and reservas.personaid = persona.id " +
            " and reservas.servicioofertadoid = offered_service.id \n" +
            "and reservas.servicioofertadoid = ?1 order by date ASC", nativeQuery = true)
    Optional<List<BookingEntity>> findByOfferedServiceId(Long offeredServiceId);

    Optional<List<BookingEntity>> findByPersonIdAndDate(Long personId, Calendar date);
    void deleteByPersonId(BookingEntity bookingEntity);
    @Modifying
    @Query(value = "delete from reservas where id = ?1", nativeQuery = true)
    void deleteById(Long id);
}

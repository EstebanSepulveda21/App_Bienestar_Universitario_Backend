package unibague.sistemas.bienestar_universitario.booking.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import unibague.sistemas.bienestar_universitario.offeredService.infrastructure.entities.OfferedServiceEntity;
import unibague.sistemas.bienestar_universitario.person.infrastructure.entities.PersonEntity;

import javax.persistence.*;
import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Booking")
@Table(name = "reservas")
public class BookingEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "date",
            nullable = false,
            columnDefinition = "timestamp without time zone")
    private Calendar date;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "personaid")
    private PersonEntity personId;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "servicioofertadoid")
    private OfferedServiceEntity offeredServiceId;
}

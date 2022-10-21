package unibague.sistemas.bienestar_universitario.booking.infrastructure.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unibague.sistemas.bienestar_universitario.booking.application.create.BookingRequest;
import unibague.sistemas.bienestar_universitario.booking.domain.create.BookingCreator;
import unibague.sistemas.bienestar_universitario.booking.infrastructure.entities.BookingEntity;
import unibague.sistemas.bienestar_universitario.offeredService.infrastructure.entities.OfferedServiceEntity;
import unibague.sistemas.bienestar_universitario.person.infrastructure.entities.PersonEntity;
import unibague.sistemas.bienestar_universitario.sendMail.service.SendMailService;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*") //http://localhost:4200
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/booking")
public class BookingController {

    private final BookingCreator bookingCreator;

    @Autowired
    private SendMailService sendMailService;

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> create(@RequestBody Request booking){
        BookingRequest bookingRequestSave = new BookingRequest(
                booking.getId(), booking.getDate(), booking.getPersonId(),
                booking.getOfferedServiceId()
        );

        if(booking.getOfferedServiceId().getId() == 1)
        {
            String subject = "Mensaje de prueba Santa Ana";
            String msg = "Sede Santa Ana prueba ";
            sendMailService.sendMail("cristiansv999155@gmail.com", booking.getPersonId().getEmail(), subject, msg);
        }else if(booking.getOfferedServiceId().getId() == 2) {
            String subject = "Mensaje de prueba Universidad de ibague";
            String msg = "Sede Unibague";
            sendMailService.sendMail("cristiansv999155@gmail.com", booking.getPersonId().getEmail(), subject, msg);
        }

        bookingCreator.create(bookingRequestSave);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/booking/create" + bookingRequestSave.getPersonId());
        return new ResponseEntity<HttpStatus>(httpHeaders,HttpStatus.CREATED);
    }

    @GetMapping("/allBookings")
    public ResponseEntity<List<BookingEntity>> getAllBookings(){
        if(ResponseEntity.ok().body(this.bookingCreator.getAll()).getStatusCode() == HttpStatus.OK){
            return ResponseEntity.ok().body(this.bookingCreator.getAll());
        }else{
            return new ResponseEntity<List<BookingEntity>>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/searchByServiceId/{serviceId}")
    public ResponseEntity<List<BookingEntity>> getBookingsByServiceId(@PathVariable("serviceId") Long serviceId){
        Optional<List<BookingEntity>> bookingById = bookingCreator.findBookingByOfferedServiceId(serviceId);
        if(!bookingById.isPresent()){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location","/api/v1/booking/searchById/" + serviceId);
            return new ResponseEntity<List<BookingEntity>>(httpHeaders,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<BookingEntity>>(bookingById.get(),HttpStatus.OK);

    }




    @GetMapping("/searchById/{bookingId}")
    public ResponseEntity<BookingEntity> bookingById(@PathVariable("bookingId") Long bookingId){
        Optional<BookingEntity> bookingById = bookingCreator.findBookingById(bookingId);
        if(!bookingById.isPresent()){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location","/api/v1/booking/searchById/" + bookingId);
            return new ResponseEntity<BookingEntity>(httpHeaders,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BookingEntity>(bookingById.get(),HttpStatus.OK);
    }

    @DeleteMapping("/deleteBooking/{bookingId}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("bookingId") Long bookingId) throws Exception {
        bookingCreator.deleteBookingById(bookingId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/booking/deleteBooking/"+bookingId);
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
}

@Data
final class Request{
    private Long id;
    private Calendar date;
    private PersonEntity personId;
    private OfferedServiceEntity offeredServiceId;
}
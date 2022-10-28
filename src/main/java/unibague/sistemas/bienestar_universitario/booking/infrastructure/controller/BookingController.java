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

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
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
            httpHeaders.add("location","/api/v1/booking/searchByServiceId/" + serviceId);
            return new ResponseEntity<List<BookingEntity>>(httpHeaders,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<BookingEntity>>(bookingById.get(),HttpStatus.OK);

    }

    @GetMapping("/searchBookingByPersonId/{personId}")
    public ResponseEntity<List<BookingEntity>> getBookingByPersonId(@PathVariable("personId") Long personId){
        Optional<List<BookingEntity>> bookingByPersonId = bookingCreator.findBookingByPersonId(personId);
        if(!bookingByPersonId.isPresent()){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location","/api/v1/booking/searchBookingByPersonId/" + personId);
            return new ResponseEntity<List<BookingEntity>>(httpHeaders,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<BookingEntity>>(bookingByPersonId.get(),HttpStatus.OK);
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

    @GetMapping("/searchByDate/{bookingDate}")
    public ResponseEntity<List<BookingEntity>> bookingByDate(@PathVariable("bookingDate") String bookingDate){
        Calendar dateSearch = Calendar.getInstance();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz");
        ZonedDateTime zdt = ZonedDateTime.parse(bookingDate,f);
        Date date = Date.from(zdt.toInstant());
        dateSearch.setTime(date);
        Optional<List<BookingEntity>> bookingByDate = bookingCreator.findBookingByDate(dateSearch);
        if(!bookingByDate.isPresent()){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location","/api/v1/booking/searchByDate/" + dateSearch);
            return new ResponseEntity<List<BookingEntity>>(httpHeaders,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<BookingEntity>>(bookingByDate.get(),HttpStatus.OK);
    }

    @GetMapping("/searchByPersonId/{bookingPersonId}/And/Date/{bookingDate}")
    public ResponseEntity<List<BookingEntity>> bookingByPersonIdAndDate(@PathVariable("bookingPersonId") Long personId,
                                                                        @PathVariable("bookingDate") String bookingDate){
        Calendar dateSearch = Calendar.getInstance();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz");
        ZonedDateTime zdt = ZonedDateTime.parse(bookingDate,f);
        Date date = Date.from(zdt.toInstant());
        dateSearch.setTime(date);
        Optional<List<BookingEntity>> bookingByPersonIdAndDate = bookingCreator.findBookingByPersonIdAndDate(personId,dateSearch);
        if(!bookingByPersonIdAndDate.isPresent()){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location","/api/v1/booking/searchByPersonId/" + personId + "/And/Date/" + dateSearch);
            return new ResponseEntity<List<BookingEntity>>(httpHeaders,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<BookingEntity>>(bookingByPersonIdAndDate.get(),HttpStatus.OK);
    }

    @DeleteMapping("/deleteStupid/{bookingId}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("bookingId") Long bookingId) throws Exception {
        try {
            bookingCreator.deleteBookingById(bookingId);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location", "/api/v1/booking/deleteBooking/" + bookingId);
            return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.valueOf(e.getMessage()),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteBooking/{id}")
    public ResponseEntity<HttpStatus> deletebyid(@PathVariable("id") Long id) throws Exception {
        try {
            bookingCreator.deleteBookingByIdExample(id);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location", "/api/v1/booking/deleteBooking/" + id);
            return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.valueOf(e.getMessage()),HttpStatus.NOT_FOUND);
        }
    }
}

@Data
final class Request{
    private Long id;
    private Calendar date;
    private PersonEntity personId;
    private OfferedServiceEntity offeredServiceId;
}
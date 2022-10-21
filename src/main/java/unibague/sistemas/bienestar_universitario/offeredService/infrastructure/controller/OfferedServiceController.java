package unibague.sistemas.bienestar_universitario.offeredService.infrastructure.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unibague.sistemas.bienestar_universitario.campus.infrastructure.entities.CampusEntity;
import unibague.sistemas.bienestar_universitario.offeredService.application.create.OfferedServiceRequest;
import unibague.sistemas.bienestar_universitario.offeredService.domain.create.OfferedServiceCreator;
import unibague.sistemas.bienestar_universitario.offeredService.infrastructure.entities.OfferedServiceEntity;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*") //http://localhost:4200
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/offeredService")
public class OfferedServiceController {

    private final OfferedServiceCreator offeredServiceCreator;

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> create(@RequestBody Request offeredService){
        OfferedServiceRequest offeredServiceSave = new OfferedServiceRequest(
                offeredService.getId(), offeredService.getCampusId(), offeredService.getName(),
                offeredService.getDescription(), offeredService.getCapacity()
        );
        offeredServiceCreator.create(offeredServiceSave);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location","/api/v1/offeredService/" +
                offeredServiceSave.getName());
        return new ResponseEntity<HttpStatus>(httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/searchOfferedServiceById/{id}")
    public ResponseEntity<OfferedServiceEntity> offeredServiceById(@PathVariable("id") Long serviceId){
        Optional<OfferedServiceEntity> serviceByid = offeredServiceCreator.findOfferedServiceById(serviceId);
        if(!serviceByid.isPresent()){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location","/api/v1/offeredService/" + serviceId);
            return new ResponseEntity<OfferedServiceEntity>(httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<OfferedServiceEntity>(serviceByid.get(), HttpStatus.OK);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<OfferedServiceEntity>> getAllOfferedService(){
        if(ResponseEntity.ok().body(this.offeredServiceCreator.getAll()).getStatusCode() == HttpStatus.OK){
            return ResponseEntity.ok().body(this.offeredServiceCreator.getAll());
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

@Data
final class Request{
    private Long id;
    private CampusEntity campusId;
    private String name;
    private String description;
    private Long capacity;
}
package unibague.sistemas.bienestar_universitario.campus.infrastructure.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unibague.sistemas.bienestar_universitario.campus.application.create.CampusRequest;
import unibague.sistemas.bienestar_universitario.campus.domain.create.CampusCreator;
import unibague.sistemas.bienestar_universitario.campus.infrastructure.entities.CampusEntity;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/campus")
public class CampusController {
    private CampusCreator campusCreator;

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> create(@RequestBody Request campus){
        CampusRequest campusSave = new CampusRequest(campus.getId(), campus.getName(), campus.getAddress());
        campusCreator.create(campusSave);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location","/api/v1/campus/" + campusSave);
        return new ResponseEntity<HttpStatus>(httpHeaders,HttpStatus.CREATED);
    }

    @GetMapping("/searchCampusById/{id}")
    public ResponseEntity<CampusEntity> campusById(@PathVariable("id") Long campusId){
        Optional<CampusEntity> campusById = campusCreator.findCampusById(campusId);
        if(!campusById.isPresent()){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location","/api/v1/campus/" + campusId);
            return new ResponseEntity<CampusEntity>(httpHeaders,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CampusEntity>(campusById.get(),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CampusEntity>> getAllCampus(){
        if(ResponseEntity.ok().body(this.campusCreator.getAll()).getStatusCode() == HttpStatus.OK){
            return ResponseEntity.ok().body(this.campusCreator.getAll());
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
@Data
final class Request{
    private Long id;
    private String name;
    private String address;
}
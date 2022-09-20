package unibague.sistemas.bienestar_universitario.campus.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unibague.sistemas.bienestar_universitario.campus.aplication.create.CampusRequest;
import unibague.sistemas.bienestar_universitario.campus.domain.create.CampusCreator;
import unibague.sistemas.bienestar_universitario.campus.infrastructure.entities.CampusEntity;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/campus")
public class CampusController {
    private CampusCreator campusCreator;

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody Request campus){
        CampusRequest campusSave = new CampusRequest(campus.getId(), campus.getName(), campus.getAddress());
        campusCreator.create(campusSave);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location","/api/v1/campus/" + campusSave);
        return new ResponseEntity<HttpStatus>(httpHeaders,HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CampusEntity> campusById(@PathVariable("id") Long campusId){
        Optional<CampusEntity> campusById = campusCreator.findCampusById(campusId);
        if(!campusById.isPresent()){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location","/api/v1/campus/" + campusId);
            return new ResponseEntity<CampusEntity>(httpHeaders,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CampusEntity>(campusById.get(),HttpStatus.OK);
    }
}
@Data
final class Request{
    private Long id;
    private String name;
    private String address;
}
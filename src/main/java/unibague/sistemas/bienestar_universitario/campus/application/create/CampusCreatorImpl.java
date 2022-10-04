package unibague.sistemas.bienestar_universitario.campus.application.create;


import lombok.AllArgsConstructor;
import unibague.sistemas.bienestar_universitario.campus.domain.Campus;
import unibague.sistemas.bienestar_universitario.campus.domain.CampusRepository;
import unibague.sistemas.bienestar_universitario.campus.domain.create.CampusCreator;
import unibague.sistemas.bienestar_universitario.campus.infrastructure.entities.CampusEntity;
import unibague.sistemas.bienestar_universitario.campus.infrastructure.mapper.CampusMapper;
import unibague.sistemas.bienestar_universitario.shared.domain.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CampusCreatorImpl implements CampusCreator {

    private final CampusRepository campusRepository;
    private final CampusMapper campusMapper;

    @Override
    public void create(CampusRequest campusRequest) {
        Campus campus = campusMapper.requestToCampus(campusRequest);
        campusRepository.save(campus);
    }

    @Override
    public Optional<CampusEntity> findCampusById(Long campusId) {
        return campusRepository.findCampusById(campusId);
    }

    @Override
    public List<CampusEntity> getAll() {
        return campusRepository.getAll();
    }

    @Override
    public void update(Long id, CampusRequest campusRequest) throws Exception {
        Optional<CampusEntity> campusUpdate = findCampusById(id);
        if(!campusUpdate.isPresent()){
            throw new Exception("The id does not exist: " + id);
        }else{
            Campus campus = campusMapper.requestToCampus(campusRequest);
            campusRepository.save(campus);
        }
    }

    @Override
    public void deleteCampusById(Long campusId) throws Exception {
        Optional<CampusEntity> campusDelete = findCampusById(campusId);
        if(!campusDelete.isPresent()){
            throw new Exception("The id does not exist: " + campusId);
        }else{
            campusRepository.delete(campusDelete.get());
        }
    }
}

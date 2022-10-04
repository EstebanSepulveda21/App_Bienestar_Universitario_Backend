package unibague.sistemas.bienestar_universitario.campus.domain.create;

import unibague.sistemas.bienestar_universitario.campus.application.create.CampusRequest;
import unibague.sistemas.bienestar_universitario.campus.infrastructure.entities.CampusEntity;

import java.util.List;
import java.util.Optional;

public interface CampusCreator {
    void create(CampusRequest campusRequest);
    Optional<CampusEntity> findCampusById(Long campusId);
    List<CampusEntity> getAll();
    void update(Long id, CampusRequest campusRequest) throws Exception;
    void deleteCampusById(Long campusId) throws Exception;
}

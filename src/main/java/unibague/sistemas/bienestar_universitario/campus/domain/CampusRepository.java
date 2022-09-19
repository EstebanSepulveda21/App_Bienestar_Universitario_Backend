package unibague.sistemas.bienestar_universitario.campus.domain;

import unibague.sistemas.bienestar_universitario.campus.infrastructure.entities.CampusEntity;

import java.util.List;
import java.util.Optional;

public interface CampusRepository {
    void save(Campus campus);
    Optional<CampusEntity> findCampusById(Long id);
    void delete(CampusEntity campus);
    List<CampusEntity> getAll();
}

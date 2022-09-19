package unibague.sistemas.bienestar_universitario.campus.infrastructure;

import lombok.AllArgsConstructor;
import unibague.sistemas.bienestar_universitario.campus.domain.Campus;
import unibague.sistemas.bienestar_universitario.campus.domain.CampusRepository;
import unibague.sistemas.bienestar_universitario.campus.infrastructure.entities.CampusEntity;
import unibague.sistemas.bienestar_universitario.campus.infrastructure.mapper.CampusMapper;
import unibague.sistemas.bienestar_universitario.shared.domain.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CampusRepositoryPostgres implements CampusRepository {

    private final CampusRepositoryJpa campusRepositoryJpa;
    private final CampusMapper campusMapper;

    @Override
    public void save(Campus campus) {
        campusRepositoryJpa.save(campusMapper.campusToCampusEntity(campus));
    }

    @Override
    public Optional<CampusEntity> findCampusById(Long id) {
        return campusRepositoryJpa.findById(id);
    }

    @Override
    public void delete(CampusEntity campus) {
        campusRepositoryJpa.deleteById(campus.getId());
    }

    @Override
    public List<CampusEntity> getAll() {
        return campusRepositoryJpa.findAll();
    }
}

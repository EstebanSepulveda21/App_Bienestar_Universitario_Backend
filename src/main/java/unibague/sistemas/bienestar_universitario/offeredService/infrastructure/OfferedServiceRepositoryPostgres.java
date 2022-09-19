package unibague.sistemas.bienestar_universitario.offeredService.infrastructure;

import lombok.AllArgsConstructor;
import unibague.sistemas.bienestar_universitario.offeredService.domain.OfferedService;
import unibague.sistemas.bienestar_universitario.offeredService.domain.OfferedServicesRepository;
import unibague.sistemas.bienestar_universitario.offeredService.infrastructure.entities.OfferedServiceEntity;
import unibague.sistemas.bienestar_universitario.offeredService.infrastructure.mapper.OfferedServiceMapper;
import unibague.sistemas.bienestar_universitario.shared.domain.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class OfferedServiceRepositoryPostgres implements OfferedServicesRepository {

    private final OfferedServiceRepositoryJpa serviceRepositoryJpa;
    private final OfferedServiceMapper serviceMapper;

    @Override
    public void save(OfferedService offeredService) {
        serviceRepositoryJpa.save(serviceMapper.offeredServiceToOfferedServiceEntity(offeredService));
    }

    @Override
    public Optional<OfferedServiceEntity> findOfferedServiceById(Long id) {
        return serviceRepositoryJpa.findById(id);
    }

    @Override
    public void delete(OfferedServiceEntity offeredService) {
        serviceRepositoryJpa.deleteById(offeredService.getId());
    }

    @Override
    public List<OfferedServiceEntity> getAll() {
        return serviceRepositoryJpa.findAll();
    }
}

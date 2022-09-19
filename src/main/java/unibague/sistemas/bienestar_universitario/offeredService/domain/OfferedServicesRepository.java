package unibague.sistemas.bienestar_universitario.offeredService.domain;

import unibague.sistemas.bienestar_universitario.offeredService.infrastructure.entities.OfferedServiceEntity;

import java.util.List;
import java.util.Optional;

public interface OfferedServicesRepository {
    void save(OfferedService offeredService);
    Optional<OfferedServiceEntity> findOfferedServiceById(Long id);
    void delete(OfferedServiceEntity offeredService);
    List<OfferedServiceEntity> getAll();
}

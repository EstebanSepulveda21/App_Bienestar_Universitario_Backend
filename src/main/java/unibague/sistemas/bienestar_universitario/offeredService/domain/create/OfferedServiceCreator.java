package unibague.sistemas.bienestar_universitario.offeredService.domain.create;

import unibague.sistemas.bienestar_universitario.offeredService.application.create.OfferedServiceRequest;
import unibague.sistemas.bienestar_universitario.offeredService.infrastructure.entities.OfferedServiceEntity;

import java.util.List;
import java.util.Optional;

public interface OfferedServiceCreator {

    void create(OfferedServiceRequest offeredServiceRequest);
    Optional<OfferedServiceEntity> findOfferedServiceById(Long offeredServiceId);
    List<OfferedServiceEntity> getAll();

    void update(Long id, OfferedServiceRequest offeredServiceRequest) throws Exception;
    void deleteOfferedServiceById(Long offeredServiceId) throws Exception;
}

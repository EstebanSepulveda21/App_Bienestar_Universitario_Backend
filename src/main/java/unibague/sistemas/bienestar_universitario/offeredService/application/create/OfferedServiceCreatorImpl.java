package unibague.sistemas.bienestar_universitario.offeredService.application.create;

import lombok.AllArgsConstructor;
import unibague.sistemas.bienestar_universitario.offeredService.domain.OfferedService;
import unibague.sistemas.bienestar_universitario.offeredService.domain.OfferedServicesRepository;
import unibague.sistemas.bienestar_universitario.offeredService.domain.create.OfferedServiceCreator;
import unibague.sistemas.bienestar_universitario.offeredService.infrastructure.entities.OfferedServiceEntity;
import unibague.sistemas.bienestar_universitario.offeredService.infrastructure.mapper.OfferedServiceMapper;
import unibague.sistemas.bienestar_universitario.shared.domain.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OfferedServiceCreatorImpl implements OfferedServiceCreator {

    private final OfferedServicesRepository servicesRepository;
    private final OfferedServiceMapper serviceMapper;

    @Override
    public void create(OfferedServiceRequest offeredServiceRequest) {
        OfferedService offeredService = serviceMapper.requestToOfferedService(offeredServiceRequest);
        servicesRepository.save(offeredService);
    }

    @Override
    public Optional<OfferedServiceEntity> findOfferedServiceById(Long offeredServiceId) {
        return servicesRepository.findOfferedServiceById(offeredServiceId);
    }

    @Override
    public List<OfferedServiceEntity> getAll() {
        return servicesRepository.getAll();
    }

    @Override
    public void update(Long id, OfferedServiceRequest offeredServiceRequest) throws Exception {
        Optional<OfferedServiceEntity> offeredServiceUpdate = findOfferedServiceById(id);
        if(!offeredServiceUpdate.isPresent()){
            throw new Exception("The id does not exist: " + id);
        }else{
            OfferedService offeredService = serviceMapper.requestToOfferedService(offeredServiceRequest);
            servicesRepository.save(offeredService);
        }
    }

    @Override
    public void deleteOfferedServiceById(Long offeredServiceId) throws Exception {
        Optional<OfferedServiceEntity> offeredServiceDelete = findOfferedServiceById(offeredServiceId);
        if(!offeredServiceDelete.isPresent()){
            throw new Exception("The id does not exist: " + offeredServiceId);
        }else{
            servicesRepository.delete(offeredServiceDelete.get());
        }
    }
}

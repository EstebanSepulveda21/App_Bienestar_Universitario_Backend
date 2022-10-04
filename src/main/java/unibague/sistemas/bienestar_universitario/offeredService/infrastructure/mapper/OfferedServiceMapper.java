package unibague.sistemas.bienestar_universitario.offeredService.infrastructure.mapper;

import org.mapstruct.Mapper;
import unibague.sistemas.bienestar_universitario.offeredService.application.create.OfferedServiceRequest;
import unibague.sistemas.bienestar_universitario.offeredService.domain.OfferedService;
import unibague.sistemas.bienestar_universitario.offeredService.domain.valueObjects.*;
import unibague.sistemas.bienestar_universitario.offeredService.infrastructure.entities.OfferedServiceEntity;

@Mapper(componentModel = "spring")
public abstract class OfferedServiceMapper {

    public OfferedService requestToOfferedService(OfferedServiceRequest request){
        return OfferedService.builder()
                .id(new OfferedServiceId(request.getId()))
                .campusId(new OfferedServiceCampusId(request.getCampusId()))
                .name(new OfferedServiceName(request.getName()))
                .description(new OfferedServiceDescription(request.getDescription()))
                .capacity(new OfferedServiceCapacity(request.getCapacity()))
                .build();
    }

    public OfferedServiceEntity offeredServiceToOfferedServiceEntity(OfferedService offeredService){
        return OfferedServiceEntity.builder()
                .id(offeredService.getId().value())
                .campusId(offeredService.getCampusId().value())
                .name(offeredService.getName().value())
                .description(offeredService.getDescription().value())
                .capacity(offeredService.getCapacity().value())
                .build();
    }
}

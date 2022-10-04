package unibague.sistemas.bienestar_universitario.campus.infrastructure.mapper;

import org.mapstruct.Mapper;
import unibague.sistemas.bienestar_universitario.campus.application.create.CampusRequest;
import unibague.sistemas.bienestar_universitario.campus.domain.Campus;
import unibague.sistemas.bienestar_universitario.campus.domain.valueObjects.CampusAddress;
import unibague.sistemas.bienestar_universitario.campus.domain.valueObjects.CampusId;
import unibague.sistemas.bienestar_universitario.campus.domain.valueObjects.CampusName;
import unibague.sistemas.bienestar_universitario.campus.infrastructure.entities.CampusEntity;

@Mapper(componentModel = "spring")
public abstract class CampusMapper {
    public Campus requestToCampus(CampusRequest request){
        return Campus.builder()
                .id(new CampusId(request.getId()))
                .name(new CampusName(request.getName()))
                .address(new CampusAddress(request.getAddress()))
                .build();
    }

    public CampusEntity campusToCampusEntity(Campus campus){
        return CampusEntity.builder()
                .id(campus.getId().value())
                .name(campus.getName().value())
                .address(campus.getAddress().value())
                .build();
    }
}

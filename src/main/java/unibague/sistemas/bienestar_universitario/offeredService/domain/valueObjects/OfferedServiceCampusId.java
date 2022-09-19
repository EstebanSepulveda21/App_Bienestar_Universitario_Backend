package unibague.sistemas.bienestar_universitario.offeredService.domain.valueObjects;

import unibague.sistemas.bienestar_universitario.campus.infrastructure.entities.CampusEntity;
import unibague.sistemas.bienestar_universitario.shared.domain.valueObjects.CampusEntityValueObject;

public class OfferedServiceCampusId extends CampusEntityValueObject {
    public OfferedServiceCampusId(CampusEntity value) {
        super(value);
    }
}

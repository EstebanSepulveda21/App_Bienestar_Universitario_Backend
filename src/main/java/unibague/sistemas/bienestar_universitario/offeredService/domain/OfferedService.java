package unibague.sistemas.bienestar_universitario.offeredService.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import unibague.sistemas.bienestar_universitario.offeredService.domain.valueObjects.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfferedService {
    public OfferedServiceId id;
    public OfferedServiceCampusId campusId;
    public OfferedServiceName name;
    public OfferedServiceDescription description;
    public OfferedServiceCapacity capacity;
}

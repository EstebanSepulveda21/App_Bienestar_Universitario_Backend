package unibague.sistemas.bienestar_universitario.campus.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import unibague.sistemas.bienestar_universitario.campus.domain.valueObjects.CampusAddress;
import unibague.sistemas.bienestar_universitario.campus.domain.valueObjects.CampusId;
import unibague.sistemas.bienestar_universitario.campus.domain.valueObjects.CampusName;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Campus {
    public CampusId id;
    public CampusName name;
    public CampusAddress address;
}

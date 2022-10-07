package unibague.sistemas.bienestar_universitario.offeredService.application.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import unibague.sistemas.bienestar_universitario.campus.infrastructure.entities.CampusEntity;

@Data
@AllArgsConstructor
@Getter
@Builder
public final class OfferedServiceRequest {
    private Long id;
    private CampusEntity CampusId;
    private String name;
    private String description;
    private Long capacity;
}

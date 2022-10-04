package unibague.sistemas.bienestar_universitario.campus.application.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
@Builder
public final class CampusRequest {
    private Long id;
    private String name;
    private String address;
}

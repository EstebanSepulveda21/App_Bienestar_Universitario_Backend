package unibague.sistemas.bienestar_universitario.offeredService.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import unibague.sistemas.bienestar_universitario.offeredService.infrastructure.entities.OfferedServiceEntity;

public interface OfferedServiceRepositoryJpa extends JpaRepository<OfferedServiceEntity, Long> {
}

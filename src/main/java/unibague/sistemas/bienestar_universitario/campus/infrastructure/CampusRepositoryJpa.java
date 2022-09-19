package unibague.sistemas.bienestar_universitario.campus.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import unibague.sistemas.bienestar_universitario.campus.infrastructure.entities.CampusEntity;

public interface CampusRepositoryJpa extends JpaRepository<CampusEntity, Long> {
}

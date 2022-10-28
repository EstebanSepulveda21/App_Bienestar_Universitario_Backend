package unibague.sistemas.bienestar_universitario.offeredService.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import unibague.sistemas.bienestar_universitario.offeredService.infrastructure.entities.OfferedServiceEntity;

public interface OfferedServiceRepositoryJpa extends JpaRepository<OfferedServiceEntity, Long> {
    @Modifying
    @Query(value = "delete from offered_service where id = ?1", nativeQuery = true)
    void deleteById(Long id);
}

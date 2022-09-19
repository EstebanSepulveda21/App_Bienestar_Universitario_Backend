package unibague.sistemas.bienestar_universitario.person.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import unibague.sistemas.bienestar_universitario.person.infrastructure.entities.PersonEntity;

import java.util.Optional;

public interface PersonRepositoryJpa extends JpaRepository<PersonEntity, Long> {
    Optional<PersonEntity> findByEmailAndPassword(String email, String password);
}

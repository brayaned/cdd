package app.repository.cdd;

import app.Entity.cdd.VariablesRiesgoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariablesRiesgoRepository extends JpaRepository<VariablesRiesgoEntity, Long> {
}

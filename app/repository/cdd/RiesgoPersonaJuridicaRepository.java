package app.repository.cdd;

import app.Entity.cdd.RiesgoPersonaJuridicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiesgoPersonaJuridicaRepository extends JpaRepository<RiesgoPersonaJuridicaEntity, Long> {
}

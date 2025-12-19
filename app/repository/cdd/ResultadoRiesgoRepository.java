package app.repository.cdd;

import app.Entity.cdd.ResultadoRiesgoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoRiesgoRepository extends JpaRepository<ResultadoRiesgoEntity, Long> {
}

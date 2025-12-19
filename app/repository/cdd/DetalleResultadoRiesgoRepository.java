package app.repository.cdd;

import app.Entity.cdd.DetalleResultadoRiesgoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleResultadoRiesgoRepository extends JpaRepository<DetalleResultadoRiesgoEntity, Long> {
}

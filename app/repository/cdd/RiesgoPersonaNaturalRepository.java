package app.repository.cdd;

import app.Entity.cdd.RiesgoPersonaNaturalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiesgoPersonaNaturalRepository extends JpaRepository<RiesgoPersonaNaturalEntity, Long> {
}

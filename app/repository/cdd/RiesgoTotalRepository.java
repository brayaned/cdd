package app.repository.cdd;

import app.Entity.cdd.RiesgoTotalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiesgoTotalRepository extends JpaRepository<RiesgoTotalEntity, Long> {
}

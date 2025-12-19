package app.repository.cdd;

import app.Entity.cdd.CatalogoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoRepository extends JpaRepository<CatalogoEntity, String> {
}

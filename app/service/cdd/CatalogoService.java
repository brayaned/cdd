package app.service.cdd;

import app.Entity.cdd.CatalogoEntity;
import app.dto.cdd.CatalogoRequest;
import app.dto.cdd.CatalogoResponse;
import app.mapper.cdd.CatalogoMapper;
import app.repository.cdd.CatalogoRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogoService {

    private final CatalogoRepository catalogoRepository;
    private final CatalogoMapper catalogoMapper;

    public CatalogoService(
            CatalogoRepository catalogoRepository,
            CatalogoMapper catalogoMapper
    ) {
        this.catalogoRepository = catalogoRepository;
        this.catalogoMapper = catalogoMapper;
    }

    // Guardar
    @Transactional
    public CatalogoResponse guardar(CatalogoRequest request) {
        String currentUser = currentUser();
        LocalDateTime now = LocalDateTime.now();

        CatalogoEntity entity = catalogoMapper.toEntity(request);
        entity.setFechaCreacion(now);
        entity.setUsuarioCreacion(currentUser);

        CatalogoEntity savedEntity = catalogoRepository.save(entity);

        CatalogoResponse response = catalogoMapper.toResponse(savedEntity);
        response.setMensaje("Catálogo guardado exitosamente");

        return response;
    }

    // Actualizar
    @Transactional
    public CatalogoResponse actualizar(String id, CatalogoRequest request) {
        CatalogoEntity entity = catalogoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe catálogo con id: " + id));

        String currentUser = currentUser();
        LocalDateTime now = LocalDateTime.now();

        catalogoMapper.updateEntityFromRequest(request, entity);
        entity.setFechaUltimaModificacion(now);
        entity.setUsuarioUltimaModificacion(currentUser);

        CatalogoEntity updatedEntity = catalogoRepository.save(entity);

        CatalogoResponse response = catalogoMapper.toResponse(updatedEntity);
        response.setMensaje("Catálogo actualizado exitosamente");

        return response;
    }

    // Listar todos
    public List<CatalogoResponse> listar() {
        List<CatalogoEntity> entities = catalogoRepository.findAll();
        return entities.stream()
                .map(catalogoMapper::toResponse)
                .collect(Collectors.toList());
    }

    // Obtener por ID
    public CatalogoResponse obtenerPorId(String id) {
        CatalogoEntity entity = catalogoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe catálogo con id: " + id));

        return catalogoMapper.toResponse(entity);
    }

    // Eliminar
    @Transactional
    public void eliminar(String id) {
        CatalogoEntity entity = catalogoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe catálogo con id: " + id));

        catalogoRepository.delete(entity);
    }

    // Método auxiliar para obtener el usuario actual
    private String currentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getName() == null) {
            return "SYSTEM";
        }
        return auth.getName();
    }
}

package app.service.cdd;

import app.Entity.cdd.RiesgoTotalEntity;
import app.dto.cdd.RiesgoTotalRequest;
import app.dto.cdd.RiesgoTotalResponse;
import app.mapper.cdd.RiesgoTotalMapper;
import app.repository.cdd.RiesgoTotalRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RiesgoTotalService {

    private final RiesgoTotalRepository riesgoTotalRepository;
    private final RiesgoTotalMapper riesgoTotalMapper;

    public RiesgoTotalService(
            RiesgoTotalRepository riesgoTotalRepository,
            RiesgoTotalMapper riesgoTotalMapper
    ) {
        this.riesgoTotalRepository = riesgoTotalRepository;
        this.riesgoTotalMapper = riesgoTotalMapper;
    }

    // Guardar
    @Transactional
    public RiesgoTotalResponse guardar(RiesgoTotalRequest request) {
        String currentUser = currentUser();
        LocalDateTime now = LocalDateTime.now();

        RiesgoTotalEntity entity = riesgoTotalMapper.toEntity(request);
        entity.setFechaCreacion(now);
        entity.setUsuarioCreacion(currentUser);

        RiesgoTotalEntity savedEntity = riesgoTotalRepository.save(entity);

        RiesgoTotalResponse response = riesgoTotalMapper.toResponse(savedEntity);
        response.setMensaje("Riesgo Total guardado exitosamente");

        return response;
    }

    // Actualizar
    @Transactional
    public RiesgoTotalResponse actualizar(Long id, RiesgoTotalRequest request) {
        RiesgoTotalEntity entity = riesgoTotalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe registro con id: " + id));

        String currentUser = currentUser();
        LocalDateTime now = LocalDateTime.now();

        riesgoTotalMapper.updateEntityFromRequest(request, entity);
        entity.setFechaUltimaModificacion(now);
        entity.setUsuarioUltimaModificacion(currentUser);

        RiesgoTotalEntity updatedEntity = riesgoTotalRepository.save(entity);

        RiesgoTotalResponse response = riesgoTotalMapper.toResponse(updatedEntity);
        response.setMensaje("Riesgo Total actualizado exitosamente");

        return response;
    }

    // Listar todos
    public List<RiesgoTotalResponse> listar() {
        List<RiesgoTotalEntity> entities = riesgoTotalRepository.findAll();
        return entities.stream()
                .map(riesgoTotalMapper::toResponse)
                .collect(Collectors.toList());
    }

    // Obtener por ID
    public RiesgoTotalResponse obtenerPorId(Long id) {
        RiesgoTotalEntity entity = riesgoTotalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe registro con id: " + id));

        return riesgoTotalMapper.toResponse(entity);
    }

    // Eliminar
    @Transactional
    public void eliminar(Long id) {
        RiesgoTotalEntity entity = riesgoTotalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe registro con id: " + id));

        riesgoTotalRepository.delete(entity);
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

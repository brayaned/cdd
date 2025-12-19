package app.service.cdd;

import app.Entity.cdd.VariablesRiesgoEntity;
import app.dto.cdd.VariablesRiesgoRequest;
import app.dto.cdd.VariablesRiesgoResponse;
import app.mapper.cdd.VariablesRiesgoMapper;
import app.repository.cdd.VariablesRiesgoRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VariablesRiesgoService {

    private final VariablesRiesgoRepository variablesRiesgoRepository;
    private final VariablesRiesgoMapper variablesRiesgoMapper;

    public VariablesRiesgoService(
            VariablesRiesgoRepository variablesRiesgoRepository,
            VariablesRiesgoMapper variablesRiesgoMapper
    ) {
        this.variablesRiesgoRepository = variablesRiesgoRepository;
        this.variablesRiesgoMapper = variablesRiesgoMapper;
    }

    // Guardar
    @Transactional
    public VariablesRiesgoResponse guardar(VariablesRiesgoRequest request) {
        String currentUser = currentUser();
        LocalDateTime now = LocalDateTime.now();

        VariablesRiesgoEntity entity = variablesRiesgoMapper.toEntity(request);
        entity.setFechaCreacion(now);
        entity.setUsuarioCreacion(currentUser);

        VariablesRiesgoEntity savedEntity = variablesRiesgoRepository.save(entity);

        VariablesRiesgoResponse response = variablesRiesgoMapper.toResponse(savedEntity);
        response.setMensaje("Variables de Riesgo guardadas exitosamente");

        return response;
    }

    // Listar todos
    public List<VariablesRiesgoResponse> listar() {
        List<VariablesRiesgoEntity> entities = variablesRiesgoRepository.findAll();
        return entities.stream()
                .map(variablesRiesgoMapper::toResponse)
                .collect(Collectors.toList());
    }

    // Obtener por ID
    public VariablesRiesgoResponse obtenerPorId(Long id) {
        VariablesRiesgoEntity entity = variablesRiesgoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe registro con id: " + id));

        return variablesRiesgoMapper.toResponse(entity);
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

package app.service.cdd;

import app.Entity.cdd.RiesgoPersonaJuridicaEntity;
import app.Entity.cdd.RiesgoPersonaNaturalEntity;
import app.dto.cdd.RiesgoPersonaJuridicaRequest;
import app.dto.cdd.RiesgoPersonaJuridicaResponse;
import app.dto.cdd.RiesgoPersonaNaturalRequest;
import app.dto.cdd.RiesgoPersonaNaturalResponse;
import app.mapper.cdd.RiesgoPersonaJuridicaMapper;
import app.mapper.cdd.RiesgoPersonaNaturalMapper;
import app.repository.cdd.RiesgoPersonaJuridicaRepository;
import app.repository.cdd.RiesgoPersonaNaturalRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RiesgoService {

    private final RiesgoPersonaNaturalRepository personaNaturalRepository;
    private final RiesgoPersonaJuridicaRepository personaJuridicaRepository;
    private final RiesgoPersonaNaturalMapper personaNaturalMapper;
    private final RiesgoPersonaJuridicaMapper personaJuridicaMapper;

    public RiesgoService(
            RiesgoPersonaNaturalRepository personaNaturalRepository,
            RiesgoPersonaJuridicaRepository personaJuridicaRepository,
            RiesgoPersonaNaturalMapper personaNaturalMapper,
            RiesgoPersonaJuridicaMapper personaJuridicaMapper
    ) {
        this.personaNaturalRepository = personaNaturalRepository;
        this.personaJuridicaRepository = personaJuridicaRepository;
        this.personaNaturalMapper = personaNaturalMapper;
        this.personaJuridicaMapper = personaJuridicaMapper;
    }

    // Persona Natural - Guardar/Actualizar
    @Transactional
    public RiesgoPersonaNaturalResponse guardarPersonaNatural(RiesgoPersonaNaturalRequest request) {
        // Obtener usuario actual
        String currentUser = currentUser();
        LocalDateTime now = LocalDateTime.now();

        // Mapear Request a Entity
        RiesgoPersonaNaturalEntity entity = personaNaturalMapper.toEntity(request);

        // Establecer campos de auditoría
        entity.setFechaCreacion(now);
        entity.setUsuarioCreacion(currentUser);

        // Guardar entidad
        RiesgoPersonaNaturalEntity savedEntity = personaNaturalRepository.save(entity);

        // Mapear Entity a Response
        RiesgoPersonaNaturalResponse response = personaNaturalMapper.toResponse(savedEntity);
        response.setMensaje("Riesgo de Persona Natural guardado exitosamente");

        return response;
    }

    // Persona Natural - Actualizar por ID
    @Transactional
    public RiesgoPersonaNaturalResponse actualizarPersonaNatural(Long id, RiesgoPersonaNaturalRequest request) {
        // Buscar entidad existente
        RiesgoPersonaNaturalEntity entity = personaNaturalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe registro con id: " + id));

        // Obtener usuario actual
        String currentUser = currentUser();
        LocalDateTime now = LocalDateTime.now();

        // Actualizar campos desde el request
        personaNaturalMapper.updateEntityFromRequest(request, entity);

        // Actualizar campos de auditoría
        entity.setFechaUltimaModificacion(now);
        entity.setUsuarioUltimaModificacion(currentUser);

        // Guardar entidad actualizada
        RiesgoPersonaNaturalEntity updatedEntity = personaNaturalRepository.save(entity);

        // Mapear Entity a Response
        RiesgoPersonaNaturalResponse response = personaNaturalMapper.toResponse(updatedEntity);
        response.setMensaje("Riesgo de Persona Natural actualizado exitosamente");

        return response;
    }

    // Persona Natural - Consultar todos
    public List<RiesgoPersonaNaturalResponse> listarPersonaNatural() {
        List<RiesgoPersonaNaturalEntity> entities = personaNaturalRepository.findAll();
        return entities.stream()
                .map(entity -> {
                    RiesgoPersonaNaturalResponse response = personaNaturalMapper.toResponse(entity);
                    return response;
                })
                .collect(Collectors.toList());
    }

    // Persona Natural - Consultar por ID
    public RiesgoPersonaNaturalResponse obtenerPersonaNaturalPorId(Long id) {
        RiesgoPersonaNaturalEntity entity = personaNaturalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe registro con id: " + id));

        return personaNaturalMapper.toResponse(entity);
    }

    // Persona Jurídica - Guardar/Actualizar
    @Transactional
    public RiesgoPersonaJuridicaResponse guardarPersonaJuridica(RiesgoPersonaJuridicaRequest request) {
        // Obtener usuario actual
        String currentUser = currentUser();
        LocalDateTime now = LocalDateTime.now();

        // Mapear Request a Entity
        RiesgoPersonaJuridicaEntity entity = personaJuridicaMapper.toEntity(request);

        // Establecer campos de auditoría
        entity.setFechaCreacion(now);
        entity.setUsuarioCreacion(currentUser);

        // Guardar entidad
        RiesgoPersonaJuridicaEntity savedEntity = personaJuridicaRepository.save(entity);

        // Mapear Entity a Response
        RiesgoPersonaJuridicaResponse response = personaJuridicaMapper.toResponse(savedEntity);
        response.setMensaje("Riesgo de Persona Jurídica guardado exitosamente");

        return response;
    }

    // Persona Jurídica - Actualizar por ID
    @Transactional
    public RiesgoPersonaJuridicaResponse actualizarPersonaJuridica(Long id, RiesgoPersonaJuridicaRequest request) {
        // Buscar entidad existente
        RiesgoPersonaJuridicaEntity entity = personaJuridicaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe registro con id: " + id));

        // Obtener usuario actual
        String currentUser = currentUser();
        LocalDateTime now = LocalDateTime.now();

        // Actualizar campos desde el request
        personaJuridicaMapper.updateEntityFromRequest(request, entity);

        // Actualizar campos de auditoría
        entity.setFechaUltimaModificacion(now);
        entity.setUsuarioUltimaModificacion(currentUser);

        // Guardar entidad actualizada
        RiesgoPersonaJuridicaEntity updatedEntity = personaJuridicaRepository.save(entity);

        // Mapear Entity a Response
        RiesgoPersonaJuridicaResponse response = personaJuridicaMapper.toResponse(updatedEntity);
        response.setMensaje("Riesgo de Persona Jurídica actualizado exitosamente");

        return response;
    }

    // Persona Jurídica - Consultar todos
    public List<RiesgoPersonaJuridicaResponse> listarPersonaJuridica() {
        List<RiesgoPersonaJuridicaEntity> entities = personaJuridicaRepository.findAll();
        return entities.stream()
                .map(entity -> {
                    RiesgoPersonaJuridicaResponse response = personaJuridicaMapper.toResponse(entity);
                    return response;
                })
                .collect(Collectors.toList());
    }

    // Persona Jurídica - Consultar por ID
    public RiesgoPersonaJuridicaResponse obtenerPersonaJuridicaPorId(Long id) {
        RiesgoPersonaJuridicaEntity entity = personaJuridicaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe registro con id: " + id));

        return personaJuridicaMapper.toResponse(entity);
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

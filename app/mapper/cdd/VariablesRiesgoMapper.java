package app.mapper.cdd;

import app.Entity.cdd.VariablesRiesgoEntity;
import app.dto.cdd.VariablesRiesgoDTO;
import app.dto.cdd.VariablesRiesgoRequest;
import app.dto.cdd.VariablesRiesgoResponse;
import org.springframework.stereotype.Component;

@Component
public class VariablesRiesgoMapper {

    // Mapper para Request -> Entity
    public VariablesRiesgoEntity toEntity(VariablesRiesgoRequest request) {
        if (request == null) {
            return null;
        }

        VariablesRiesgoEntity entity = new VariablesRiesgoEntity();
        entity.setPorcentaje1(request.getPorcentaje1());
        entity.setPorcentaje2(request.getPorcentaje2());
        entity.setFechaVigencia(request.getFechaVigencia());

        return entity;
    }

    // Mapper para Entity -> Response
    public VariablesRiesgoResponse toResponse(VariablesRiesgoEntity entity) {
        if (entity == null) {
            return null;
        }

        VariablesRiesgoResponse response = new VariablesRiesgoResponse();
        response.setId(entity.getId());
        response.setPorcentaje1(entity.getPorcentaje1());
        response.setPorcentaje2(entity.getPorcentaje2());
        response.setFechaVigencia(entity.getFechaVigencia());
        response.setFechaCreacion(entity.getFechaCreacion());
        response.setUsuarioCreacion(entity.getUsuarioCreacion());
        response.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        response.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return response;
    }

    // Actualizar Entity desde Request
    public void updateEntityFromRequest(VariablesRiesgoRequest request, VariablesRiesgoEntity entity) {
        if (request == null || entity == null) {
            return;
        }

        entity.setPorcentaje1(request.getPorcentaje1());
        entity.setPorcentaje2(request.getPorcentaje2());
        entity.setFechaVigencia(request.getFechaVigencia());
    }

    // Mapper para DTO -> Entity
    public VariablesRiesgoEntity toEntityFromDTO(VariablesRiesgoDTO dto) {
        if (dto == null) {
            return null;
        }

        VariablesRiesgoEntity entity = new VariablesRiesgoEntity();
        entity.setId(dto.getId());
        entity.setPorcentaje1(dto.getPorcentaje1());
        entity.setPorcentaje2(dto.getPorcentaje2());
        entity.setFechaVigencia(dto.getFechaVigencia());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaUltimaModificacion(dto.getFechaUltimaModificacion());
        entity.setUsuarioUltimaModificacion(dto.getUsuarioUltimaModificacion());

        return entity;
    }

    // Mapper para Entity -> DTO
    public VariablesRiesgoDTO toDTO(VariablesRiesgoEntity entity) {
        if (entity == null) {
            return null;
        }

        VariablesRiesgoDTO dto = new VariablesRiesgoDTO();
        dto.setId(entity.getId());
        dto.setPorcentaje1(entity.getPorcentaje1());
        dto.setPorcentaje2(entity.getPorcentaje2());
        dto.setFechaVigencia(entity.getFechaVigencia());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        dto.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return dto;
    }
}

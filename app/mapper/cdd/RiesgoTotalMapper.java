package app.mapper.cdd;

import app.Entity.cdd.RiesgoTotalEntity;
import app.dto.cdd.RiesgoTotalDTO;
import app.dto.cdd.RiesgoTotalRequest;
import app.dto.cdd.RiesgoTotalResponse;
import org.springframework.stereotype.Component;

@Component
public class RiesgoTotalMapper {

    // Mapper para Request -> Entity
    public RiesgoTotalEntity toEntity(RiesgoTotalRequest request) {
        if (request == null) {
            return null;
        }

        RiesgoTotalEntity entity = new RiesgoTotalEntity();
        entity.setNombre(request.getNombre());
        entity.setDescripcion(request.getDescripcion());
        entity.setRiesgo(request.getRiesgo());
        entity.setFechaVigencia(request.getFechaVigencia());
        entity.setLimInf(request.getLimInf());
        entity.setLimSup(request.getLimSup());
        entity.setTipo(request.getTipo());

        return entity;
    }

    // Mapper para Entity -> Response
    public RiesgoTotalResponse toResponse(RiesgoTotalEntity entity) {
        if (entity == null) {
            return null;
        }

        RiesgoTotalResponse response = new RiesgoTotalResponse();
        response.setId(entity.getId());
        response.setNombre(entity.getNombre());
        response.setDescripcion(entity.getDescripcion());
        response.setRiesgo(entity.getRiesgo());
        response.setFechaVigencia(entity.getFechaVigencia());
        response.setLimInf(entity.getLimInf());
        response.setLimSup(entity.getLimSup());
        response.setTipo(entity.getTipo());
        response.setFechaCreacion(entity.getFechaCreacion());
        response.setUsuarioCreacion(entity.getUsuarioCreacion());
        response.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        response.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return response;
    }

    // Actualizar Entity desde Request
    public void updateEntityFromRequest(RiesgoTotalRequest request, RiesgoTotalEntity entity) {
        if (request == null || entity == null) {
            return;
        }

        entity.setNombre(request.getNombre());
        entity.setDescripcion(request.getDescripcion());
        entity.setRiesgo(request.getRiesgo());
        entity.setFechaVigencia(request.getFechaVigencia());
        entity.setLimInf(request.getLimInf());
        entity.setLimSup(request.getLimSup());
        entity.setTipo(request.getTipo());
    }

    // Mapper para DTO -> Entity
    public RiesgoTotalEntity toEntityFromDTO(RiesgoTotalDTO dto) {
        if (dto == null) {
            return null;
        }

        RiesgoTotalEntity entity = new RiesgoTotalEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setRiesgo(dto.getRiesgo());
        entity.setFechaVigencia(dto.getFechaVigencia());
        entity.setLimInf(dto.getLimInf());
        entity.setLimSup(dto.getLimSup());
        entity.setTipo(dto.getTipo());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaUltimaModificacion(dto.getFechaUltimaModificacion());
        entity.setUsuarioUltimaModificacion(dto.getUsuarioUltimaModificacion());

        return entity;
    }

    // Mapper para Entity -> DTO
    public RiesgoTotalDTO toDTO(RiesgoTotalEntity entity) {
        if (entity == null) {
            return null;
        }

        RiesgoTotalDTO dto = new RiesgoTotalDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        dto.setRiesgo(entity.getRiesgo());
        dto.setFechaVigencia(entity.getFechaVigencia());
        dto.setLimInf(entity.getLimInf());
        dto.setLimSup(entity.getLimSup());
        dto.setTipo(entity.getTipo());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        dto.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return dto;
    }
}

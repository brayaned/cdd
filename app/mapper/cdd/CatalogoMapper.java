package app.mapper.cdd;

import app.Entity.cdd.CatalogoEntity;
import app.dto.cdd.CatalogoDTO;
import app.dto.cdd.CatalogoRequest;
import app.dto.cdd.CatalogoResponse;
import org.springframework.stereotype.Component;

@Component
public class CatalogoMapper {

    // Mapper para Request -> Entity
    public CatalogoEntity toEntity(CatalogoRequest request) {
        if (request == null) {
            return null;
        }

        CatalogoEntity entity = new CatalogoEntity();
        entity.setId(request.getId());
        entity.setNombre(request.getNombre());
        entity.setDescripcion(request.getDescripcion());
        entity.setRiesgo(request.getRiesgo());
        entity.setFechaVigencia(request.getFechaVigencia());
        entity.setTipo(request.getTipo());

        return entity;
    }

    // Mapper para Entity -> Response
    public CatalogoResponse toResponse(CatalogoEntity entity) {
        if (entity == null) {
            return null;
        }

        CatalogoResponse response = new CatalogoResponse();
        response.setId(entity.getId());
        response.setNombre(entity.getNombre());
        response.setDescripcion(entity.getDescripcion());
        response.setRiesgo(entity.getRiesgo());
        response.setFechaVigencia(entity.getFechaVigencia());
        response.setTipo(entity.getTipo());
        response.setFechaCreacion(entity.getFechaCreacion());
        response.setUsuarioCreacion(entity.getUsuarioCreacion());
        response.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        response.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return response;
    }

    // Actualizar Entity desde Request
    public void updateEntityFromRequest(CatalogoRequest request, CatalogoEntity entity) {
        if (request == null || entity == null) {
            return;
        }

        entity.setNombre(request.getNombre());
        entity.setDescripcion(request.getDescripcion());
        entity.setRiesgo(request.getRiesgo());
        entity.setFechaVigencia(request.getFechaVigencia());
        entity.setTipo(request.getTipo());
    }

    // Mapper para DTO -> Entity
    public CatalogoEntity toEntityFromDTO(CatalogoDTO dto) {
        if (dto == null) {
            return null;
        }

        CatalogoEntity entity = new CatalogoEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setRiesgo(dto.getRiesgo());
        entity.setFechaVigencia(dto.getFechaVigencia());
        entity.setTipo(dto.getTipo());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaUltimaModificacion(dto.getFechaUltimaModificacion());
        entity.setUsuarioUltimaModificacion(dto.getUsuarioUltimaModificacion());

        return entity;
    }

    // Mapper para Entity -> DTO
    public CatalogoDTO toDTO(CatalogoEntity entity) {
        if (entity == null) {
            return null;
        }

        CatalogoDTO dto = new CatalogoDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        dto.setRiesgo(entity.getRiesgo());
        dto.setFechaVigencia(entity.getFechaVigencia());
        dto.setTipo(entity.getTipo());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        dto.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return dto;
    }
}

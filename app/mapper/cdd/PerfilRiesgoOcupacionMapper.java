package app.mapper.cdd;

import app.Entity.cdd.PerfilRiesgoOcupacionEntity;
import app.dto.cdd.PerfilRiesgoOcupacionDTO;
import org.springframework.stereotype.Component;

@Component
public class PerfilRiesgoOcupacionMapper {

    public PerfilRiesgoOcupacionDTO toDTO(PerfilRiesgoOcupacionEntity entity) {
        if (entity == null) {
            return null;
        }

        PerfilRiesgoOcupacionDTO dto = new PerfilRiesgoOcupacionDTO();
        dto.setIdCodigoOcupacion(entity.getIdCodigoOcupacion());
        dto.setCatalogo(entity.getCatalogo());
        dto.setDescripcionOcupacion(entity.getDescripcionOcupacion());
        dto.setProbabilidadRiesgo(entity.getProbabilidadRiesgo());
        dto.setFechaVigencia(entity.getFechaVigencia());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        dto.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return dto;
    }

    public PerfilRiesgoOcupacionEntity toEntity(PerfilRiesgoOcupacionDTO dto) {
        if (dto == null) {
            return null;
        }

        PerfilRiesgoOcupacionEntity entity = new PerfilRiesgoOcupacionEntity();
        entity.setIdCodigoOcupacion(dto.getIdCodigoOcupacion());
        entity.setCatalogo(dto.getCatalogo());
        entity.setDescripcionOcupacion(dto.getDescripcionOcupacion());
        entity.setProbabilidadRiesgo(dto.getProbabilidadRiesgo());
        entity.setFechaVigencia(dto.getFechaVigencia());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaUltimaModificacion(dto.getFechaUltimaModificacion());
        entity.setUsuarioUltimaModificacion(dto.getUsuarioUltimaModificacion());

        return entity;
    }
}

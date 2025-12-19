package app.mapper.cdd;

import app.Entity.cdd.PerfilRiesgoGruposEntity;
import app.dto.cdd.PerfilRiesgoGruposDTO;
import org.springframework.stereotype.Component;

@Component
public class PerfilRiesgoGruposMapper {

    public PerfilRiesgoGruposDTO toDTO(PerfilRiesgoGruposEntity entity) {
        if (entity == null) {
            return null;
        }

        PerfilRiesgoGruposDTO dto = new PerfilRiesgoGruposDTO();
        dto.setCatalogo(entity.getCatalogo());
        dto.setCodigoGrupo(entity.getCodigoGrupo());
        dto.setDescripcionGrupo(entity.getDescripcionGrupo());
        dto.setProbabilidadRiesgo(entity.getProbabilidadRiesgo());
        dto.setFechaVigencia(entity.getFechaVigencia());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        dto.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return dto;
    }

    public PerfilRiesgoGruposEntity toEntity(PerfilRiesgoGruposDTO dto) {
        if (dto == null) {
            return null;
        }

        PerfilRiesgoGruposEntity entity = new PerfilRiesgoGruposEntity();
        entity.setCatalogo(dto.getCatalogo());
        entity.setCodigoGrupo(dto.getCodigoGrupo());
        entity.setDescripcionGrupo(dto.getDescripcionGrupo());
        entity.setProbabilidadRiesgo(dto.getProbabilidadRiesgo());
        entity.setFechaVigencia(dto.getFechaVigencia());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaUltimaModificacion(dto.getFechaUltimaModificacion());
        entity.setUsuarioUltimaModificacion(dto.getUsuarioUltimaModificacion());

        return entity;
    }
}

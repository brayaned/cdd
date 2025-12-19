package app.mapper.cdd;

import app.Entity.cdd.PerfilRiesgoPaisProbabilidadAuditoriaEntity;
import app.dto.cdd.PerfilRiesgoPaisProbabilidadAuditoriaDTO;
import org.springframework.stereotype.Component;

@Component
public class PerfilRiesgoPaisProbabilidadAuditoriaMapper {

    public PerfilRiesgoPaisProbabilidadAuditoriaDTO toDTO(PerfilRiesgoPaisProbabilidadAuditoriaEntity entity) {
        if (entity == null) {
            return null;
        }

        PerfilRiesgoPaisProbabilidadAuditoriaDTO dto = new PerfilRiesgoPaisProbabilidadAuditoriaDTO();
        dto.setId(entity.getId());
        dto.setTipoPais(entity.getTipoPais());
        dto.setCodigoPais(entity.getCodigoPais());
        dto.setProbabilidadRiesgo(entity.getProbabilidadRiesgo());
        dto.setFechaVigencia(entity.getFechaVigencia());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        dto.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return dto;
    }

    public PerfilRiesgoPaisProbabilidadAuditoriaEntity toEntity(PerfilRiesgoPaisProbabilidadAuditoriaDTO dto) {
        if (dto == null) {
            return null;
        }

        PerfilRiesgoPaisProbabilidadAuditoriaEntity entity = new PerfilRiesgoPaisProbabilidadAuditoriaEntity();
        entity.setId(dto.getId());
        entity.setTipoPais(dto.getTipoPais());
        entity.setCodigoPais(dto.getCodigoPais());
        entity.setProbabilidadRiesgo(dto.getProbabilidadRiesgo());
        entity.setFechaVigencia(dto.getFechaVigencia());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaUltimaModificacion(dto.getFechaUltimaModificacion());
        entity.setUsuarioUltimaModificacion(dto.getUsuarioUltimaModificacion());

        return entity;
    }
}

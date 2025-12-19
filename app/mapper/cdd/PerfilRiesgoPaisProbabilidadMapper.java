package app.mapper.cdd;

import app.Entity.cdd.PerfilRiesgoPaisProbabilidadEntity;
import app.dto.cdd.PerfilRiesgoPaisProbabilidadDTO;
import org.springframework.stereotype.Component;

@Component
public class PerfilRiesgoPaisProbabilidadMapper {

    public PerfilRiesgoPaisProbabilidadDTO toDTO(PerfilRiesgoPaisProbabilidadEntity entity) {
        if (entity == null) {
            return null;
        }

        PerfilRiesgoPaisProbabilidadDTO dto = new PerfilRiesgoPaisProbabilidadDTO();
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

    public PerfilRiesgoPaisProbabilidadEntity toEntity(PerfilRiesgoPaisProbabilidadDTO dto) {
        if (dto == null) {
            return null;
        }

        PerfilRiesgoPaisProbabilidadEntity entity = new PerfilRiesgoPaisProbabilidadEntity();
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

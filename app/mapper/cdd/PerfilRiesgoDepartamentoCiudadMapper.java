package app.mapper.cdd;

import app.Entity.cdd.PerfilRiesgoDepartamentoCiudadEntity;
import app.dto.cdd.PerfilRiesgoDepartamentoCiudadDTO;
import org.springframework.stereotype.Component;

@Component
public class PerfilRiesgoDepartamentoCiudadMapper {

    public PerfilRiesgoDepartamentoCiudadDTO toDTO(PerfilRiesgoDepartamentoCiudadEntity entity) {
        if (entity == null) {
            return null;
        }

        PerfilRiesgoDepartamentoCiudadDTO dto = new PerfilRiesgoDepartamentoCiudadDTO();
        dto.setCatalogo(entity.getCatalogo());
        dto.setCodigoDepartamento(entity.getCodigoDepartamento());
        dto.setCodigoCiudad(entity.getCodigoCiudad());
        dto.setFechaVigenciaRiesgoDepartamentoCiudad(entity.getFechaVigenciaRiesgoDepartamentoCiudad());
        dto.setProbabilidadRiesgo(entity.getProbabilidadRiesgo());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        dto.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return dto;
    }

    public PerfilRiesgoDepartamentoCiudadEntity toEntity(PerfilRiesgoDepartamentoCiudadDTO dto) {
        if (dto == null) {
            return null;
        }

        PerfilRiesgoDepartamentoCiudadEntity entity = new PerfilRiesgoDepartamentoCiudadEntity();
        entity.setCatalogo(dto.getCatalogo());
        entity.setCodigoDepartamento(dto.getCodigoDepartamento());
        entity.setCodigoCiudad(dto.getCodigoCiudad());
        entity.setFechaVigenciaRiesgoDepartamentoCiudad(dto.getFechaVigenciaRiesgoDepartamentoCiudad());
        entity.setProbabilidadRiesgo(dto.getProbabilidadRiesgo());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaUltimaModificacion(dto.getFechaUltimaModificacion());
        entity.setUsuarioUltimaModificacion(dto.getUsuarioUltimaModificacion());

        return entity;
    }
}

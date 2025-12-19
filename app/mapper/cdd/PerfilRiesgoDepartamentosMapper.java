package app.mapper.cdd;

import app.Entity.cdd.PerfilRiesgoDepartamentosEntity;
import app.dto.cdd.PerfilRiesgoDepartamentosDTO;
import org.springframework.stereotype.Component;

@Component
public class PerfilRiesgoDepartamentosMapper {

    public PerfilRiesgoDepartamentosDTO toDTO(PerfilRiesgoDepartamentosEntity entity) {
        if (entity == null) {
            return null;
        }

        PerfilRiesgoDepartamentosDTO dto = new PerfilRiesgoDepartamentosDTO();
        dto.setCodigoDepartamento(entity.getCodigoDepartamento());
        dto.setCatalogo(entity.getCatalogo());
        dto.setFechaVigenciaRiesgoDepartamento(entity.getFechaVigenciaRiesgoDepartamento());
        dto.setProbabilidadRiesgo(entity.getProbabilidadRiesgo());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        dto.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return dto;
    }

    public PerfilRiesgoDepartamentosEntity toEntity(PerfilRiesgoDepartamentosDTO dto) {
        if (dto == null) {
            return null;
        }

        PerfilRiesgoDepartamentosEntity entity = new PerfilRiesgoDepartamentosEntity();
        entity.setCodigoDepartamento(dto.getCodigoDepartamento());
        entity.setCatalogo(dto.getCatalogo());
        entity.setFechaVigenciaRiesgoDepartamento(dto.getFechaVigenciaRiesgoDepartamento());
        entity.setProbabilidadRiesgo(dto.getProbabilidadRiesgo());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaUltimaModificacion(dto.getFechaUltimaModificacion());
        entity.setUsuarioUltimaModificacion(dto.getUsuarioUltimaModificacion());

        return entity;
    }
}

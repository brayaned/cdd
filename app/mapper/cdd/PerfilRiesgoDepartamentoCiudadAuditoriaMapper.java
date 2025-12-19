package app.mapper.cdd;

import app.Entity.cdd.PerfilRiesgoDepartamentoCiudadAuditoriaEntity;
import app.dto.cdd.PerfilRiesgoDepartamentoCiudadAuditoriaDTO;
import org.springframework.stereotype.Component;

@Component
public class PerfilRiesgoDepartamentoCiudadAuditoriaMapper {

    public PerfilRiesgoDepartamentoCiudadAuditoriaDTO toDTO(PerfilRiesgoDepartamentoCiudadAuditoriaEntity entity) {
        if (entity == null) {
            return null;
        }

        PerfilRiesgoDepartamentoCiudadAuditoriaDTO dto = new PerfilRiesgoDepartamentoCiudadAuditoriaDTO();
        dto.setIdConsecutivoDepartamentoCiudadAuditoria(entity.getIdConsecutivoDepartamentoCiudadAuditoria());
        dto.setIdAccion(entity.getIdAccion());
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

    public PerfilRiesgoDepartamentoCiudadAuditoriaEntity toEntity(PerfilRiesgoDepartamentoCiudadAuditoriaDTO dto) {
        if (dto == null) {
            return null;
        }

        PerfilRiesgoDepartamentoCiudadAuditoriaEntity entity = new PerfilRiesgoDepartamentoCiudadAuditoriaEntity();
        entity.setIdConsecutivoDepartamentoCiudadAuditoria(dto.getIdConsecutivoDepartamentoCiudadAuditoria());
        entity.setIdAccion(dto.getIdAccion());
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

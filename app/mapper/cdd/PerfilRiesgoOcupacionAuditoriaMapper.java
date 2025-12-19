package app.mapper.cdd;

import app.Entity.cdd.PerfilRiesgoOcupacionAuditoriaEntity;
import app.dto.cdd.PerfilRiesgoOcupacionAuditoriaDTO;
import org.springframework.stereotype.Component;

@Component
public class PerfilRiesgoOcupacionAuditoriaMapper {

    public PerfilRiesgoOcupacionAuditoriaDTO toDTO(PerfilRiesgoOcupacionAuditoriaEntity entity) {
        if (entity == null) {
            return null;
        }

        PerfilRiesgoOcupacionAuditoriaDTO dto = new PerfilRiesgoOcupacionAuditoriaDTO();
        dto.setIdConsecutivoOcupacionAuditoria(entity.getIdConsecutivoOcupacionAuditoria());
        dto.setCatalogo(entity.getCatalogo());
        dto.setIdCodigoOcupacion(entity.getIdCodigoOcupacion());
        dto.setDescripcionOcupacion(entity.getDescripcionOcupacion());
        dto.setProbabilidadRiesgo(entity.getProbabilidadRiesgo());
        dto.setFechaVigencia(entity.getFechaVigencia());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        dto.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return dto;
    }

    public PerfilRiesgoOcupacionAuditoriaEntity toEntity(PerfilRiesgoOcupacionAuditoriaDTO dto) {
        if (dto == null) {
            return null;
        }

        PerfilRiesgoOcupacionAuditoriaEntity entity = new PerfilRiesgoOcupacionAuditoriaEntity();
        entity.setIdConsecutivoOcupacionAuditoria(dto.getIdConsecutivoOcupacionAuditoria());
        entity.setCatalogo(dto.getCatalogo());
        entity.setIdCodigoOcupacion(dto.getIdCodigoOcupacion());
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

package app.mapper.cdd;

import app.Entity.cdd.PerfilRiesgoGruposAuditoriaEntity;
import app.dto.cdd.PerfilRiesgoGruposAuditoriaDTO;
import org.springframework.stereotype.Component;

@Component
public class PerfilRiesgoGruposAuditoriaMapper {

    public PerfilRiesgoGruposAuditoriaDTO toDTO(PerfilRiesgoGruposAuditoriaEntity entity) {
        if (entity == null) {
            return null;
        }

        PerfilRiesgoGruposAuditoriaDTO dto = new PerfilRiesgoGruposAuditoriaDTO();
        dto.setIdConsecutivoGruposAuditoria(entity.getIdConsecutivoGruposAuditoria());
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

    public PerfilRiesgoGruposAuditoriaEntity toEntity(PerfilRiesgoGruposAuditoriaDTO dto) {
        if (dto == null) {
            return null;
        }

        PerfilRiesgoGruposAuditoriaEntity entity = new PerfilRiesgoGruposAuditoriaEntity();
        entity.setIdConsecutivoGruposAuditoria(dto.getIdConsecutivoGruposAuditoria());
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

package app.mapper.cdd;

import app.Entity.cdd.PerfilRiesgoIndustriaAuditoriaEntity;
import app.dto.cdd.PerfilRiesgoIndustriaAuditoriaDTO;
import org.springframework.stereotype.Component;

@Component
public class PerfilRiesgoIndustriaAuditoriaMapper {

    public PerfilRiesgoIndustriaAuditoriaDTO toDTO(PerfilRiesgoIndustriaAuditoriaEntity entity) {
        if (entity == null) {
            return null;
        }

        PerfilRiesgoIndustriaAuditoriaDTO dto = new PerfilRiesgoIndustriaAuditoriaDTO();
        dto.setIdConsecutivoIndustriaAuditoria(entity.getIdConsecutivoIndustriaAuditoria());
        dto.setCatalogo(entity.getCatalogo());
        dto.setIdCodigoIndustria(entity.getIdCodigoIndustria());
        dto.setDescripcionIndustria(entity.getDescripcionIndustria());
        dto.setProbabilidadRiesgo(entity.getProbabilidadRiesgo());
        dto.setFechaVigencia(entity.getFechaVigencia());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        dto.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return dto;
    }

    public PerfilRiesgoIndustriaAuditoriaEntity toEntity(PerfilRiesgoIndustriaAuditoriaDTO dto) {
        if (dto == null) {
            return null;
        }

        PerfilRiesgoIndustriaAuditoriaEntity entity = new PerfilRiesgoIndustriaAuditoriaEntity();
        entity.setIdConsecutivoIndustriaAuditoria(dto.getIdConsecutivoIndustriaAuditoria());
        entity.setCatalogo(dto.getCatalogo());
        entity.setIdCodigoIndustria(dto.getIdCodigoIndustria());
        entity.setDescripcionIndustria(dto.getDescripcionIndustria());
        entity.setProbabilidadRiesgo(dto.getProbabilidadRiesgo());
        entity.setFechaVigencia(dto.getFechaVigencia());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaUltimaModificacion(dto.getFechaUltimaModificacion());
        entity.setUsuarioUltimaModificacion(dto.getUsuarioUltimaModificacion());

        return entity;
    }
}

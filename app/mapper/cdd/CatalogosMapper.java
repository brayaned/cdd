package app.mapper.cdd;

import app.Entity.cdd.CatalogosEntity;
import app.dto.cdd.CatalogosDTO;
import org.springframework.stereotype.Component;

@Component
public class CatalogosMapper {

    public CatalogosDTO toDTO(CatalogosEntity entity) {
        if (entity == null) {
            return null;
        }

        CatalogosDTO dto = new CatalogosDTO();
        dto.setNombreCatalogo(entity.getNombreCatalogo());
        dto.setTipoCatalogo(entity.getTipoCatalogo());
        dto.setProbabilidadRiesgo(entity.getProbabilidadRiesgo());
        dto.setFechaVigencia(entity.getFechaVigencia());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        dto.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return dto;
    }

    public CatalogosEntity toEntity(CatalogosDTO dto) {
        if (dto == null) {
            return null;
        }

        CatalogosEntity entity = new CatalogosEntity();
        entity.setNombreCatalogo(dto.getNombreCatalogo());
        entity.setTipoCatalogo(dto.getTipoCatalogo());
        entity.setProbabilidadRiesgo(dto.getProbabilidadRiesgo());
        entity.setFechaVigencia(dto.getFechaVigencia());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaUltimaModificacion(dto.getFechaUltimaModificacion());
        entity.setUsuarioUltimaModificacion(dto.getUsuarioUltimaModificacion());

        return entity;
    }
}

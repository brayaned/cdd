package app.mapper.cdd;

import app.Entity.cdd.DetalleResultadoRiesgoEntity;
import app.dto.cdd.DetalleResultadoRiesgoDTO;
import org.springframework.stereotype.Component;

@Component
public class DetalleResultadoRiesgoMapper {

    public DetalleResultadoRiesgoDTO toDTO(DetalleResultadoRiesgoEntity entity) {
        if (entity == null) {
            return null;
        }

        DetalleResultadoRiesgoDTO dto = new DetalleResultadoRiesgoDTO();
        dto.setId(entity.getId());
        dto.setCatalogo(entity.getCatalogo());
        dto.setValor(entity.getValor());
        dto.setRiesgo(entity.getRiesgo());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        dto.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return dto;
    }

    public DetalleResultadoRiesgoEntity toEntity(DetalleResultadoRiesgoDTO dto) {
        if (dto == null) {
            return null;
        }

        DetalleResultadoRiesgoEntity entity = new DetalleResultadoRiesgoEntity();
        entity.setId(dto.getId());
        entity.setCatalogo(dto.getCatalogo());
        entity.setValor(dto.getValor());
        entity.setRiesgo(dto.getRiesgo());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaUltimaModificacion(dto.getFechaUltimaModificacion());
        entity.setUsuarioUltimaModificacion(dto.getUsuarioUltimaModificacion());

        return entity;
    }
}

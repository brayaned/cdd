package app.mapper.cdd;

import app.Entity.cdd.ResultadoRiesgoEntity;
import app.dto.cdd.ResultadoRiesgoDTO;
import org.springframework.stereotype.Component;

@Component
public class ResultadoRiesgoMapper {

    public ResultadoRiesgoDTO toDTO(ResultadoRiesgoEntity entity) {
        if (entity == null) {
            return null;
        }

        ResultadoRiesgoDTO dto = new ResultadoRiesgoDTO();
        dto.setId(entity.getId());
        dto.setDocumento(entity.getDocumento());
        dto.setTipoDocumento(entity.getTipoDocumento());
        dto.setNombre(entity.getNombre());
        dto.setTipoPersona(entity.getTipoPersona());
        dto.setProducto(entity.getProducto());
        dto.setFecha(entity.getFecha());
        dto.setResultadoRiesgo(entity.getResultadoRiesgo());
        dto.setNivelRiesgo(entity.getNivelRiesgo());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        dto.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return dto;
    }

    public ResultadoRiesgoEntity toEntity(ResultadoRiesgoDTO dto) {
        if (dto == null) {
            return null;
        }

        ResultadoRiesgoEntity entity = new ResultadoRiesgoEntity();
        entity.setId(dto.getId());
        entity.setDocumento(dto.getDocumento());
        entity.setTipoDocumento(dto.getTipoDocumento());
        entity.setNombre(dto.getNombre());
        entity.setTipoPersona(dto.getTipoPersona());
        entity.setProducto(dto.getProducto());
        entity.setFecha(dto.getFecha());
        entity.setResultadoRiesgo(dto.getResultadoRiesgo());
        entity.setNivelRiesgo(dto.getNivelRiesgo());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaUltimaModificacion(dto.getFechaUltimaModificacion());
        entity.setUsuarioUltimaModificacion(dto.getUsuarioUltimaModificacion());

        return entity;
    }
}

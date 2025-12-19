package app.mapper.cdd;

import app.Entity.cdd.PerfilRiesgoPaisEntity;
import app.dto.cdd.PerfilRiesgoPaisDTO;
import org.springframework.stereotype.Component;

@Component
public class PerfilRiesgoPaisMapper {

    public PerfilRiesgoPaisDTO toDTO(PerfilRiesgoPaisEntity entity) {
        if (entity == null) {
            return null;
        }

        PerfilRiesgoPaisDTO dto = new PerfilRiesgoPaisDTO();
        dto.setPaisCodigo(entity.getPaisCodigo());
        dto.setDescripcionPais(entity.getDescripcionPais());

        return dto;
    }

    public PerfilRiesgoPaisEntity toEntity(PerfilRiesgoPaisDTO dto) {
        if (dto == null) {
            return null;
        }

        PerfilRiesgoPaisEntity entity = new PerfilRiesgoPaisEntity();
        entity.setPaisCodigo(dto.getPaisCodigo());
        entity.setDescripcionPais(dto.getDescripcionPais());

        return entity;
    }
}

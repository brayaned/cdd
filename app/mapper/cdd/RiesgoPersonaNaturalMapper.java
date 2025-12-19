package app.mapper.cdd;

import app.Entity.cdd.RiesgoPersonaNaturalEntity;
import app.dto.cdd.RiesgoPersonaNaturalDTO;
import app.dto.cdd.RiesgoPersonaNaturalRequest;
import app.dto.cdd.RiesgoPersonaNaturalResponse;
import org.springframework.stereotype.Component;

@Component
public class RiesgoPersonaNaturalMapper {

    // Mapper para Request -> Entity
    public RiesgoPersonaNaturalEntity toEntity(RiesgoPersonaNaturalRequest request) {
        if (request == null) {
            return null;
        }

        RiesgoPersonaNaturalEntity entity = new RiesgoPersonaNaturalEntity();
        entity.setIndustria(request.getIndustria());
        entity.setOcupacion(request.getOcupacion());
        entity.setProductos(request.getProductos());
        entity.setPaisResidencia(request.getPaisResidencia());
        entity.setCanalOnboarding(request.getCanalOnboarding());
        entity.setCiudad(request.getCiudad());

        return entity;
    }

    // Mapper para Entity -> Response
    public RiesgoPersonaNaturalResponse toResponse(RiesgoPersonaNaturalEntity entity) {
        if (entity == null) {
            return null;
        }

        RiesgoPersonaNaturalResponse response = new RiesgoPersonaNaturalResponse();
        response.setId(entity.getId());
        response.setIndustria(entity.getIndustria());
        response.setOcupacion(entity.getOcupacion());
        response.setProductos(entity.getProductos());
        response.setPaisResidencia(entity.getPaisResidencia());
        response.setCanalOnboarding(entity.getCanalOnboarding());
        response.setCiudad(entity.getCiudad());
        response.setFechaCreacion(entity.getFechaCreacion());
        response.setUsuarioCreacion(entity.getUsuarioCreacion());
        response.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        response.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return response;
    }

    // Actualizar Entity desde Request
    public void updateEntityFromRequest(RiesgoPersonaNaturalRequest request, RiesgoPersonaNaturalEntity entity) {
        if (request == null || entity == null) {
            return;
        }

        entity.setIndustria(request.getIndustria());
        entity.setOcupacion(request.getOcupacion());
        entity.setProductos(request.getProductos());
        entity.setPaisResidencia(request.getPaisResidencia());
        entity.setCanalOnboarding(request.getCanalOnboarding());
        entity.setCiudad(request.getCiudad());
    }

    // Mapper para DTO -> Entity
    public RiesgoPersonaNaturalEntity toEntityFromDTO(RiesgoPersonaNaturalDTO dto) {
        if (dto == null) {
            return null;
        }

        RiesgoPersonaNaturalEntity entity = new RiesgoPersonaNaturalEntity();
        entity.setId(dto.getId());
        entity.setIndustria(dto.getIndustria());
        entity.setOcupacion(dto.getOcupacion());
        entity.setProductos(dto.getProductos());
        entity.setPaisResidencia(dto.getPaisResidencia());
        entity.setCanalOnboarding(dto.getCanalOnboarding());
        entity.setCiudad(dto.getCiudad());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaUltimaModificacion(dto.getFechaUltimaModificacion());
        entity.setUsuarioUltimaModificacion(dto.getUsuarioUltimaModificacion());

        return entity;
    }

    // Mapper para Entity -> DTO
    public RiesgoPersonaNaturalDTO toDTO(RiesgoPersonaNaturalEntity entity) {
        if (entity == null) {
            return null;
        }

        RiesgoPersonaNaturalDTO dto = new RiesgoPersonaNaturalDTO();
        dto.setId(entity.getId());
        dto.setIndustria(entity.getIndustria());
        dto.setOcupacion(entity.getOcupacion());
        dto.setProductos(entity.getProductos());
        dto.setPaisResidencia(entity.getPaisResidencia());
        dto.setCanalOnboarding(entity.getCanalOnboarding());
        dto.setCiudad(entity.getCiudad());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        dto.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return dto;
    }
}

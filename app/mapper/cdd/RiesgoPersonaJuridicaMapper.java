package app.mapper.cdd;

import app.Entity.cdd.RiesgoPersonaJuridicaEntity;
import app.dto.cdd.RiesgoPersonaJuridicaDTO;
import app.dto.cdd.RiesgoPersonaJuridicaRequest;
import app.dto.cdd.RiesgoPersonaJuridicaResponse;
import org.springframework.stereotype.Component;

@Component
public class RiesgoPersonaJuridicaMapper {

    // Mapper para Request -> Entity
    public RiesgoPersonaJuridicaEntity toEntity(RiesgoPersonaJuridicaRequest request) {
        if (request == null) {
            return null;
        }

        RiesgoPersonaJuridicaEntity entity = new RiesgoPersonaJuridicaEntity();
        entity.setIndustria(request.getIndustria());
        entity.setProductos(request.getProductos());
        entity.setPaisResidenciaUbos(request.getPaisResidenciaUbos());
        entity.setPaisResidenciaFiscal(request.getPaisResidenciaFiscal());
        entity.setPaisIncorporacion(request.getPaisIncorporacion());
        entity.setEstructuraPropiedadCompleja(request.getEstructuraPropiedadCompleja());
        entity.setTipoPersonaJuridica(request.getTipoPersonaJuridica());
        entity.setCanalOnboarding(request.getCanalOnboarding());
        entity.setPresenciaGrupo(request.getPresenciaGrupo());
        entity.setExposicionPaisesProhibidos(request.getExposicionPaisesProhibidos());

        return entity;
    }

    // Mapper para Entity -> Response
    public RiesgoPersonaJuridicaResponse toResponse(RiesgoPersonaJuridicaEntity entity) {
        if (entity == null) {
            return null;
        }

        RiesgoPersonaJuridicaResponse response = new RiesgoPersonaJuridicaResponse();
        response.setId(entity.getId());
        response.setIndustria(entity.getIndustria());
        response.setProductos(entity.getProductos());
        response.setPaisResidenciaUbos(entity.getPaisResidenciaUbos());
        response.setPaisResidenciaFiscal(entity.getPaisResidenciaFiscal());
        response.setPaisIncorporacion(entity.getPaisIncorporacion());
        response.setEstructuraPropiedadCompleja(entity.getEstructuraPropiedadCompleja());
        response.setTipoPersonaJuridica(entity.getTipoPersonaJuridica());
        response.setCanalOnboarding(entity.getCanalOnboarding());
        response.setPresenciaGrupo(entity.getPresenciaGrupo());
        response.setExposicionPaisesProhibidos(entity.getExposicionPaisesProhibidos());
        response.setFechaCreacion(entity.getFechaCreacion());
        response.setUsuarioCreacion(entity.getUsuarioCreacion());
        response.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        response.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return response;
    }

    // Actualizar Entity desde Request
    public void updateEntityFromRequest(RiesgoPersonaJuridicaRequest request, RiesgoPersonaJuridicaEntity entity) {
        if (request == null || entity == null) {
            return;
        }

        entity.setIndustria(request.getIndustria());
        entity.setProductos(request.getProductos());
        entity.setPaisResidenciaUbos(request.getPaisResidenciaUbos());
        entity.setPaisResidenciaFiscal(request.getPaisResidenciaFiscal());
        entity.setPaisIncorporacion(request.getPaisIncorporacion());
        entity.setEstructuraPropiedadCompleja(request.getEstructuraPropiedadCompleja());
        entity.setTipoPersonaJuridica(request.getTipoPersonaJuridica());
        entity.setCanalOnboarding(request.getCanalOnboarding());
        entity.setPresenciaGrupo(request.getPresenciaGrupo());
        entity.setExposicionPaisesProhibidos(request.getExposicionPaisesProhibidos());
    }

    // Mapper para DTO -> Entity
    public RiesgoPersonaJuridicaEntity toEntityFromDTO(RiesgoPersonaJuridicaDTO dto) {
        if (dto == null) {
            return null;
        }

        RiesgoPersonaJuridicaEntity entity = new RiesgoPersonaJuridicaEntity();
        entity.setId(dto.getId());
        entity.setIndustria(dto.getIndustria());
        entity.setProductos(dto.getProductos());
        entity.setPaisResidenciaUbos(dto.getPaisResidenciaUbos());
        entity.setPaisResidenciaFiscal(dto.getPaisResidenciaFiscal());
        entity.setPaisIncorporacion(dto.getPaisIncorporacion());
        entity.setEstructuraPropiedadCompleja(dto.getEstructuraPropiedadCompleja());
        entity.setTipoPersonaJuridica(dto.getTipoPersonaJuridica());
        entity.setCanalOnboarding(dto.getCanalOnboarding());
        entity.setPresenciaGrupo(dto.getPresenciaGrupo());
        entity.setExposicionPaisesProhibidos(dto.getExposicionPaisesProhibidos());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaUltimaModificacion(dto.getFechaUltimaModificacion());
        entity.setUsuarioUltimaModificacion(dto.getUsuarioUltimaModificacion());

        return entity;
    }

    // Mapper para Entity -> DTO
    public RiesgoPersonaJuridicaDTO toDTO(RiesgoPersonaJuridicaEntity entity) {
        if (entity == null) {
            return null;
        }

        RiesgoPersonaJuridicaDTO dto = new RiesgoPersonaJuridicaDTO();
        dto.setId(entity.getId());
        dto.setIndustria(entity.getIndustria());
        dto.setProductos(entity.getProductos());
        dto.setPaisResidenciaUbos(entity.getPaisResidenciaUbos());
        dto.setPaisResidenciaFiscal(entity.getPaisResidenciaFiscal());
        dto.setPaisIncorporacion(entity.getPaisIncorporacion());
        dto.setEstructuraPropiedadCompleja(entity.getEstructuraPropiedadCompleja());
        dto.setTipoPersonaJuridica(entity.getTipoPersonaJuridica());
        dto.setCanalOnboarding(entity.getCanalOnboarding());
        dto.setPresenciaGrupo(entity.getPresenciaGrupo());
        dto.setExposicionPaisesProhibidos(entity.getExposicionPaisesProhibidos());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaUltimaModificacion(entity.getFechaUltimaModificacion());
        dto.setUsuarioUltimaModificacion(entity.getUsuarioUltimaModificacion());

        return dto;
    }
}

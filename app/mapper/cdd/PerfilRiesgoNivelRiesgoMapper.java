package app.mapper.cdd;

import app.Entity.cdd.PerfilRiesgoNivelRiesgoEntity;
import app.dto.cdd.PerfilRiesgoNivelRiesgoDTO;
import org.springframework.stereotype.Component;

@Component
public class PerfilRiesgoNivelRiesgoMapper {

    public PerfilRiesgoNivelRiesgoDTO toDTO(PerfilRiesgoNivelRiesgoEntity entity) {
        if (entity == null) {
            return null;
        }

        PerfilRiesgoNivelRiesgoDTO dto = new PerfilRiesgoNivelRiesgoDTO();
        dto.setVersionRiesgoCliente(entity.getVersionRiesgoCliente());
        dto.setTipoDocCliente(entity.getTipoDocCliente());
        dto.setNumeroDocCliente(entity.getNumeroDocCliente());
        dto.setCatalogoIndustria(entity.getCatalogoIndustria());
        dto.setCodigoIndustria(entity.getCodigoIndustria());
        dto.setFechaVigenciaIndustria(entity.getFechaVigenciaIndustria());
        dto.setCatalogoOcupacion(entity.getCatalogoOcupacion());
        dto.setCodigoOcupacion(entity.getCodigoOcupacion());
        dto.setFechaVigenciaOcupacion(entity.getFechaVigenciaOcupacion());
        dto.setCatalogoPersonaJuridica(entity.getCatalogoPersonaJuridica());
        dto.setTipoPersonaJuridica(entity.getTipoPersonaJuridica());
        dto.setFechaVigenciaTipoPersonaJuridica(entity.getFechaVigenciaTipoPersonaJuridica());
        dto.setCatalogoProducto(entity.getCatalogoProducto());
        dto.setCodigoProducto(entity.getCodigoProducto());
        dto.setFechaVigenciaProducto(entity.getFechaVigenciaProducto());
        dto.setCatalogoGrupo(entity.getCatalogoGrupo());
        dto.setCodigoGrupo(entity.getCodigoGrupo());
        dto.setFechaVigenciaGrupo(entity.getFechaVigenciaGrupo());
        dto.setPaisNacimiento(entity.getPaisNacimiento());
        dto.setPaisResidencia(entity.getPaisResidencia());
        dto.setFechaVigenciaPaisResidencia(entity.getFechaVigenciaPaisResidencia());
        dto.setTipoPaisUdos(entity.getTipoPaisUdos());
        dto.setPaisResidenciaUdos(entity.getPaisResidenciaUdos());
        dto.setFechaVigenciaPaisResidenciaUdos(entity.getFechaVigenciaPaisResidenciaUdos());
        dto.setTipoPaisFiscal(entity.getTipoPaisFiscal());
        dto.setPaisResidenciaFiscal(entity.getPaisResidenciaFiscal());
        dto.setFechaVigenciaPaisResidenciaFiscal(entity.getFechaVigenciaPaisResidenciaFiscal());
        dto.setTipoPaisIncorporacion(entity.getTipoPaisIncorporacion());
        dto.setPaisIncorporacion(entity.getPaisIncorporacion());
        dto.setFechaVigenciaPaisIncorporacion(entity.getFechaVigenciaPaisIncorporacion());
        dto.setCanalOnboarding(entity.getCanalOnboarding());
        dto.setFechaCanalOnboarding(entity.getFechaCanalOnboarding());
        dto.setNroDepositosEfectivo(entity.getNroDepositosEfectivo());
        dto.setFechaVigenciaNroDepositosEfectivo(entity.getFechaVigenciaNroDepositosEfectivo());
        dto.setNroRetirosEfectivo(entity.getNroRetirosEfectivo());
        dto.setFechaVigenciaNroRetirosEfectivo(entity.getFechaVigenciaNroRetirosEfectivo());
        dto.setVolPagosInternacionales(entity.getVolPagosInternacionales());
        dto.setFechaVigenciaVolPagosInternacionales(entity.getFechaVigenciaVolPagosInternacionales());
        dto.setNroPagosInternacionales(entity.getNroPagosInternacionales());
        dto.setFechaVigenciaNroPagosInternacionales(entity.getFechaVigenciaNroPagosInternacionales());
        dto.setNroTrfAPaisesAltoRiesgo(entity.getNroTrfAPaisesAltoRiesgo());
        dto.setFechaVigenciaNroTrfAPaisesAltoRiesgo(entity.getFechaVigenciaNroTrfAPaisesAltoRiesgo());
        dto.setVolTrfAPaisesAltoRiesgo(entity.getVolTrfAPaisesAltoRiesgo());
        dto.setFechaVigenciaVolTrfAPaisesAltoRiesgo(entity.getFechaVigenciaVolTrfAPaisesAltoRiesgo());
        dto.setCalificacionRiesgoCalculado(entity.getCalificacionRiesgoCalculado());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioModificacion(entity.getUsuarioModificacion());
        dto.setFechaModificacion(entity.getFechaModificacion());

        return dto;
    }

    public PerfilRiesgoNivelRiesgoEntity toEntity(PerfilRiesgoNivelRiesgoDTO dto) {
        if (dto == null) {
            return null;
        }

        PerfilRiesgoNivelRiesgoEntity entity = new PerfilRiesgoNivelRiesgoEntity();
        entity.setVersionRiesgoCliente(dto.getVersionRiesgoCliente());
        entity.setTipoDocCliente(dto.getTipoDocCliente());
        entity.setNumeroDocCliente(dto.getNumeroDocCliente());
        entity.setCatalogoIndustria(dto.getCatalogoIndustria());
        entity.setCodigoIndustria(dto.getCodigoIndustria());
        entity.setFechaVigenciaIndustria(dto.getFechaVigenciaIndustria());
        entity.setCatalogoOcupacion(dto.getCatalogoOcupacion());
        entity.setCodigoOcupacion(dto.getCodigoOcupacion());
        entity.setFechaVigenciaOcupacion(dto.getFechaVigenciaOcupacion());
        entity.setCatalogoPersonaJuridica(dto.getCatalogoPersonaJuridica());
        entity.setTipoPersonaJuridica(dto.getTipoPersonaJuridica());
        entity.setFechaVigenciaTipoPersonaJuridica(dto.getFechaVigenciaTipoPersonaJuridica());
        entity.setCatalogoProducto(dto.getCatalogoProducto());
        entity.setCodigoProducto(dto.getCodigoProducto());
        entity.setFechaVigenciaProducto(dto.getFechaVigenciaProducto());
        entity.setCatalogoGrupo(dto.getCatalogoGrupo());
        entity.setCodigoGrupo(dto.getCodigoGrupo());
        entity.setFechaVigenciaGrupo(dto.getFechaVigenciaGrupo());
        entity.setPaisNacimiento(dto.getPaisNacimiento());
        entity.setPaisResidencia(dto.getPaisResidencia());
        entity.setFechaVigenciaPaisResidencia(dto.getFechaVigenciaPaisResidencia());
        entity.setTipoPaisUdos(dto.getTipoPaisUdos());
        entity.setPaisResidenciaUdos(dto.getPaisResidenciaUdos());
        entity.setFechaVigenciaPaisResidenciaUdos(dto.getFechaVigenciaPaisResidenciaUdos());
        entity.setTipoPaisFiscal(dto.getTipoPaisFiscal());
        entity.setPaisResidenciaFiscal(dto.getPaisResidenciaFiscal());
        entity.setFechaVigenciaPaisResidenciaFiscal(dto.getFechaVigenciaPaisResidenciaFiscal());
        entity.setTipoPaisIncorporacion(dto.getTipoPaisIncorporacion());
        entity.setPaisIncorporacion(dto.getPaisIncorporacion());
        entity.setFechaVigenciaPaisIncorporacion(dto.getFechaVigenciaPaisIncorporacion());
        entity.setCanalOnboarding(dto.getCanalOnboarding());
        entity.setFechaCanalOnboarding(dto.getFechaCanalOnboarding());
        entity.setNroDepositosEfectivo(dto.getNroDepositosEfectivo());
        entity.setFechaVigenciaNroDepositosEfectivo(dto.getFechaVigenciaNroDepositosEfectivo());
        entity.setNroRetirosEfectivo(dto.getNroRetirosEfectivo());
        entity.setFechaVigenciaNroRetirosEfectivo(dto.getFechaVigenciaNroRetirosEfectivo());
        entity.setVolPagosInternacionales(dto.getVolPagosInternacionales());
        entity.setFechaVigenciaVolPagosInternacionales(dto.getFechaVigenciaVolPagosInternacionales());
        entity.setNroPagosInternacionales(dto.getNroPagosInternacionales());
        entity.setFechaVigenciaNroPagosInternacionales(dto.getFechaVigenciaNroPagosInternacionales());
        entity.setNroTrfAPaisesAltoRiesgo(dto.getNroTrfAPaisesAltoRiesgo());
        entity.setFechaVigenciaNroTrfAPaisesAltoRiesgo(dto.getFechaVigenciaNroTrfAPaisesAltoRiesgo());
        entity.setVolTrfAPaisesAltoRiesgo(dto.getVolTrfAPaisesAltoRiesgo());
        entity.setFechaVigenciaVolTrfAPaisesAltoRiesgo(dto.getFechaVigenciaVolTrfAPaisesAltoRiesgo());
        entity.setCalificacionRiesgoCalculado(dto.getCalificacionRiesgoCalculado());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setUsuarioModificacion(dto.getUsuarioModificacion());
        entity.setFechaModificacion(dto.getFechaModificacion());

        return entity;
    }
}

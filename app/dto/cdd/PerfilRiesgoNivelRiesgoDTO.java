package app.dto.cdd;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PerfilRiesgoNivelRiesgoDTO {

    private BigDecimal versionRiesgoCliente;
    private String tipoDocCliente;
    private String numeroDocCliente;
    private String catalogoIndustria;
    private BigDecimal codigoIndustria;
    private LocalDate fechaVigenciaIndustria;
    private String catalogoOcupacion;
    private BigDecimal codigoOcupacion;
    private LocalDate fechaVigenciaOcupacion;
    private String catalogoPersonaJuridica;
    private String tipoPersonaJuridica;
    private LocalDate fechaVigenciaTipoPersonaJuridica;
    private String catalogoProducto;
    private String codigoProducto;
    private LocalDate fechaVigenciaProducto;
    private String catalogoGrupo;
    private String codigoGrupo;
    private LocalDate fechaVigenciaGrupo;
    private BigDecimal paisNacimiento;
    private BigDecimal paisResidencia;
    private LocalDate fechaVigenciaPaisResidencia;
    private BigDecimal tipoPaisUdos;
    private BigDecimal paisResidenciaUdos;
    private LocalDate fechaVigenciaPaisResidenciaUdos;
    private BigDecimal tipoPaisFiscal;
    private BigDecimal paisResidenciaFiscal;
    private LocalDate fechaVigenciaPaisResidenciaFiscal;
    private BigDecimal tipoPaisIncorporacion;
    private BigDecimal paisIncorporacion;
    private LocalDate fechaVigenciaPaisIncorporacion;
    private String canalOnboarding;
    private LocalDate fechaCanalOnboarding;
    private BigDecimal nroDepositosEfectivo;
    private LocalDate fechaVigenciaNroDepositosEfectivo;
    private BigDecimal nroRetirosEfectivo;
    private LocalDate fechaVigenciaNroRetirosEfectivo;
    private BigDecimal volPagosInternacionales;
    private LocalDate fechaVigenciaVolPagosInternacionales;
    private BigDecimal nroPagosInternacionales;
    private LocalDate fechaVigenciaNroPagosInternacionales;
    private BigDecimal nroTrfAPaisesAltoRiesgo;
    private LocalDate fechaVigenciaNroTrfAPaisesAltoRiesgo;
    private BigDecimal volTrfAPaisesAltoRiesgo;
    private LocalDate fechaVigenciaVolTrfAPaisesAltoRiesgo;
    private BigDecimal calificacionRiesgoCalculado;
    private String usuarioCreacion;
    private LocalDateTime fechaCreacion;
    private String usuarioModificacion;
    private LocalDateTime fechaModificacion;

    public PerfilRiesgoNivelRiesgoDTO() {
    }

    public BigDecimal getVersionRiesgoCliente() {
        return versionRiesgoCliente;
    }

    public void setVersionRiesgoCliente(BigDecimal versionRiesgoCliente) {
        this.versionRiesgoCliente = versionRiesgoCliente;
    }

    public String getTipoDocCliente() {
        return tipoDocCliente;
    }

    public void setTipoDocCliente(String tipoDocCliente) {
        this.tipoDocCliente = tipoDocCliente;
    }

    public String getNumeroDocCliente() {
        return numeroDocCliente;
    }

    public void setNumeroDocCliente(String numeroDocCliente) {
        this.numeroDocCliente = numeroDocCliente;
    }

    public String getCatalogoIndustria() {
        return catalogoIndustria;
    }

    public void setCatalogoIndustria(String catalogoIndustria) {
        this.catalogoIndustria = catalogoIndustria;
    }

    public BigDecimal getCodigoIndustria() {
        return codigoIndustria;
    }

    public void setCodigoIndustria(BigDecimal codigoIndustria) {
        this.codigoIndustria = codigoIndustria;
    }

    public LocalDate getFechaVigenciaIndustria() {
        return fechaVigenciaIndustria;
    }

    public void setFechaVigenciaIndustria(LocalDate fechaVigenciaIndustria) {
        this.fechaVigenciaIndustria = fechaVigenciaIndustria;
    }

    public String getCatalogoOcupacion() {
        return catalogoOcupacion;
    }

    public void setCatalogoOcupacion(String catalogoOcupacion) {
        this.catalogoOcupacion = catalogoOcupacion;
    }

    public BigDecimal getCodigoOcupacion() {
        return codigoOcupacion;
    }

    public void setCodigoOcupacion(BigDecimal codigoOcupacion) {
        this.codigoOcupacion = codigoOcupacion;
    }

    public LocalDate getFechaVigenciaOcupacion() {
        return fechaVigenciaOcupacion;
    }

    public void setFechaVigenciaOcupacion(LocalDate fechaVigenciaOcupacion) {
        this.fechaVigenciaOcupacion = fechaVigenciaOcupacion;
    }

    public String getCatalogoPersonaJuridica() {
        return catalogoPersonaJuridica;
    }

    public void setCatalogoPersonaJuridica(String catalogoPersonaJuridica) {
        this.catalogoPersonaJuridica = catalogoPersonaJuridica;
    }

    public String getTipoPersonaJuridica() {
        return tipoPersonaJuridica;
    }

    public void setTipoPersonaJuridica(String tipoPersonaJuridica) {
        this.tipoPersonaJuridica = tipoPersonaJuridica;
    }

    public LocalDate getFechaVigenciaTipoPersonaJuridica() {
        return fechaVigenciaTipoPersonaJuridica;
    }

    public void setFechaVigenciaTipoPersonaJuridica(LocalDate fechaVigenciaTipoPersonaJuridica) {
        this.fechaVigenciaTipoPersonaJuridica = fechaVigenciaTipoPersonaJuridica;
    }

    public String getCatalogoProducto() {
        return catalogoProducto;
    }

    public void setCatalogoProducto(String catalogoProducto) {
        this.catalogoProducto = catalogoProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public LocalDate getFechaVigenciaProducto() {
        return fechaVigenciaProducto;
    }

    public void setFechaVigenciaProducto(LocalDate fechaVigenciaProducto) {
        this.fechaVigenciaProducto = fechaVigenciaProducto;
    }

    public String getCatalogoGrupo() {
        return catalogoGrupo;
    }

    public void setCatalogoGrupo(String catalogoGrupo) {
        this.catalogoGrupo = catalogoGrupo;
    }

    public String getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(String codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public LocalDate getFechaVigenciaGrupo() {
        return fechaVigenciaGrupo;
    }

    public void setFechaVigenciaGrupo(LocalDate fechaVigenciaGrupo) {
        this.fechaVigenciaGrupo = fechaVigenciaGrupo;
    }

    public BigDecimal getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(BigDecimal paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public BigDecimal getPaisResidencia() {
        return paisResidencia;
    }

    public void setPaisResidencia(BigDecimal paisResidencia) {
        this.paisResidencia = paisResidencia;
    }

    public LocalDate getFechaVigenciaPaisResidencia() {
        return fechaVigenciaPaisResidencia;
    }

    public void setFechaVigenciaPaisResidencia(LocalDate fechaVigenciaPaisResidencia) {
        this.fechaVigenciaPaisResidencia = fechaVigenciaPaisResidencia;
    }

    public BigDecimal getTipoPaisUdos() {
        return tipoPaisUdos;
    }

    public void setTipoPaisUdos(BigDecimal tipoPaisUdos) {
        this.tipoPaisUdos = tipoPaisUdos;
    }

    public BigDecimal getPaisResidenciaUdos() {
        return paisResidenciaUdos;
    }

    public void setPaisResidenciaUdos(BigDecimal paisResidenciaUdos) {
        this.paisResidenciaUdos = paisResidenciaUdos;
    }

    public LocalDate getFechaVigenciaPaisResidenciaUdos() {
        return fechaVigenciaPaisResidenciaUdos;
    }

    public void setFechaVigenciaPaisResidenciaUdos(LocalDate fechaVigenciaPaisResidenciaUdos) {
        this.fechaVigenciaPaisResidenciaUdos = fechaVigenciaPaisResidenciaUdos;
    }

    public BigDecimal getTipoPaisFiscal() {
        return tipoPaisFiscal;
    }

    public void setTipoPaisFiscal(BigDecimal tipoPaisFiscal) {
        this.tipoPaisFiscal = tipoPaisFiscal;
    }

    public BigDecimal getPaisResidenciaFiscal() {
        return paisResidenciaFiscal;
    }

    public void setPaisResidenciaFiscal(BigDecimal paisResidenciaFiscal) {
        this.paisResidenciaFiscal = paisResidenciaFiscal;
    }

    public LocalDate getFechaVigenciaPaisResidenciaFiscal() {
        return fechaVigenciaPaisResidenciaFiscal;
    }

    public void setFechaVigenciaPaisResidenciaFiscal(LocalDate fechaVigenciaPaisResidenciaFiscal) {
        this.fechaVigenciaPaisResidenciaFiscal = fechaVigenciaPaisResidenciaFiscal;
    }

    public BigDecimal getTipoPaisIncorporacion() {
        return tipoPaisIncorporacion;
    }

    public void setTipoPaisIncorporacion(BigDecimal tipoPaisIncorporacion) {
        this.tipoPaisIncorporacion = tipoPaisIncorporacion;
    }

    public BigDecimal getPaisIncorporacion() {
        return paisIncorporacion;
    }

    public void setPaisIncorporacion(BigDecimal paisIncorporacion) {
        this.paisIncorporacion = paisIncorporacion;
    }

    public LocalDate getFechaVigenciaPaisIncorporacion() {
        return fechaVigenciaPaisIncorporacion;
    }

    public void setFechaVigenciaPaisIncorporacion(LocalDate fechaVigenciaPaisIncorporacion) {
        this.fechaVigenciaPaisIncorporacion = fechaVigenciaPaisIncorporacion;
    }

    public String getCanalOnboarding() {
        return canalOnboarding;
    }

    public void setCanalOnboarding(String canalOnboarding) {
        this.canalOnboarding = canalOnboarding;
    }

    public LocalDate getFechaCanalOnboarding() {
        return fechaCanalOnboarding;
    }

    public void setFechaCanalOnboarding(LocalDate fechaCanalOnboarding) {
        this.fechaCanalOnboarding = fechaCanalOnboarding;
    }

    public BigDecimal getNroDepositosEfectivo() {
        return nroDepositosEfectivo;
    }

    public void setNroDepositosEfectivo(BigDecimal nroDepositosEfectivo) {
        this.nroDepositosEfectivo = nroDepositosEfectivo;
    }

    public LocalDate getFechaVigenciaNroDepositosEfectivo() {
        return fechaVigenciaNroDepositosEfectivo;
    }

    public void setFechaVigenciaNroDepositosEfectivo(LocalDate fechaVigenciaNroDepositosEfectivo) {
        this.fechaVigenciaNroDepositosEfectivo = fechaVigenciaNroDepositosEfectivo;
    }

    public BigDecimal getNroRetirosEfectivo() {
        return nroRetirosEfectivo;
    }

    public void setNroRetirosEfectivo(BigDecimal nroRetirosEfectivo) {
        this.nroRetirosEfectivo = nroRetirosEfectivo;
    }

    public LocalDate getFechaVigenciaNroRetirosEfectivo() {
        return fechaVigenciaNroRetirosEfectivo;
    }

    public void setFechaVigenciaNroRetirosEfectivo(LocalDate fechaVigenciaNroRetirosEfectivo) {
        this.fechaVigenciaNroRetirosEfectivo = fechaVigenciaNroRetirosEfectivo;
    }

    public BigDecimal getVolPagosInternacionales() {
        return volPagosInternacionales;
    }

    public void setVolPagosInternacionales(BigDecimal volPagosInternacionales) {
        this.volPagosInternacionales = volPagosInternacionales;
    }

    public LocalDate getFechaVigenciaVolPagosInternacionales() {
        return fechaVigenciaVolPagosInternacionales;
    }

    public void setFechaVigenciaVolPagosInternacionales(LocalDate fechaVigenciaVolPagosInternacionales) {
        this.fechaVigenciaVolPagosInternacionales = fechaVigenciaVolPagosInternacionales;
    }

    public BigDecimal getNroPagosInternacionales() {
        return nroPagosInternacionales;
    }

    public void setNroPagosInternacionales(BigDecimal nroPagosInternacionales) {
        this.nroPagosInternacionales = nroPagosInternacionales;
    }

    public LocalDate getFechaVigenciaNroPagosInternacionales() {
        return fechaVigenciaNroPagosInternacionales;
    }

    public void setFechaVigenciaNroPagosInternacionales(LocalDate fechaVigenciaNroPagosInternacionales) {
        this.fechaVigenciaNroPagosInternacionales = fechaVigenciaNroPagosInternacionales;
    }

    public BigDecimal getNroTrfAPaisesAltoRiesgo() {
        return nroTrfAPaisesAltoRiesgo;
    }

    public void setNroTrfAPaisesAltoRiesgo(BigDecimal nroTrfAPaisesAltoRiesgo) {
        this.nroTrfAPaisesAltoRiesgo = nroTrfAPaisesAltoRiesgo;
    }

    public LocalDate getFechaVigenciaNroTrfAPaisesAltoRiesgo() {
        return fechaVigenciaNroTrfAPaisesAltoRiesgo;
    }

    public void setFechaVigenciaNroTrfAPaisesAltoRiesgo(LocalDate fechaVigenciaNroTrfAPaisesAltoRiesgo) {
        this.fechaVigenciaNroTrfAPaisesAltoRiesgo = fechaVigenciaNroTrfAPaisesAltoRiesgo;
    }

    public BigDecimal getVolTrfAPaisesAltoRiesgo() {
        return volTrfAPaisesAltoRiesgo;
    }

    public void setVolTrfAPaisesAltoRiesgo(BigDecimal volTrfAPaisesAltoRiesgo) {
        this.volTrfAPaisesAltoRiesgo = volTrfAPaisesAltoRiesgo;
    }

    public LocalDate getFechaVigenciaVolTrfAPaisesAltoRiesgo() {
        return fechaVigenciaVolTrfAPaisesAltoRiesgo;
    }

    public void setFechaVigenciaVolTrfAPaisesAltoRiesgo(LocalDate fechaVigenciaVolTrfAPaisesAltoRiesgo) {
        this.fechaVigenciaVolTrfAPaisesAltoRiesgo = fechaVigenciaVolTrfAPaisesAltoRiesgo;
    }

    public BigDecimal getCalificacionRiesgoCalculado() {
        return calificacionRiesgoCalculado;
    }

    public void setCalificacionRiesgoCalculado(BigDecimal calificacionRiesgoCalculado) {
        this.calificacionRiesgoCalculado = calificacionRiesgoCalculado;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}

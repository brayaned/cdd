package app.Entity.cdd;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "CDDLAFT_PERFIL_RIESGO_NIVEL_RIESGO", schema = "CDDLAFT")
public class PerfilRiesgoNivelRiesgoEntity {

    @Id
    @Column(name = "VERSION_RIESGO_CLIENTE", nullable = false, precision = 38, scale = 0)
    private BigDecimal versionRiesgoCliente;

    @Column(name = "TIPO_DOC_CLIENTE", nullable = false, length = 2)
    private String tipoDocCliente;

    @Column(name = "NUMERO_DOC_CLIENTE", nullable = false, length = 11)
    private String numeroDocCliente;

    // Industria
    @Column(name = "CATALOGO_INDUSTRIA", nullable = false, length = 9)
    private String catalogoIndustria;

    @Column(name = "CODIGO_INDUSTRIA", nullable = false, precision = 38, scale = 0)
    private BigDecimal codigoIndustria;

    @Column(name = "FECHA_VIGENCIA_INDUSTRIA", nullable = false)
    private LocalDate fechaVigenciaIndustria;

    // Ocupación
    @Column(name = "CATALOGO_OCUPACION", nullable = false, length = 9)
    private String catalogoOcupacion;

    @Column(name = "CODIGO_OCUPACION", nullable = false, precision = 38, scale = 0)
    private BigDecimal codigoOcupacion;

    @Column(name = "FECHA_VIGENCIA_OCUPACION", nullable = false)
    private LocalDate fechaVigenciaOcupacion;

    // Persona jurídica
    @Column(name = "CATALOGO_PERSONA_JURIDICA", nullable = false, length = 9)
    private String catalogoPersonaJuridica;

    @Column(name = "TIPO_PERSONA_JURIDICA", nullable = false, length = 1)
    private String tipoPersonaJuridica;

    @Column(name = "FECHA_VIGENCIA_TIPO_PERSONA_JURIDICA", nullable = false)
    private LocalDate fechaVigenciaTipoPersonaJuridica;

    // Producto
    @Column(name = "CATALOGO_PRODUCTO", nullable = false, length = 9)
    private String catalogoProducto;

    @Column(name = "CODIGO_PRODUCTO", nullable = false, length = 3)
    private String codigoProducto;

    @Column(name = "FECHA_VIGENCIA_PRODUCTO", nullable = false)
    private LocalDate fechaVigenciaProducto;

    // Grupo
    @Column(name = "CATALOGO_GRUPO", nullable = false, length = 9)
    private String catalogoGrupo;

    @Column(name = "CODIGO_GRUPO", nullable = false, length = 9)
    private String codigoGrupo;

    @Column(name = "FECHA_VIGENCIA_GRUPO", nullable = false)
    private LocalDate fechaVigenciaGrupo;

    // Países
    @Column(name = "PAIS_NACIMIENTO", nullable = false, precision = 38, scale = 0)
    private BigDecimal paisNacimiento;

    @Column(name = "PAIS_RESIDENCIA", nullable = false, precision = 38, scale = 0)
    private BigDecimal paisResidencia;

    @Column(name = "FECHA_VIGENCIA_PAIS_RESIDENCIA", nullable = false)
    private LocalDate fechaVigenciaPaisResidencia;

    // UDOS
    @Column(name = "TIPO_PAIS_UDOS", nullable = false, precision = 38, scale = 0)
    private BigDecimal tipoPaisUdos;

    @Column(name = "PAIS_RESIDENCIA_UDOS", nullable = false, precision = 38, scale = 0)
    private BigDecimal paisResidenciaUdos;

    @Column(name = "FECHA_VIGENCIA_PAIS_RESIDENCIA_UDOS", nullable = false)
    private LocalDate fechaVigenciaPaisResidenciaUdos;

    // Fiscal
    @Column(name = "TIPO_PAIS_FISCAL", nullable = false, precision = 38, scale = 0)
    private BigDecimal tipoPaisFiscal;

    @Column(name = "PAIS_RESIDENCIA_FISCAL", nullable = false, precision = 38, scale = 0)
    private BigDecimal paisResidenciaFiscal;

    @Column(name = "FECHA_VIGENCIA_PAIS_RESIDENCIA_FISCAL", nullable = false)
    private LocalDate fechaVigenciaPaisResidenciaFiscal;

    // Incorporación
    @Column(name = "TIPO_PAIS_INCORPORACION", nullable = false, precision = 38, scale = 0)
    private BigDecimal tipoPaisIncorporacion;

    @Column(name = "PAIS_INCORPORACION", nullable = false, precision = 38, scale = 0)
    private BigDecimal paisIncorporacion;

    @Column(name = "FECHA_VIGENCIA_PAIS_INCORPORACION", nullable = false)
    private LocalDate fechaVigenciaPaisIncorporacion;

    // Canal onboarding
    @Column(name = "CANAL_ONBOARDING", nullable = false, length = 1)
    private String canalOnboarding;

    @Column(name = "FECHA_CANAL_ONBOARDING", nullable = false)
    private LocalDate fechaCanalOnboarding;

    // Cantidades / volúmenes (según capturas)
    @Column(name = "NRO_DEPOSITOS_EFECTIVO", nullable = false, precision = 38, scale = 0)
    private BigDecimal nroDepositosEfectivo;

    @Column(name = "FECHA_VIGENCIA_NRO_DEPOSITOS_EFECTIVO", nullable = false)
    private LocalDate fechaVigenciaNroDepositosEfectivo;

    @Column(name = "NRO_RETIROS_EFECTIVO", nullable = false, precision = 38, scale = 0)
    private BigDecimal nroRetirosEfectivo;

    @Column(name = "FECHA_VIGENCIA_NRO_RETIROS_EFECTIVO", nullable = false)
    private LocalDate fechaVigenciaNroRetirosEfectivo;

    @Column(name = "VOL_PAGOS_INTERNACIONALES", nullable = false, precision = 38, scale = 0)
    private BigDecimal volPagosInternacionales;

    @Column(name = "FECHA_VIGENCIA_VOL_PAGOS_INTERNACIONALES", nullable = false)
    private LocalDate fechaVigenciaVolPagosInternacionales;

    @Column(name = "NRO_PAGOS_INTERNACIONALES", nullable = false, precision = 38, scale = 0)
    private BigDecimal nroPagosInternacionales;

    @Column(name = "FECHA_VIGENCIA_NRO_PAGOS_INTERNACIONALES", nullable = false)
    private LocalDate fechaVigenciaNroPagosInternacionales;

    @Column(name = "NRO_TRF_A_PAISES_ALTO_RIESGO", nullable = false, precision = 38, scale = 0)
    private BigDecimal nroTrfAPaisesAltoRiesgo;

    @Column(name = "FECHA_VIGENCIA_NRO_TRF_A_PAISES_ALTO_RIESGO", nullable = false)
    private LocalDate fechaVigenciaNroTrfAPaisesAltoRiesgo;

    @Column(name = "VOL_TRF_A_PAISES_ALTO_RIESGO", nullable = false, precision = 38, scale = 0)
    private BigDecimal volTrfAPaisesAltoRiesgo;

    @Column(name = "FECHA_VIGENCIA_VOL_TRF_A_PAISES_ALTO_RIESGO", nullable = false)
    private LocalDate fechaVigenciaVolTrfAPaisesAltoRiesgo;

    // Cálculo / resultado
    @Column(name = "CALIFICACION_RIESGO_CALCULADO", nullable = false, precision = 5, scale = 2)
    private BigDecimal calificacionRiesgoCalculado;

    // Auditoría de registro (al final en tus capturas)
    @Column(name = "USUARIO_CREACION", nullable = false, length = 100)
    private String usuarioCreacion;

    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "USUARIO_MODIFICACION", length = 100)
    private String usuarioModificacion;

    @Column(name = "FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    public PerfilRiesgoNivelRiesgoEntity() {}

    // Getters y setters (si usas Lombok, te lo simplifico)
    public BigDecimal getVersionRiesgoCliente() { return versionRiesgoCliente; }
    public void setVersionRiesgoCliente(BigDecimal versionRiesgoCliente) { this.versionRiesgoCliente = versionRiesgoCliente; }

    public String getTipoDocCliente() { return tipoDocCliente; }
    public void setTipoDocCliente(String tipoDocCliente) { this.tipoDocCliente = tipoDocCliente; }

    public String getNumeroDocCliente() { return numeroDocCliente; }
    public void setNumeroDocCliente(String numeroDocCliente) { this.numeroDocCliente = numeroDocCliente; }

    public String getCatalogoIndustria() { return catalogoIndustria; }
    public void setCatalogoIndustria(String catalogoIndustria) { this.catalogoIndustria = catalogoIndustria; }

    public BigDecimal getCodigoIndustria() { return codigoIndustria; }
    public void setCodigoIndustria(BigDecimal codigoIndustria) { this.codigoIndustria = codigoIndustria; }

    public LocalDate getFechaVigenciaIndustria() { return fechaVigenciaIndustria; }
    public void setFechaVigenciaIndustria(LocalDate fechaVigenciaIndustria) { this.fechaVigenciaIndustria = fechaVigenciaIndustria; }

    public String getCatalogoOcupacion() { return catalogoOcupacion; }
    public void setCatalogoOcupacion(String catalogoOcupacion) { this.catalogoOcupacion = catalogoOcupacion; }

    public BigDecimal getCodigoOcupacion() { return codigoOcupacion; }
    public void setCodigoOcupacion(BigDecimal codigoOcupacion) { this.codigoOcupacion = codigoOcupacion; }

    public LocalDate getFechaVigenciaOcupacion() { return fechaVigenciaOcupacion; }
    public void setFechaVigenciaOcupacion(LocalDate fechaVigenciaOcupacion) { this.fechaVigenciaOcupacion = fechaVigenciaOcupacion; }

    public String getCatalogoPersonaJuridica() { return catalogoPersonaJuridica; }
    public void setCatalogoPersonaJuridica(String catalogoPersonaJuridica) { this.catalogoPersonaJuridica = catalogoPersonaJuridica; }

    public String getTipoPersonaJuridica() { return tipoPersonaJuridica; }
    public void setTipoPersonaJuridica(String tipoPersonaJuridica) { this.tipoPersonaJuridica = tipoPersonaJuridica; }

    public LocalDate getFechaVigenciaTipoPersonaJuridica() { return fechaVigenciaTipoPersonaJuridica; }
    public void setFechaVigenciaTipoPersonaJuridica(LocalDate fechaVigenciaTipoPersonaJuridica) { this.fechaVigenciaTipoPersonaJuridica = fechaVigenciaTipoPersonaJuridica; }

    public String getCatalogoProducto() { return catalogoProducto; }
    public void setCatalogoProducto(String catalogoProducto) { this.catalogoProducto = catalogoProducto; }

    public String getCodigoProducto() { return codigoProducto; }
    public void setCodigoProducto(String codigoProducto) { this.codigoProducto = codigoProducto; }

    public LocalDate getFechaVigenciaProducto() { return fechaVigenciaProducto; }
    public void setFechaVigenciaProducto(LocalDate fechaVigenciaProducto) { this.fechaVigenciaProducto = fechaVigenciaProducto; }

    public String getCatalogoGrupo() { return catalogoGrupo; }
    public void setCatalogoGrupo(String catalogoGrupo) { this.catalogoGrupo = catalogoGrupo; }

    public String getCodigoGrupo() { return codigoGrupo; }
    public void setCodigoGrupo(String codigoGrupo) { this.codigoGrupo = codigoGrupo; }

    public LocalDate getFechaVigenciaGrupo() { return fechaVigenciaGrupo; }
    public void setFechaVigenciaGrupo(LocalDate fechaVigenciaGrupo) { this.fechaVigenciaGrupo = fechaVigenciaGrupo; }

    public BigDecimal getPaisNacimiento() { return paisNacimiento; }
    public void setPaisNacimiento(BigDecimal paisNacimiento) { this.paisNacimiento = paisNacimiento; }

    public BigDecimal getPaisResidencia() { return paisResidencia; }
    public void setPaisResidencia(BigDecimal paisResidencia) { this.paisResidencia = paisResidencia; }

    public LocalDate getFechaVigenciaPaisResidencia() { return fechaVigenciaPaisResidencia; }
    public void setFechaVigenciaPaisResidencia(LocalDate fechaVigenciaPaisResidencia) { this.fechaVigenciaPaisResidencia = fechaVigenciaPaisResidencia; }

    public BigDecimal getTipoPaisUdos() { return tipoPaisUdos; }
    public void setTipoPaisUdos(BigDecimal tipoPaisUdos) { this.tipoPaisUdos = tipoPaisUdos; }

    public BigDecimal getPaisResidenciaUdos() { return paisResidenciaUdos; }
    public void setPaisResidenciaUdos(BigDecimal paisResidenciaUdos) { this.paisResidenciaUdos = paisResidenciaUdos; }

    public LocalDate getFechaVigenciaPaisResidenciaUdos() { return fechaVigenciaPaisResidenciaUdos; }
    public void setFechaVigenciaPaisResidenciaUdos(LocalDate fechaVigenciaPaisResidenciaUdos) { this.fechaVigenciaPaisResidenciaUdos = fechaVigenciaPaisResidenciaUdos; }

    public BigDecimal getTipoPaisFiscal() { return tipoPaisFiscal; }
    public void setTipoPaisFiscal(BigDecimal tipoPaisFiscal) { this.tipoPaisFiscal = tipoPaisFiscal; }

    public BigDecimal getPaisResidenciaFiscal() { return paisResidenciaFiscal; }
    public void setPaisResidenciaFiscal(BigDecimal paisResidenciaFiscal) { this.paisResidenciaFiscal = paisResidenciaFiscal; }

    public LocalDate getFechaVigenciaPaisResidenciaFiscal() { return fechaVigenciaPaisResidenciaFiscal; }
    public void setFechaVigenciaPaisResidenciaFiscal(LocalDate fechaVigenciaPaisResidenciaFiscal) { this.fechaVigenciaPaisResidenciaFiscal = fechaVigenciaPaisResidenciaFiscal; }

    public BigDecimal getTipoPaisIncorporacion() { return tipoPaisIncorporacion; }
    public void setTipoPaisIncorporacion(BigDecimal tipoPaisIncorporacion) { this.tipoPaisIncorporacion = tipoPaisIncorporacion; }

    public BigDecimal getPaisIncorporacion() { return paisIncorporacion; }
    public void setPaisIncorporacion(BigDecimal paisIncorporacion) { this.paisIncorporacion = paisIncorporacion; }

    public LocalDate getFechaVigenciaPaisIncorporacion() { return fechaVigenciaPaisIncorporacion; }
    public void setFechaVigenciaPaisIncorporacion(LocalDate fechaVigenciaPaisIncorporacion) { this.fechaVigenciaPaisIncorporacion = fechaVigenciaPaisIncorporacion; }

    public String getCanalOnboarding() { return canalOnboarding; }
    public void setCanalOnboarding(String canalOnboarding) { this.canalOnboarding = canalOnboarding; }

    public LocalDate getFechaCanalOnboarding() { return fechaCanalOnboarding; }
    public void setFechaCanalOnboarding(LocalDate fechaCanalOnboarding) { this.fechaCanalOnboarding = fechaCanalOnboarding; }

    public BigDecimal getNroDepositosEfectivo() { return nroDepositosEfectivo; }
    public void setNroDepositosEfectivo(BigDecimal nroDepositosEfectivo) { this.nroDepositosEfectivo = nroDepositosEfectivo; }

    public LocalDate getFechaVigenciaNroDepositosEfectivo() { return fechaVigenciaNroDepositosEfectivo; }
    public void setFechaVigenciaNroDepositosEfectivo(LocalDate fechaVigenciaNroDepositosEfectivo) { this.fechaVigenciaNroDepositosEfectivo = fechaVigenciaNroDepositosEfectivo; }

    public BigDecimal getNroRetirosEfectivo() { return nroRetirosEfectivo; }
    public void setNroRetirosEfectivo(BigDecimal nroRetirosEfectivo) { this.nroRetirosEfectivo = nroRetirosEfectivo; }

    public LocalDate getFechaVigenciaNroRetirosEfectivo() { return fechaVigenciaNroRetirosEfectivo; }
    public void setFechaVigenciaNroRetirosEfectivo(LocalDate fechaVigenciaNroRetirosEfectivo) { this.fechaVigenciaNroRetirosEfectivo = fechaVigenciaNroRetirosEfectivo; }

    public BigDecimal getVolPagosInternacionales() { return volPagosInternacionales; }
    public void setVolPagosInternacionales(BigDecimal volPagosInternacionales) { this.volPagosInternacionales = volPagosInternacionales; }

    public LocalDate getFechaVigenciaVolPagosInternacionales() { return fechaVigenciaVolPagosInternacionales; }
    public void setFechaVigenciaVolPagosInternacionales(LocalDate fechaVigenciaVolPagosInternacionales) { this.fechaVigenciaVolPagosInternacionales = fechaVigenciaVolPagosInternacionales; }

    public BigDecimal getNroPagosInternacionales() { return nroPagosInternacionales; }
    public void setNroPagosInternacionales(BigDecimal nroPagosInternacionales) { this.nroPagosInternacionales = nroPagosInternacionales; }

    public LocalDate getFechaVigenciaNroPagosInternacionales() { return fechaVigenciaNroPagosInternacionales; }
    public void setFechaVigenciaNroPagosInternacionales(LocalDate fechaVigenciaNroPagosInternacionales) { this.fechaVigenciaNroPagosInternacionales = fechaVigenciaNroPagosInternacionales; }

    public BigDecimal getNroTrfAPaisesAltoRiesgo() { return nroTrfAPaisesAltoRiesgo; }
    public void setNroTrfAPaisesAltoRiesgo(BigDecimal nroTrfAPaisesAltoRiesgo) { this.nroTrfAPaisesAltoRiesgo = nroTrfAPaisesAltoRiesgo; }

    public LocalDate getFechaVigenciaNroTrfAPaisesAltoRiesgo() { return fechaVigenciaNroTrfAPaisesAltoRiesgo; }
    public void setFechaVigenciaNroTrfAPaisesAltoRiesgo(LocalDate fechaVigenciaNroTrfAPaisesAltoRiesgo) { this.fechaVigenciaNroTrfAPaisesAltoRiesgo = fechaVigenciaNroTrfAPaisesAltoRiesgo; }

    public BigDecimal getVolTrfAPaisesAltoRiesgo() { return volTrfAPaisesAltoRiesgo; }
    public void setVolTrfAPaisesAltoRiesgo(BigDecimal volTrfAPaisesAltoRiesgo) { this.volTrfAPaisesAltoRiesgo = volTrfAPaisesAltoRiesgo; }

    public LocalDate getFechaVigenciaVolTrfAPaisesAltoRiesgo() { return fechaVigenciaVolTrfAPaisesAltoRiesgo; }
    public void setFechaVigenciaVolTrfAPaisesAltoRiesgo(LocalDate fechaVigenciaVolTrfAPaisesAltoRiesgo) { this.fechaVigenciaVolTrfAPaisesAltoRiesgo = fechaVigenciaVolTrfAPaisesAltoRiesgo; }

    public BigDecimal getCalificacionRiesgoCalculado() { return calificacionRiesgoCalculado; }
    public void setCalificacionRiesgoCalculado(BigDecimal calificacionRiesgoCalculado) { this.calificacionRiesgoCalculado = calificacionRiesgoCalculado; }

    public String getUsuarioCreacion() { return usuarioCreacion; }
    public void setUsuarioCreacion(String usuarioCreacion) { this.usuarioCreacion = usuarioCreacion; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public String getUsuarioModificacion() { return usuarioModificacion; }
    public void setUsuarioModificacion(String usuarioModificacion) { this.usuarioModificacion = usuarioModificacion; }

    public LocalDateTime getFechaModificacion() { return fechaModificacion; }
    public void setFechaModificacion(LocalDateTime fechaModificacion) { this.fechaModificacion = fechaModificacion; }
}
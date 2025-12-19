package app.dto.cdd;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RiesgoPersonaJuridicaResponse {

    private Long id;
    private BigDecimal industria;
    private BigDecimal productos;
    private BigDecimal paisResidenciaUbos;
    private BigDecimal paisResidenciaFiscal;
    private BigDecimal paisIncorporacion;
    private BigDecimal estructuraPropiedadCompleja;
    private BigDecimal tipoPersonaJuridica;
    private BigDecimal canalOnboarding;
    private BigDecimal presenciaGrupo;
    private BigDecimal exposicionPaisesProhibidos;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String usuarioCreacion;
    private LocalDateTime fechaUltimaModificacion;
    private String usuarioUltimaModificacion;

    public RiesgoPersonaJuridicaResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getIndustria() {
        return industria;
    }

    public void setIndustria(BigDecimal industria) {
        this.industria = industria;
    }

    public BigDecimal getProductos() {
        return productos;
    }

    public void setProductos(BigDecimal productos) {
        this.productos = productos;
    }

    public BigDecimal getPaisResidenciaUbos() {
        return paisResidenciaUbos;
    }

    public void setPaisResidenciaUbos(BigDecimal paisResidenciaUbos) {
        this.paisResidenciaUbos = paisResidenciaUbos;
    }

    public BigDecimal getPaisResidenciaFiscal() {
        return paisResidenciaFiscal;
    }

    public void setPaisResidenciaFiscal(BigDecimal paisResidenciaFiscal) {
        this.paisResidenciaFiscal = paisResidenciaFiscal;
    }

    public BigDecimal getPaisIncorporacion() {
        return paisIncorporacion;
    }

    public void setPaisIncorporacion(BigDecimal paisIncorporacion) {
        this.paisIncorporacion = paisIncorporacion;
    }

    public BigDecimal getEstructuraPropiedadCompleja() {
        return estructuraPropiedadCompleja;
    }

    public void setEstructuraPropiedadCompleja(BigDecimal estructuraPropiedadCompleja) {
        this.estructuraPropiedadCompleja = estructuraPropiedadCompleja;
    }

    public BigDecimal getTipoPersonaJuridica() {
        return tipoPersonaJuridica;
    }

    public void setTipoPersonaJuridica(BigDecimal tipoPersonaJuridica) {
        this.tipoPersonaJuridica = tipoPersonaJuridica;
    }

    public BigDecimal getCanalOnboarding() {
        return canalOnboarding;
    }

    public void setCanalOnboarding(BigDecimal canalOnboarding) {
        this.canalOnboarding = canalOnboarding;
    }

    public BigDecimal getPresenciaGrupo() {
        return presenciaGrupo;
    }

    public void setPresenciaGrupo(BigDecimal presenciaGrupo) {
        this.presenciaGrupo = presenciaGrupo;
    }

    public BigDecimal getExposicionPaisesProhibidos() {
        return exposicionPaisesProhibidos;
    }

    public void setExposicionPaisesProhibidos(BigDecimal exposicionPaisesProhibidos) {
        this.exposicionPaisesProhibidos = exposicionPaisesProhibidos;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public String getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public void setUsuarioUltimaModificacion(String usuarioUltimaModificacion) {
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
    }
}

package app.dto.cdd;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RiesgoPersonaNaturalResponse {

    private Long id;
    private BigDecimal industria;
    private BigDecimal ocupacion;
    private BigDecimal productos;
    private BigDecimal paisResidencia;
    private BigDecimal canalOnboarding;
    private BigDecimal ciudad;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String usuarioCreacion;
    private LocalDateTime fechaUltimaModificacion;
    private String usuarioUltimaModificacion;

    public RiesgoPersonaNaturalResponse() {
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

    public BigDecimal getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(BigDecimal ocupacion) {
        this.ocupacion = ocupacion;
    }

    public BigDecimal getProductos() {
        return productos;
    }

    public void setProductos(BigDecimal productos) {
        this.productos = productos;
    }

    public BigDecimal getPaisResidencia() {
        return paisResidencia;
    }

    public void setPaisResidencia(BigDecimal paisResidencia) {
        this.paisResidencia = paisResidencia;
    }

    public BigDecimal getCanalOnboarding() {
        return canalOnboarding;
    }

    public void setCanalOnboarding(BigDecimal canalOnboarding) {
        this.canalOnboarding = canalOnboarding;
    }

    public BigDecimal getCiudad() {
        return ciudad;
    }

    public void setCiudad(BigDecimal ciudad) {
        this.ciudad = ciudad;
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

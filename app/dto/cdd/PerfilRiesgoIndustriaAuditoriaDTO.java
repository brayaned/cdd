package app.dto.cdd;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PerfilRiesgoIndustriaAuditoriaDTO {

    private BigDecimal idConsecutivoIndustriaAuditoria;
    private String catalogo;
    private BigDecimal idCodigoIndustria;
    private String descripcionIndustria;
    private BigDecimal probabilidadRiesgo;
    private LocalDate fechaVigencia;
    private LocalDateTime fechaCreacion;
    private String usuarioCreacion;
    private LocalDateTime fechaUltimaModificacion;
    private String usuarioUltimaModificacion;

    public PerfilRiesgoIndustriaAuditoriaDTO() {
    }

    public BigDecimal getIdConsecutivoIndustriaAuditoria() {
        return idConsecutivoIndustriaAuditoria;
    }

    public void setIdConsecutivoIndustriaAuditoria(BigDecimal idConsecutivoIndustriaAuditoria) {
        this.idConsecutivoIndustriaAuditoria = idConsecutivoIndustriaAuditoria;
    }

    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }

    public BigDecimal getIdCodigoIndustria() {
        return idCodigoIndustria;
    }

    public void setIdCodigoIndustria(BigDecimal idCodigoIndustria) {
        this.idCodigoIndustria = idCodigoIndustria;
    }

    public String getDescripcionIndustria() {
        return descripcionIndustria;
    }

    public void setDescripcionIndustria(String descripcionIndustria) {
        this.descripcionIndustria = descripcionIndustria;
    }

    public BigDecimal getProbabilidadRiesgo() {
        return probabilidadRiesgo;
    }

    public void setProbabilidadRiesgo(BigDecimal probabilidadRiesgo) {
        this.probabilidadRiesgo = probabilidadRiesgo;
    }

    public LocalDate getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(LocalDate fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
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

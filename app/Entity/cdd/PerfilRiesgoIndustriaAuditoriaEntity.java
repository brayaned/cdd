package app.Entity.cdd;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "CDDLAFT_PERFIL_RIESGO_INDUSTRIA_AUDITORIA",
    schema = "CDDLAFT"
)
public class PerfilRiesgoIndustriaAuditoriaEntity {

    @Id
    @Column(name = "ID_CONSECUTIVO_INDUSTRIA_AUDITORIA", nullable = false)
    private BigDecimal idConsecutivoIndustriaAuditoria;

    @Column(name = "CATALOGO", nullable = false, length = 9)
    private String catalogo;

    @Column(name = "ID_CODIGO_INDUSTRIA", nullable = false, precision = 38, scale = 0)
    private BigDecimal idCodigoIndustria;

    @Column(name = "DESCRIPCION_INDUSTRIA", nullable = false, length = 400)
    private String descripcionIndustria;

    @Column(name = "PROBABILIDAD_RIESGO", nullable = false, precision = 5, scale = 2)
    private BigDecimal probabilidadRiesgo;

    @Column(name = "FECHA_VIGENCIA", nullable = false)
    private LocalDate fechaVigencia;

    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "USUARIO_CREACION", nullable = false, length = 100)
    private String usuarioCreacion;

    @Column(name = "FECHA_ULTIMA_MODIFICACION")
    private LocalDateTime fechaUltimaModificacion;

    @Column(name = "USUARIO_ULTIMA_MODIFICACION", length = 100)
    private String usuarioUltimaModificacion;

    public PerfilRiesgoIndustriaAuditoriaEntity() {
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

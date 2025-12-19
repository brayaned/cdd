package app.Entity.cdd;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "CDDLAFT_PERFIL_RIESGO_DEPARTAMENTOS",
    schema = "CDDLAFT"
)
public class PerfilRiesgoDepartamentosEntity {

    @Id
    @Column(name = "CODIGO_DEPARTAMENTO", nullable = false, precision = 38, scale = 0)
    private BigDecimal codigoDepartamento;

    @Column(name = "CATALOGO", nullable = false, length = 9)
    private String catalogo;

    @Column(
        name = "FECHA_VIGENCIA_RIESGO_DEPARTAMENTO",
        nullable = false
    )
    private LocalDate fechaVigenciaRiesgoDepartamento;

    @Column(
        name = "PROBABILIDAD_RIESGO",
        nullable = false,
        precision = 5,
        scale = 2
    )
    private BigDecimal probabilidadRiesgo;

    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "USUARIO_CREACION", nullable = false, length = 100)
    private String usuarioCreacion;

    @Column(name = "FECHA_ULTIMA_MODIFICACION")
    private LocalDateTime fechaUltimaModificacion;

    @Column(name = "USUARIO_ULTIMA_MODIFICACION", length = 100)
    private String usuarioUltimaModificacion;

    public PerfilRiesgoDepartamentosEntity() {
    }

    public BigDecimal getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(BigDecimal codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }

    public LocalDate getFechaVigenciaRiesgoDepartamento() {
        return fechaVigenciaRiesgoDepartamento;
    }

    public void setFechaVigenciaRiesgoDepartamento(LocalDate fechaVigenciaRiesgoDepartamento) {
        this.fechaVigenciaRiesgoDepartamento = fechaVigenciaRiesgoDepartamento;
    }

    public BigDecimal getProbabilidadRiesgo() {
        return probabilidadRiesgo;
    }

    public void setProbabilidadRiesgo(BigDecimal probabilidadRiesgo) {
        this.probabilidadRiesgo = probabilidadRiesgo;
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

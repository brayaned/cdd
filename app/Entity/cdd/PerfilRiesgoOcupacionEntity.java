package app.Entity.cdd;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "CDDLAFT_PERFIL_RIESGO_OCUPACION",
    schema = "CDDLAFT"
)
public class PerfilRiesgoOcupacionEntity {

    @Id
    @Column(name = "ID_CODIGO_OCUPACION", nullable = false, length = 2)
    private String idCodigoOcupacion;

    @Column(name = "CATALOGO", nullable = false, length = 9)
    private String catalogo;

    @Column(name = "DESCRIPCION_OCUPACION", nullable = false, length = 400)
    private String descripcionOcupacion;

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

    public PerfilRiesgoOcupacionEntity() {
    }

    public String getIdCodigoOcupacion() {
        return idCodigoOcupacion;
    }

    public void setIdCodigoOcupacion(String idCodigoOcupacion) {
        this.idCodigoOcupacion = idCodigoOcupacion;
    }

    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }

    public String getDescripcionOcupacion() {
        return descripcionOcupacion;
    }

    public void setDescripcionOcupacion(String descripcionOcupacion) {
        this.descripcionOcupacion = descripcionOcupacion;
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
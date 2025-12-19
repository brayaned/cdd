package app.Entity.cdd;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "CDDLAFT_PERFIL_RIESGO_PAIS_PROBABILIDAD_AUDITORIA",
    schema = "CDDLAFT"
)
public class PerfilRiesgoPaisProbabilidadAuditoriaEntity {

    @Id
    @Column(
        name = "ID_CONSECUTIVO_PAIS_PROBABILIDAD_AUDITORIA",
        nullable = false
    )
    private Long id;

    @Column(name = "TIPO_PAIS", nullable = false, length = 30)
    private String tipoPais;

    @Column(name = "CODIGO_PAIS", nullable = false, length = 3)
    private String codigoPais;

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

    public PerfilRiesgoPaisProbabilidadAuditoriaEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoPais() {
        return tipoPais;
    }

    public void setTipoPais(String tipoPais) {
        this.tipoPais = tipoPais;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
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

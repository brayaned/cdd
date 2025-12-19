package app.Entity.cdd;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "CDDLAFT_PERFIL_RIESGO_DEPARTAMENTO_CIUDAD_AUDITORIA",
    schema = "CDDLAFT"
)
public class PerfilRiesgoDepartamentoCiudadAuditoriaEntity {

    @Id
    @Column(name = "ID_CONSECUTIVO_DEPARTAMENTO_CIUDAD_AUDITORIA", nullable = false)
    private BigDecimal idConsecutivoDepartamentoCiudadAuditoria;

    @Column(name = "ID_ACCION", nullable = false, length = 9)
    private String idAccion;

    @Column(name = "CODIGO_DEPARTAMENTO", nullable = false, precision = 38, scale = 0)
    private BigDecimal codigoDepartamento;

    @Column(name = "CODIGO_CIUDAD", nullable = false, precision = 38, scale = 0)
    private BigDecimal codigoCiudad;

    @Column(name = "FECHA_VIGENCIA_RIESGO_DEPARTAMENTO_CIUDAD", nullable = false)
    private LocalDate fechaVigenciaRiesgoDepartamentoCiudad;

    @Column(name = "PROBABILIDAD_RIESGO", nullable = false, precision = 5, scale = 2)
    private BigDecimal probabilidadRiesgo;

    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "USUARIO_CREACION", nullable = false, length = 100)
    private String usuarioCreacion;

    @Column(name = "FECHA_ULTIMA_MODIFICACION")
    private LocalDateTime fechaUltimaModificacion;

    @Column(name = "USUARIO_ULTIMA_MODIFICACION", length = 100)
    private String usuarioUltimaModificacion;

    public PerfilRiesgoDepartamentoCiudadAuditoriaEntity() {}

    public BigDecimal getIdConsecutivoDepartamentoCiudadAuditoria() {
        return idConsecutivoDepartamentoCiudadAuditoria;
    }

    public void setIdConsecutivoDepartamentoCiudadAuditoria(BigDecimal idConsecutivoDepartamentoCiudadAuditoria) {
        this.idConsecutivoDepartamentoCiudadAuditoria = idConsecutivoDepartamentoCiudadAuditoria;
    }

    public String getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(String idAccion) {
        this.idAccion = idAccion;
    }

    public BigDecimal getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(BigDecimal codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public BigDecimal getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(BigDecimal codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public LocalDate getFechaVigenciaRiesgoDepartamentoCiudad() {
        return fechaVigenciaRiesgoDepartamentoCiudad;
    }

    public void setFechaVigenciaRiesgoDepartamentoCiudad(LocalDate fechaVigenciaRiesgoDepartamentoCiudad) {
        this.fechaVigenciaRiesgoDepartamentoCiudad = fechaVigenciaRiesgoDepartamentoCiudad;
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
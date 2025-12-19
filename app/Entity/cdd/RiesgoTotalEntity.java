package app.Entity.cdd;

import jakarta.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "CDDLAFT_PERFIL_RIESGO_TOTAL",
    schema = "CDDLAFT"
)
public class RiesgoTotalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 255)
    private String nombre;

    @Column(name = "DESCRIPCION", length = 500)
    private String descripcion;

    @Column(name = "RIESGO", length = 50)
    private String riesgo;

    @Column(name = "FECHA_VIGENCIA", nullable = false)
    private LocalDate fechaVigencia;

    @Column(name = "LIM_INF")
    private BigInteger limInf;

    @Column(name = "LIM_SUP")
    private BigInteger limSup;

    @Column(name = "TIPO", length = 50)
    private String tipo;

    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "USUARIO_CREACION", nullable = false, length = 100)
    private String usuarioCreacion;

    @Column(name = "FECHA_ULTIMA_MODIFICACION")
    private LocalDateTime fechaUltimaModificacion;

    @Column(name = "USUARIO_ULTIMA_MODIFICACION", length = 100)
    private String usuarioUltimaModificacion;

    public RiesgoTotalEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    public LocalDate getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(LocalDate fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public BigInteger getLimInf() {
        return limInf;
    }

    public void setLimInf(BigInteger limInf) {
        this.limInf = limInf;
    }

    public BigInteger getLimSup() {
        return limSup;
    }

    public void setLimSup(BigInteger limSup) {
        this.limSup = limSup;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

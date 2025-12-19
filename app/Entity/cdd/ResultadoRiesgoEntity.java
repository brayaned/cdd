package app.Entity.cdd;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "CDDLAFT_PERFIL_RESULTADO_RIESGO",
    schema = "CDDLAFT"
)
public class ResultadoRiesgoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "DOCUMENTO")
    private Double documento;

    @Column(name = "TIPO_DOCUMENTO", length = 50)
    private String tipoDocumento;

    @Column(name = "NOMBRE", length = 255)
    private String nombre;

    @Column(name = "TIPO_PERSONA", length = 50)
    private String tipoPersona;

    @Column(name = "PRODUCTO", length = 100)
    private String producto;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Column(name = "RESULTADO_RIESGO", length = 100)
    private String resultadoRiesgo;

    @Column(name = "NIVEL_RIESGO", precision = 10, scale = 2)
    private BigDecimal nivelRiesgo;

    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "USUARIO_CREACION", nullable = false, length = 100)
    private String usuarioCreacion;

    @Column(name = "FECHA_ULTIMA_MODIFICACION")
    private LocalDateTime fechaUltimaModificacion;

    @Column(name = "USUARIO_ULTIMA_MODIFICACION", length = 100)
    private String usuarioUltimaModificacion;

    public ResultadoRiesgoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDocumento() {
        return documento;
    }

    public void setDocumento(Double documento) {
        this.documento = documento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getResultadoRiesgo() {
        return resultadoRiesgo;
    }

    public void setResultadoRiesgo(String resultadoRiesgo) {
        this.resultadoRiesgo = resultadoRiesgo;
    }

    public BigDecimal getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(BigDecimal nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
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

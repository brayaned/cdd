package app.Entity.cdd;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "CDDLAFT_PERFIL_DETALLE_RESULTADO_RIESGO",
    schema = "CDDLAFT"
)
public class DetalleResultadoRiesgoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "CATALOGO", length = 100)
    private String catalogo;

    @Column(name = "VALOR", length = 255)
    private String valor;

    @Column(name = "RIESGO", precision = 10, scale = 2)
    private BigDecimal riesgo;

    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "USUARIO_CREACION", nullable = false, length = 100)
    private String usuarioCreacion;

    @Column(name = "FECHA_ULTIMA_MODIFICACION")
    private LocalDateTime fechaUltimaModificacion;

    @Column(name = "USUARIO_ULTIMA_MODIFICACION", length = 100)
    private String usuarioUltimaModificacion;

    public DetalleResultadoRiesgoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public BigDecimal getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(BigDecimal riesgo) {
        this.riesgo = riesgo;
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

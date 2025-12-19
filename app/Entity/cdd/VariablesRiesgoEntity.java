package app.Entity.cdd;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "CDDLAFT_PERFIL_VARIABLES_RIESGO",
    schema = "CDDLAFT"
)
public class VariablesRiesgoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "PORCENTAJE1", length = 50)
    private String porcentaje1;

    @Column(name = "PORCENTAJE2", length = 50)
    private String porcentaje2;

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

    public VariablesRiesgoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPorcentaje1() {
        return porcentaje1;
    }

    public void setPorcentaje1(String porcentaje1) {
        this.porcentaje1 = porcentaje1;
    }

    public String getPorcentaje2() {
        return porcentaje2;
    }

    public void setPorcentaje2(String porcentaje2) {
        this.porcentaje2 = porcentaje2;
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

package app.Entity.cdd;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "CDDLAFT_PERFIL_RIESGO_PERSONA_NATURAL",
    schema = "CDDLAFT"
)
public class RiesgoPersonaNaturalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "INDUSTRIA", precision = 5, scale = 2)
    private BigDecimal industria;

    @Column(name = "OCUPACION", precision = 5, scale = 2)
    private BigDecimal ocupacion;

    @Column(name = "PRODUCTOS", precision = 5, scale = 2)
    private BigDecimal productos;

    @Column(name = "PAIS_RESIDENCIA", precision = 5, scale = 2)
    private BigDecimal paisResidencia;

    @Column(name = "CANAL_ONBOARDING", precision = 5, scale = 2)
    private BigDecimal canalOnboarding;

    @Column(name = "CIUDAD", precision = 5, scale = 2)
    private BigDecimal ciudad;

    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "USUARIO_CREACION", nullable = false, length = 100)
    private String usuarioCreacion;

    @Column(name = "FECHA_ULTIMA_MODIFICACION")
    private LocalDateTime fechaUltimaModificacion;

    @Column(name = "USUARIO_ULTIMA_MODIFICACION", length = 100)
    private String usuarioUltimaModificacion;

    public RiesgoPersonaNaturalEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getIndustria() {
        return industria;
    }

    public void setIndustria(BigDecimal industria) {
        this.industria = industria;
    }

    public BigDecimal getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(BigDecimal ocupacion) {
        this.ocupacion = ocupacion;
    }

    public BigDecimal getProductos() {
        return productos;
    }

    public void setProductos(BigDecimal productos) {
        this.productos = productos;
    }

    public BigDecimal getPaisResidencia() {
        return paisResidencia;
    }

    public void setPaisResidencia(BigDecimal paisResidencia) {
        this.paisResidencia = paisResidencia;
    }

    public BigDecimal getCanalOnboarding() {
        return canalOnboarding;
    }

    public void setCanalOnboarding(BigDecimal canalOnboarding) {
        this.canalOnboarding = canalOnboarding;
    }

    public BigDecimal getCiudad() {
        return ciudad;
    }

    public void setCiudad(BigDecimal ciudad) {
        this.ciudad = ciudad;
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

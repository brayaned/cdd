package app.Entity.cdd;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "CDDLAFT_PERFIL_RIESGO_PERSONA_JURIDICA",
    schema = "CDDLAFT"
)
public class RiesgoPersonaJuridicaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "INDUSTRIA", precision = 5, scale = 2)
    private BigDecimal industria;

    @Column(name = "PRODUCTOS", precision = 5, scale = 2)
    private BigDecimal productos;

    @Column(name = "PAIS_RESIDENCIA_UBOS", precision = 5, scale = 2)
    private BigDecimal paisResidenciaUbos;

    @Column(name = "PAIS_RESIDENCIA_FISCAL", precision = 5, scale = 2)
    private BigDecimal paisResidenciaFiscal;

    @Column(name = "PAIS_INCORPORACION", precision = 5, scale = 2)
    private BigDecimal paisIncorporacion;

    @Column(name = "ESTRUCTURA_PROPIEDAD_COMPLEJA", precision = 5, scale = 2)
    private BigDecimal estructuraPropiedadCompleja;

    @Column(name = "TIPO_PERSONA_JURIDICA", precision = 5, scale = 2)
    private BigDecimal tipoPersonaJuridica;

    @Column(name = "CANAL_ONBOARDING", precision = 5, scale = 2)
    private BigDecimal canalOnboarding;

    @Column(name = "PRESENCIA_GRUPO", precision = 5, scale = 2)
    private BigDecimal presenciaGrupo;

    @Column(name = "EXPOSICION_PAISES_PROHIBIDOS", precision = 5, scale = 2)
    private BigDecimal exposicionPaisesProhibidos;

    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "USUARIO_CREACION", nullable = false, length = 100)
    private String usuarioCreacion;

    @Column(name = "FECHA_ULTIMA_MODIFICACION")
    private LocalDateTime fechaUltimaModificacion;

    @Column(name = "USUARIO_ULTIMA_MODIFICACION", length = 100)
    private String usuarioUltimaModificacion;

    public RiesgoPersonaJuridicaEntity() {
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

    public BigDecimal getProductos() {
        return productos;
    }

    public void setProductos(BigDecimal productos) {
        this.productos = productos;
    }

    public BigDecimal getPaisResidenciaUbos() {
        return paisResidenciaUbos;
    }

    public void setPaisResidenciaUbos(BigDecimal paisResidenciaUbos) {
        this.paisResidenciaUbos = paisResidenciaUbos;
    }

    public BigDecimal getPaisResidenciaFiscal() {
        return paisResidenciaFiscal;
    }

    public void setPaisResidenciaFiscal(BigDecimal paisResidenciaFiscal) {
        this.paisResidenciaFiscal = paisResidenciaFiscal;
    }

    public BigDecimal getPaisIncorporacion() {
        return paisIncorporacion;
    }

    public void setPaisIncorporacion(BigDecimal paisIncorporacion) {
        this.paisIncorporacion = paisIncorporacion;
    }

    public BigDecimal getEstructuraPropiedadCompleja() {
        return estructuraPropiedadCompleja;
    }

    public void setEstructuraPropiedadCompleja(BigDecimal estructuraPropiedadCompleja) {
        this.estructuraPropiedadCompleja = estructuraPropiedadCompleja;
    }

    public BigDecimal getTipoPersonaJuridica() {
        return tipoPersonaJuridica;
    }

    public void setTipoPersonaJuridica(BigDecimal tipoPersonaJuridica) {
        this.tipoPersonaJuridica = tipoPersonaJuridica;
    }

    public BigDecimal getCanalOnboarding() {
        return canalOnboarding;
    }

    public void setCanalOnboarding(BigDecimal canalOnboarding) {
        this.canalOnboarding = canalOnboarding;
    }

    public BigDecimal getPresenciaGrupo() {
        return presenciaGrupo;
    }

    public void setPresenciaGrupo(BigDecimal presenciaGrupo) {
        this.presenciaGrupo = presenciaGrupo;
    }

    public BigDecimal getExposicionPaisesProhibidos() {
        return exposicionPaisesProhibidos;
    }

    public void setExposicionPaisesProhibidos(BigDecimal exposicionPaisesProhibidos) {
        this.exposicionPaisesProhibidos = exposicionPaisesProhibidos;
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

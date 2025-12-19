package app.Entity.cdd;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "CDDLAFT_PERFIL_RIESGO_CATALOGOS")
@IdClass(CatalogosId.class)
public class CatalogosEntity {

    @Id
    @Column(name = "NOMBRE_CATALOGO", nullable = false, length = 9)
    private String nombreCatalogo;

    @Id
    @Column(name = "TIPO_CATALOGO", nullable = false, length = 2)
    private String tipoCatalogo;

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

    public CatalogosEntity() {}

    // getters y setters (si usas Lombok, te lo dejo abajo)
    public String getNombreCatalogo() { return nombreCatalogo; }
    public void setNombreCatalogo(String nombreCatalogo) { this.nombreCatalogo = nombreCatalogo; }

    public String getTipoCatalogo() { return tipoCatalogo; }
    public void setTipoCatalogo(String tipoCatalogo) { this.tipoCatalogo = tipoCatalogo; }

    public BigDecimal getProbabilidadRiesgo() { return probabilidadRiesgo; }
    public void setProbabilidadRiesgo(BigDecimal probabilidadRiesgo) { this.probabilidadRiesgo = probabilidadRiesgo; }

    public LocalDate getFechaVigencia() { return fechaVigencia; }
    public void setFechaVigencia(LocalDate fechaVigencia) { this.fechaVigencia = fechaVigencia; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public String getUsuarioCreacion() { return usuarioCreacion; }
    public void setUsuarioCreacion(String usuarioCreacion) { this.usuarioCreacion = usuarioCreacion; }

    public LocalDateTime getFechaUltimaModificacion() { return fechaUltimaModificacion; }
    public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) { this.fechaUltimaModificacion = fechaUltimaModificacion; }

    public String getUsuarioUltimaModificacion() { return usuarioUltimaModificacion; }
    public void setUsuarioUltimaModificacion(String usuarioUltimaModificacion) { this.usuarioUltimaModificacion = usuarioUltimaModificacion; }
}
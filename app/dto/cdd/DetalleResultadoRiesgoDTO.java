package app.dto.cdd;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DetalleResultadoRiesgoDTO {

    private Long id;
    private String catalogo;
    private String valor;
    private BigDecimal riesgo;
    private LocalDateTime fechaCreacion;
    private String usuarioCreacion;
    private LocalDateTime fechaUltimaModificacion;
    private String usuarioUltimaModificacion;

    public DetalleResultadoRiesgoDTO() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCatalogo() { return catalogo; }
    public void setCatalogo(String catalogo) { this.catalogo = catalogo; }

    public String getValor() { return valor; }
    public void setValor(String valor) { this.valor = valor; }

    public BigDecimal getRiesgo() { return riesgo; }
    public void setRiesgo(BigDecimal riesgo) { this.riesgo = riesgo; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public String getUsuarioCreacion() { return usuarioCreacion; }
    public void setUsuarioCreacion(String usuarioCreacion) { this.usuarioCreacion = usuarioCreacion; }

    public LocalDateTime getFechaUltimaModificacion() { return fechaUltimaModificacion; }
    public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) { this.fechaUltimaModificacion = fechaUltimaModificacion; }

    public String getUsuarioUltimaModificacion() { return usuarioUltimaModificacion; }
    public void setUsuarioUltimaModificacion(String usuarioUltimaModificacion) { this.usuarioUltimaModificacion = usuarioUltimaModificacion; }
}

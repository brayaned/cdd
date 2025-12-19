package app.dto.cdd;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PerfilRiesgoDepartamentoCiudadDTO {

    private String catalogo;
    private BigDecimal codigoDepartamento;
    private BigDecimal codigoCiudad;
    private LocalDate fechaVigenciaRiesgoDepartamentoCiudad;
    private BigDecimal probabilidadRiesgo;
    private LocalDateTime fechaCreacion;
    private String usuarioCreacion;
    private LocalDateTime fechaUltimaModificacion;
    private String usuarioUltimaModificacion;

    public PerfilRiesgoDepartamentoCiudadDTO() {
    }

    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
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

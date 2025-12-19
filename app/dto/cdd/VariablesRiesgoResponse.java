package app.dto.cdd;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class VariablesRiesgoResponse {

    private Long id;
    private String porcentaje1;
    private String porcentaje2;
    private LocalDate fechaVigencia;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String usuarioCreacion;
    private LocalDateTime fechaUltimaModificacion;
    private String usuarioUltimaModificacion;

    public VariablesRiesgoResponse() {
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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

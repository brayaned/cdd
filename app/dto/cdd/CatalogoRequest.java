package app.dto.cdd;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CatalogoRequest {

    private String id;
    private String nombre;
    private String descripcion;
    private BigDecimal riesgo;
    private LocalDate fechaVigencia;
    private String tipo;

    public CatalogoRequest() {
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public BigDecimal getRiesgo() { return riesgo; }
    public void setRiesgo(BigDecimal riesgo) { this.riesgo = riesgo; }

    public LocalDate getFechaVigencia() { return fechaVigencia; }
    public void setFechaVigencia(LocalDate fechaVigencia) { this.fechaVigencia = fechaVigencia; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}

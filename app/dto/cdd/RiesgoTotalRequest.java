package app.dto.cdd;

import java.math.BigInteger;
import java.time.LocalDate;

public class RiesgoTotalRequest {

    private String nombre;
    private String descripcion;
    private String riesgo;
    private LocalDate fechaVigencia;
    private BigInteger limInf;
    private BigInteger limSup;
    private String tipo;

    public RiesgoTotalRequest() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    public LocalDate getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(LocalDate fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public BigInteger getLimInf() {
        return limInf;
    }

    public void setLimInf(BigInteger limInf) {
        this.limInf = limInf;
    }

    public BigInteger getLimSup() {
        return limSup;
    }

    public void setLimSup(BigInteger limSup) {
        this.limSup = limSup;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

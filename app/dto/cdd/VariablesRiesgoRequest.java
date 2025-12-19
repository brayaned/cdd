package app.dto.cdd;

import java.time.LocalDate;

public class VariablesRiesgoRequest {

    private String porcentaje1;
    private String porcentaje2;
    private LocalDate fechaVigencia;

    public VariablesRiesgoRequest() {
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
}

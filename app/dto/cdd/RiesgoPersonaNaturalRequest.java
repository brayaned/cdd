package app.dto.cdd;

import java.math.BigDecimal;

public class RiesgoPersonaNaturalRequest {

    private BigDecimal industria;
    private BigDecimal ocupacion;
    private BigDecimal productos;
    private BigDecimal paisResidencia;
    private BigDecimal canalOnboarding;
    private BigDecimal ciudad;

    public RiesgoPersonaNaturalRequest() {
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
}

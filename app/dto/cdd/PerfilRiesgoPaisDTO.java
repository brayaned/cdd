package app.dto.cdd;

public class PerfilRiesgoPaisDTO {

    private String paisCodigo;
    private String descripcionPais;

    public PerfilRiesgoPaisDTO() {
    }

    public String getPaisCodigo() {
        return paisCodigo;
    }

    public void setPaisCodigo(String paisCodigo) {
        this.paisCodigo = paisCodigo;
    }

    public String getDescripcionPais() {
        return descripcionPais;
    }

    public void setDescripcionPais(String descripcionPais) {
        this.descripcionPais = descripcionPais;
    }
}

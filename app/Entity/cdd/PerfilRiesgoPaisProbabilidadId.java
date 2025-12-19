package app.Entity.cdd;

import java.io.Serializable;
import java.util.Objects;

public class PerfilRiesgoPaisProbabilidadId implements Serializable {

    private String tipoPais;
    private String codigoPais;

    public PerfilRiesgoPaisProbabilidadId() {
    }

    public PerfilRiesgoPaisProbabilidadId(String tipoPais, String codigoPais) {
        this.tipoPais = tipoPais;
        this.codigoPais = codigoPais;
    }

    public String getTipoPais() {
        return tipoPais;
    }

    public void setTipoPais(String tipoPais) {
        this.tipoPais = tipoPais;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerfilRiesgoPaisProbabilidadId that = (PerfilRiesgoPaisProbabilidadId) o;
        return Objects.equals(tipoPais, that.tipoPais) &&
               Objects.equals(codigoPais, that.codigoPais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoPais, codigoPais);
    }
}

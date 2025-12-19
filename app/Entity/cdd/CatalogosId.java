package app.Entity.cdd;

import java.io.Serializable;
import java.util.Objects;

public class CatalogosId implements Serializable {

    private String nombreCatalogo;
    private String tipoCatalogo;

    public CatalogosId() {
    }

    public CatalogosId(String nombreCatalogo, String tipoCatalogo) {
        this.nombreCatalogo = nombreCatalogo;
        this.tipoCatalogo = tipoCatalogo;
    }

    public String getNombreCatalogo() {
        return nombreCatalogo;
    }

    public void setNombreCatalogo(String nombreCatalogo) {
        this.nombreCatalogo = nombreCatalogo;
    }

    public String getTipoCatalogo() {
        return tipoCatalogo;
    }

    public void setTipoCatalogo(String tipoCatalogo) {
        this.tipoCatalogo = tipoCatalogo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogosId that = (CatalogosId) o;
        return Objects.equals(nombreCatalogo, that.nombreCatalogo) &&
               Objects.equals(tipoCatalogo, that.tipoCatalogo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreCatalogo, tipoCatalogo);
    }
}

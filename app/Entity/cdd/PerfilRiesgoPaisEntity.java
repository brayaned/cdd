package app.Entity.cdd;

import jakarta.persistence.*;

@Entity
@Table(
    name = "CDDLAFT_PERFIL_RIESGO_PAIS",
    schema = "CDDLAFT"
)
public class PerfilRiesgoPaisEntity {

    @Id
    @Column(name = "PAIS_CODIGO", nullable = false, length = 3)
    private String paisCodigo;

    @Column(name = "DESCRIPCION_PAIS", nullable = false, length = 100)
    private String descripcionPais;

    public PerfilRiesgoPaisEntity() {
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
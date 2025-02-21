package AD.Vinoteca.models;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity(name = "regiones")
@Schema(description = "Modelo que representa una región en el sistema.")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único de la región.", example = "1")
    private int id;

    @Column
    @Schema(description = "Nombre de la región.", example = "Mendoza")
    private String nombre;

    @Column
    @Schema(description = "Descripción de la región.", example = "Región vitivinícola de Argentina.")
    private String region;

    public Region() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
package AD.Vinoteca.models;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity(name = "bodegas")
@Schema(description = "Modelo que representa una bodega en el sistema.")
public class Bodega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único de la bodega.", example = "1")
    private int id;

    @Column
    @Schema(description = "Nombre de la bodega.", example = "Bodega Los Vinos")
    private String nombre;

    @Column
    @Schema(description = "Ubicación de la bodega.", example = "Mendoza, Argentina")
    private String ubicacion;

    @Column(name = "anho_establecimiento")
    @Schema(description = "Año de establecimiento de la bodega.", example = "1995")
    private int anho_establecimiento;

    @ManyToOne
    @JoinColumn(name = "region_id")
    @Schema(description = "Región a la que pertenece la bodega.")
    private Region region;

    public Bodega() {
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getAnho_establecimiento() {
        return anho_establecimiento;
    }

    public void setAnho_establecimiento(int anho_establecimiento) {
        this.anho_establecimiento = anho_establecimiento;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
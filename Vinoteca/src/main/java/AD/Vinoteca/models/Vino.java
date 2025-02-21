package AD.Vinoteca.models;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity(name = "vinos")
@Schema(description = "Modelo que representa un vino en el sistema.")
public class Vino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único del vino.", example = "1")
    private int id;

    @Column
    @Schema(description = "Nombre del vino.", example = "Cabernet Sauvignon")
    private String nombre;

    @Column
    @Schema(description = "Cantidad disponible del vino en stock.", example = "100")
    private int cantidad;

    @Column(name = "variedad_uva")
    @Schema(description = "Variedad de uva del vino.", example = "Cabernet Sauvignon")
    private String variedad_uva;

    @Column
    @Schema(description = "Año de producción del vino.", example = "2020")
    private int anho;

    @Column
    @Schema(description = "Precio del vino.", example = "15.99")
    private double precio;

    @Column
    @Schema(description = "Descripción del vino.", example = "Un vino tinto robusto con notas de frutas.")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "bodega_id")
    @Schema(description = "Bodega a la que pertenece el vino.")
    private Bodega bodega;

    public Vino() {
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getVariedad_uva() {
        return variedad_uva;
    }

    public void setVariedad_uva(String variedad_uva) {
        this.variedad_uva = variedad_uva;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
}
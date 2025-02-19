package AD.Vinoteca.models;


import jakarta.persistence.*;

@Entity(name = "vinos")
public class Vino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column
    private int cantidad;

    @Column
    private String variedad_uva;

    @Column
    private int anho;

    @Column
    private double precio;

    @Column
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "bodega_id")
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
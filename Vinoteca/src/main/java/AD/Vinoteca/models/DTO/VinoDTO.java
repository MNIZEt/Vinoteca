package AD.Vinoteca.models.DTO;

public class VinoDTO {


    private int id;


    private String nombre;

    private int cantidad;

    private String variedad_uva;

    private int anho;


    private double precio;


    private String descripcion;


    private int bodegaId;

    public VinoDTO() {
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

    public int getBodegaId() {
        return bodegaId;
    }

    public void setBodegaId(int bodegaId) {
        this.bodegaId = bodegaId;
    }
}
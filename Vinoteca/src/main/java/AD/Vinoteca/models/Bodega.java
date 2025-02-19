package AD.Vinoteca.models;

import jakarta.persistence.*;


@Entity(name = "bodegas")
public class Bodega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column
    private String ubicacion;

    @Column
    private int anho_establecimiento;

    @ManyToOne
    @JoinColumn(name = "region_id")
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
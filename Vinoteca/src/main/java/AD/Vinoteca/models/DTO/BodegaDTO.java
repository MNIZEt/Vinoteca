package AD.Vinoteca.models.DTO;

import AD.Vinoteca.models.Region;

public class BodegaDTO {

    private int id;

    private String nombre;

    private String ubicacion;

    private int anho_establecimiento;

    private int regionId;

    public BodegaDTO() {
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

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
}

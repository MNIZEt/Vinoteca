package AD.Vinoteca.models.DTO;

import java.time.LocalDate;

public class ResenhaDTO {

    private int id;

    private String titulo;


    private String texto;


    private int calificacion;


    private LocalDate fecha;


    private int vinoId;

    private int usuarioId;

    public ResenhaDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getVinoId() {
        return vinoId;
    }

    public void setVinoId(int vinoId) {
        this.vinoId = vinoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}

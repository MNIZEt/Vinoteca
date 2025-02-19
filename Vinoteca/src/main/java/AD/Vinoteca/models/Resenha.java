package AD.Vinoteca.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "resenhas")
public class Resenha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String titulo;

    @Column
    private String texto;

    @Column
    private int calificacion;

    @Column
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "vino_id")
    private Vino vino;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Resenha() {
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

    public Vino getVino() {
        return vino;
    }

    public void setVino(Vino vino) {
        this.vino = vino;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
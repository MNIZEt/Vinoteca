package AD.Vinoteca.models;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Entity(name = "resenhas")
@Schema(description = "Modelo que representa una reseña de un vino en el sistema.")
public class Resenha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único de la reseña.", example = "1")
    private int id;

    @Column
    @Schema(description = "Título de la reseña.", example = "Excelente vino")
    private String titulo;

    @Column
    @Schema(description = "Texto de la reseña.", example = "Este vino tiene un sabor excepcional y un aroma encantador.")
    private String texto;

    @Column
    @Schema(description = "Calificación del vino (1 a 5).", example = "5")
    private int calificacion;

    @Column
    @Schema(description = "Fecha en que se realizó la reseña.", example = "2023-10-01")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "vino_id")
    @Schema(description = "Vino al que pertenece la reseña.")
    private Vino vino;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @Schema(description = "Usuario que realizó la reseña.")
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
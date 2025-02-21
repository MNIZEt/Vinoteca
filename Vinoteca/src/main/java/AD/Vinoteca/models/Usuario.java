package AD.Vinoteca.models;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Entity(name = "usuarios")
@Schema(description = "Modelo que representa a un usuario en el sistema.")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único del usuario.", example = "1")
    private int id;

    @Column
    @Schema(description = "Nombre del usuario.", example = "Juan Pérez")
    private String nombre;

    @Column
    @Schema(description = "Correo electrónico del usuario.", example = "juan.perez@example.com")
    private String email;

    @Column(name = "fecha_registro")
    @Schema(description = "Fecha de registro del usuario.", example = "2023-10-01")
    private LocalDate fecha_registro;

    public Usuario() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}
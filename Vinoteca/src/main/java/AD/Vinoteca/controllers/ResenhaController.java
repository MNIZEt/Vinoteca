package AD.Vinoteca.controllers;

import AD.Vinoteca.models.DTO.ResenhaDTO;
import AD.Vinoteca.models.Resenha;
import AD.Vinoteca.repositories.ResenhaRepository;
import AD.Vinoteca.repositories.UsuarioRepository;
import AD.Vinoteca.repositories.VinoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/resenhas")
public class ResenhaController {

    @Autowired
    private ResenhaRepository resenhaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VinoRepository vinoRepository;

    @GetMapping
    @Operation(summary = "Obtener todas las reseñas", description = "Devuelve una lista de todas las reseñas registradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de reseñas obtenida correctamente."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public List<Resenha> obtenerTodas() {
        return resenhaRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener reseña por ID", description = "Devuelve una reseña específica basada en su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reseña encontrada."),
            @ApiResponse(responseCode = "404", description = "Reseña no encontrada."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public Resenha obtenerPorId(@Parameter(description = "ID de la reseña a obtener", required = true) @PathVariable int id) {
        return resenhaRepository.findById(id).orElse(null);
    }

    @PostMapping
    @Operation(summary = "Guardar una nueva reseña", description = "Crea una nueva reseña en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Reseña creada correctamente."),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public Resenha guardar(@RequestBody ResenhaDTO resenhaDTO) {
        Resenha resenha = new Resenha();
        resenha.setId(resenhaDTO.getId());
        resenha.setTitulo(resenhaDTO.getTitulo());
        resenha.setTexto(resenhaDTO.getTexto());
        resenha.setCalificacion(resenhaDTO.getCalificacion());
        resenha.setFecha(resenhaDTO.getFecha());
        resenha.setUsuario(usuarioRepository.findById(resenhaDTO.getUsuarioId()).orElse(null));
        resenha.setVino(vinoRepository.findById(resenhaDTO.getVinoId()).orElse(null)); // Cambiado a vinoId
        return resenhaRepository.save(resenha);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una reseña", description = "Actualiza una reseña existente en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reseña actualizada correctamente."),
            @ApiResponse(responseCode = "404", description = "Reseña no encontrada."),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public Resenha actualizar(@Parameter(description = "ID de la reseña a actualizar", required = true) @PathVariable int id,
                              @RequestBody ResenhaDTO resenhaDTO) {
        Resenha resenha = new Resenha();
        resenha.setId(id);
        resenha.setTitulo(resenhaDTO.getTitulo());
        resenha.setTexto(resenhaDTO.getTexto());
        resenha.setCalificacion(resenhaDTO.getCalificacion());
        resenha.setFecha(resenhaDTO.getFecha());
        resenha.setUsuario(usuarioRepository.findById(resenhaDTO.getUsuarioId()).orElse(null));
        resenha.setVino(vinoRepository.findById(resenhaDTO.getVinoId()).orElse(null)); // Cambiado a vinoId
        return resenhaRepository.save(resenha);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar una reseña", description = "Elimina una reseña del sistema basada en id")
    public void borrar(@PathVariable int id){
        resenhaRepository.deleteById(id);
    }
}

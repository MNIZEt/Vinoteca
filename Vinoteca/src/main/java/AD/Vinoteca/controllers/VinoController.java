package AD.Vinoteca.controllers;

import AD.Vinoteca.models.DTO.VinoDTO;
import AD.Vinoteca.models.Vino;
import AD.Vinoteca.repositories.BodegaRepository;
import AD.Vinoteca.repositories.VinoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vinos")
public class VinoController {

    @Autowired
    private VinoRepository vinoRepository;

    @Autowired
    private BodegaRepository bodegaRepository;

    @GetMapping
    @Operation(summary = "Obtener todas las vinos", description = "Devuelve una lista de todos los vinos disponibles.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de vinos obtenida correctamente."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public List<Vino> obtenerTodas() {
        return vinoRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener vino por ID", description = "Devuelve un vino específico basado en su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vino encontrado."),
            @ApiResponse(responseCode = "404", description = "Vino no encontrado."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public Vino obtenerPorId(@Parameter(description = "ID del vino a obtener", required = true) @PathVariable int id) {
        return vinoRepository.findById(id).orElse(null);
    }

    @PostMapping
    @Operation(summary = "Guardar un nuevo vino", description = "Crea un nuevo vino en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Vino creado correctamente."),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public Vino guardar(@RequestBody VinoDTO vinoDTO) {
        Vino vino = new Vino();
        vino.setId(vinoDTO.getId());
        vino.setAnho(vinoDTO.getAnho());
        vino.setBodega(bodegaRepository.findById(vinoDTO.getBodegaId()).orElse(null));
        vino.setNombre(vinoDTO.getNombre());
        vino.setCantidad(vinoDTO.getCantidad());
        vino.setDescripcion(vinoDTO.getDescripcion());
        vino.setPrecio(vinoDTO.getPrecio());
        vino.setVariedad_uva(vinoDTO.getVariedad_uva());
        return vinoRepository.save(vino);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un vino", description = "Actualiza un vino existente en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vino actualizado correctamente."),
            @ApiResponse(responseCode = "404", description = "Vino no encontrado."),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public Vino actualizar(@Parameter(description = "ID del vino a actualizar", required = true) @PathVariable int id,
                           @RequestBody VinoDTO vinoDTO) {
        Vino vino = new Vino();
        vino.setId(id);
        vino.setAnho(vinoDTO.getAnho());
        vino.setBodega(bodegaRepository.findById(vinoDTO.getBodegaId()).orElse(null));
        vino.setNombre(vinoDTO.getNombre());
        vino.setCantidad(vinoDTO.getCantidad());
        vino.setDescripcion(vinoDTO.getDescripcion());
        vino.setPrecio(vinoDTO.getPrecio());
        vino.setVariedad_uva(vinoDTO.getVariedad_uva());
        return vinoRepository.save(vino);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar un vino", description = "Elimina un vino del sistema basado en su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Vino eliminado correctamente."),
            @ApiResponse(responseCode = "404", description = "Vino no encontrado."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public void borrar(@PathVariable int id) {
        vinoRepository.deleteById(id);
    }
}
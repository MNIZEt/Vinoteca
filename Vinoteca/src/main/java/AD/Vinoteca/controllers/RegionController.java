package AD.Vinoteca.controllers;

import AD.Vinoteca.models.Region;
import AD.Vinoteca.repositories.RegionRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/regiones")
public class RegionController {

    @Autowired
    private RegionRepository regionRepository;

    @GetMapping
    @Operation(summary = "Obtener todas las regiones", description = "Devuelve una lista de todas las regiones registradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de regiones obtenida correctamente."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public List<Region> obtenerTodas() {
        return regionRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener región por ID", description = "Devuelve una región específica basada en su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Región encontrada."),
            @ApiResponse(responseCode = "404", description = "Región no encontrada."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public Region obtenerPorId(@Parameter(description = "ID de la región a obtener", required = true) @PathVariable int id) {
        return regionRepository.findById(id).orElse(null);
    }

    @PostMapping
    @Operation(summary = "Guardar una nueva región", description = "Crea una nueva región en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Región creada correctamente."),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public Region guardar(@RequestBody Region region) {
        return regionRepository.save(region);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una región", description = "Actualiza una región existente en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Región actualizada correctamente."),
            @ApiResponse(responseCode = "404", description = "Región no encontrada."),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public Region actualizar(@Parameter(description = "ID de la región a actualizar", required = true) @PathVariable int id,
                             @RequestBody Region region) {
        region.setId(id);
        return regionRepository.save(region);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar una región", description = "Elimina una región del sistema basada en su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Región eliminada correctamente."),
            @ApiResponse(responseCode = "404", description = "Región no encontrada."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public void borrar(@Parameter(description = "ID de la región a eliminar", required = true) @PathVariable int id) {
        regionRepository.deleteById(id);
    }
}
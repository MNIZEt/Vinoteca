package AD.Vinoteca.controllers;

import AD.Vinoteca.models.Bodega;
import AD.Vinoteca.models.DTO.BodegaDTO;
import AD.Vinoteca.repositories.BodegaRepository;
import AD.Vinoteca.repositories.RegionRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bodegas")
public class BodegaController {

    @Autowired
    private BodegaRepository bodegaRepository;

    @Autowired
    private RegionRepository regionRepository;

    @GetMapping
    @Operation(summary = "Obtener todas las bodegas", description = "Devuelve una lista de todas las bodegas registradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de bodegas obtenida correctamente."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public List<Bodega> obtenerTodas() {
        return bodegaRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener bodega por ID", description = "Devuelve una bodega específica basada en su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bodega encontrada."),
            @ApiResponse(responseCode = "404", description = "Bodega no encontrada."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public Bodega obtenerPorId(@Parameter(description = "ID de la bodega a obtener", required = true) @PathVariable int id) {
        return bodegaRepository.findById(id).orElse(null);
    }

    @PostMapping
    @Operation(summary = "Guardar una nueva bodega", description = "Crea una nueva bodega en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Bodega creada correctamente."),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public Bodega guardar(@RequestBody BodegaDTO bodegaDTO) {
        Bodega bodega = new Bodega();
        bodega.setId(bodegaDTO.getId());
        bodega.setNombre(bodegaDTO.getNombre());
        bodega.setUbicacion(bodegaDTO.getUbicacion());
        bodega.setAnho_establecimiento(bodegaDTO.getAnho_establecimiento());
        bodega.setRegion(regionRepository.findById(bodegaDTO.getRegionId()).orElse(null));
        return bodegaRepository.save(bodega);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una bodega", description = "Actualiza una bodega existente en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bodega actualizada correctamente."),
            @ApiResponse(responseCode = "404", description = "Bodega no encontrada."),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public Bodega actualizar(@Parameter(description = "ID de la bodega a actualizar", required = true) @PathVariable int id,
                             @RequestBody BodegaDTO bodegaDTO) {
        Bodega bodega = new Bodega();
        bodega.setId(id);
        bodega.setNombre(bodegaDTO.getNombre());
        bodega.setUbicacion(bodegaDTO.getUbicacion());
        bodega.setAnho_establecimiento(bodegaDTO.getAnho_establecimiento());
        bodega.setRegion(regionRepository.findById(bodegaDTO.getRegionId()).orElse(null));
        return bodegaRepository.save(bodega);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar una bodega", description = "Elimina una bodega del sistema basada en su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Bodega eliminada correctamente."),
            @ApiResponse(responseCode = "404", description = "Bodega no encontrada."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public void borrar(@Parameter(description = "ID de la bodega a eliminar", required = true) @PathVariable int id){
        bodegaRepository.deleteById(id);
    }
}
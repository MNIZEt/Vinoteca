package AD.Vinoteca.controllers;

import AD.Vinoteca.models.Bodega;
import AD.Vinoteca.models.DTO.BodegaDTO;
import AD.Vinoteca.repositories.BodegaRepository;
import AD.Vinoteca.repositories.RegionRepository;
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
    public List<Bodega> obternerTodas(){
        return bodegaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Bodega obtenerPorId(@PathVariable int id){
        return bodegaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Bodega guardar(@RequestBody BodegaDTO bodegaDTO){
        Bodega bodega = new Bodega();
        bodega.setId(bodegaDTO.getId());
        bodega.setNombre(bodegaDTO.getNombre());
        bodega.setUbicacion(bodegaDTO.getUbicacion());
        bodega.setAnho_establecimiento(bodegaDTO.getAnho_establecimiento());
        bodega.setRegion(regionRepository.findById(bodegaDTO.getRegionId()).orElse(null));
        return bodegaRepository.save(bodega);
    }

    @PutMapping("/{id}")
    public Bodega actualizar(@PathVariable int id, @RequestBody BodegaDTO bodegaDTO){
        Bodega bodega = new Bodega();
        bodega.setId(id);
        bodega.setNombre(bodegaDTO.getNombre());
        bodega.setUbicacion(bodegaDTO.getUbicacion());
        bodega.setAnho_establecimiento(bodegaDTO.getAnho_establecimiento());
        bodega.setRegion(regionRepository.findById(bodegaDTO.getRegionId()).orElse(null));
        return bodegaRepository.save(bodega);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable int id){
        bodegaRepository.deleteById(id);
    }

}

package AD.Vinoteca.controllers;

import AD.Vinoteca.models.Region;
import AD.Vinoteca.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/regiones")
public class RegionController {
    @Autowired
    private RegionRepository regionRepository;

    @GetMapping
    public List<Region> obtenerTodas(){
        return regionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Region obtenerPorId(@PathVariable int id){
        return regionRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Region guardar(@RequestBody Region region){
        return regionRepository.save(region);
    }

    @PutMapping("/{id}")
    public Region actualizar(@PathVariable int id, @RequestBody Region region){
        region.setId(id);
        return regionRepository.save(region);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable int id){
        regionRepository.deleteById(id);
    }
}

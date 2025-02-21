package AD.Vinoteca.controllers;

import AD.Vinoteca.models.DTO.VinoDTO;
import AD.Vinoteca.models.Vino;
import AD.Vinoteca.repositories.BodegaRepository;
import AD.Vinoteca.repositories.VinoRepository;
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
     public List<Vino> obtenerTodas(){
        return vinoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Vino obtenerPorId(@PathVariable int id){
        return vinoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Vino guardar(@RequestBody VinoDTO vinoDTO ){
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
    public Vino actualizar(@PathVariable int id, @RequestBody VinoDTO vinoDTO){
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
    public void borrar(@PathVariable int id){
        vinoRepository.deleteById(id);
    }
}

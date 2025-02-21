package AD.Vinoteca.controllers;

import AD.Vinoteca.models.DTO.ResenhaDTO;
import AD.Vinoteca.models.Resenha;
import AD.Vinoteca.repositories.ResenhaRepository;
import AD.Vinoteca.repositories.UsuarioRepository;
import AD.Vinoteca.repositories.VinoRepository;
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
    public List<Resenha> obtenerTodas(){
        return resenhaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Resenha obtenerPorId(@PathVariable int id){
        return resenhaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Resenha guardar(@RequestBody ResenhaDTO resenhaDTO){
        Resenha resenha = new Resenha();
        resenha.setId(resenhaDTO.getId());
        resenha.setTitulo(resenhaDTO.getTitulo());
        resenha.setTexto(resenhaDTO.getTexto());
        resenha.setCalificacion(resenhaDTO.getCalificacion());
        resenha.setFecha(resenhaDTO.getFecha());
        resenha.setUsuario(usuarioRepository.findById(resenhaDTO.getUsuarioId()).orElse(null));
        resenha.setVino(vinoRepository.findById(resenhaDTO.getUsuarioId()).orElse(null));
        return  resenhaRepository.save(resenha);
    }

    @PutMapping("/{id}")
    public Resenha actualizar(@PathVariable int id, @RequestBody ResenhaDTO resenhaDTO){
        Resenha resenha = new Resenha();
        resenha.setId(id);
        resenha.setTitulo(resenhaDTO.getTitulo());
        resenha.setTexto(resenhaDTO.getTexto());
        resenha.setCalificacion(resenhaDTO.getCalificacion());
        resenha.setFecha(resenhaDTO.getFecha());
        resenha.setUsuario(usuarioRepository.findById(resenhaDTO.getUsuarioId()).orElse(null));
        resenha.setVino(vinoRepository.findById(resenhaDTO.getUsuarioId()).orElse(null));
        return resenhaRepository.save(resenha);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable int id){
        resenhaRepository.deleteById(id);
    }
}

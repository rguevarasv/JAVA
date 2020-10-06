package sv.org.rguevara.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sv.org.rguevara.model.Persona;
import sv.org.rguevara.repo.IPersonaRepo;

@RestController
@RequestMapping("/personas")
public class DemoRestController {
	
	@Autowired	
	private IPersonaRepo repo;

	@GetMapping("/listar")
    public List<Persona> home() {
        return repo.findAll();
    }
	
	@PostMapping("/insertar")
	public void insertar(@RequestBody Persona persona) {
		repo.save(persona);
	}
	
	@PutMapping("/modificar")
	public void modificar(@RequestBody Persona persona) {
		repo.save(persona);
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
}

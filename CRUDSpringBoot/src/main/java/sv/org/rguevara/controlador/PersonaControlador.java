package sv.org.rguevara.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sv.org.rguevara.model.Persona;
import sv.org.rguevara.servicios.IPersonaService;

@Controller
@RequestMapping
public class PersonaControlador {

	@Autowired
	private IPersonaService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Persona> personas = service.listar();
		model.addAttribute("personas", personas);
		return "index";
	}
	
}

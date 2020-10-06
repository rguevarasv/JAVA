package sv.org.rguevara.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.org.rguevara.impl.IPersonaImpl;
import sv.org.rguevara.interfaces.IPersona;
import sv.org.rguevara.model.Persona;

@Service
public class IPersonaService implements IPersonaImpl{

	@Autowired
	private IPersona data;
	
	@Override
	public List<Persona> listar() {
		return (List<Persona>) data.findAll();
	}

}

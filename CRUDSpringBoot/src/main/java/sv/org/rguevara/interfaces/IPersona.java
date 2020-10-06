package sv.org.rguevara.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sv.org.rguevara.model.Persona;

@Repository
public interface IPersona extends CrudRepository<Persona, Integer>{
	

}

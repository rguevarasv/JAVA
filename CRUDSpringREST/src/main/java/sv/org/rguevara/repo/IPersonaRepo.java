package sv.org.rguevara.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.org.rguevara.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer> {
	
}

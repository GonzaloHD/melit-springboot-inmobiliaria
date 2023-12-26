package es.melit.melitspringbootinmobiliaria.iDao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.melit.melitspringbootinmobiliaria.entities.Empleado;

public interface EmpleadoDao extends JpaRepository<Empleado,Integer>{
	
//	@Query ("SELECT e FROM Empleado e WHERE e.nif = :nif")
//	Optional<Empleado> findByNif(String nif);
	
//	List <Empleado> findByNif(String nif);
	
	Optional<Empleado> findFirstByNif(String nif);

	@Query("SELECT e FROM Empleado e WHERE e.activo = TRUE")
	List<Empleado> findAllActivos();

}

package es.melit.melitspringbootinmobiliaria.iDao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.melit.melitspringbootinmobiliaria.entities.Empleado;

public interface EmpleadoDao extends JpaRepository<Empleado,Integer>{
	
//	Empleado findByNif(String dni);

}

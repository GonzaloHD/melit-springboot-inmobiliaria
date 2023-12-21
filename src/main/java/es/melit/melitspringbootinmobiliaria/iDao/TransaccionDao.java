package es.melit.melitspringbootinmobiliaria.iDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.melit.melitspringbootinmobiliaria.entities.Transaccion;

public interface TransaccionDao extends JpaRepository<Transaccion, Integer>{
	
	@Query("SELECT t FROM Transaccion t JOIN t.empleado e where e.idEmpleado = ?1")
	List<Transaccion> findByEmpleado(Integer IdEmpleado);	
	
	@Query("SELECT t FROM Transaccion t WHERE MONTH(t.fecha) = ?1 AND YEAR(t.fecha) = ?2")
	List<Transaccion> findByMonth(Integer mes, Integer year);	
	
}

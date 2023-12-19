package es.melit.melitspringbootinmobiliaria.iDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.melit.melitspringbootinmobiliaria.entities.Demanda;

public interface DemandaDao extends JpaRepository<Demanda,Integer>{
	
//	@Query("select d from Demanda d where (?1 is null or d.numHabitaciones = ?1) "
//	+ "and (?2 is null or d.localidad =?2) "
//	+ "and (?3 is null or d.tipoVivienda = ?3)")
	
//	@Query("select d from Demanda d where (?1 is null or d.numHabitaciones = ?1) "
//			+ "and (?2 is null or lower(d.localidad) like %?2%) "
//			+ "and (?3 is null or lower(d.tipoVivienda) like %?3%)")
	
	@Query("select d from Demanda d where (?1 is null or d.numHabitaciones = ?1) "
			+ "and (?2 is null or ?2 like concat('%', lower(d.localidad), '%')) "
			+ "and (?3 is null or ?3 like concat('%', lower(d.tipoVivienda), '%'))")
	List<Demanda> findByCaracteristicas(Integer numHabitaciones, String localidad, String tipoVivienda);

	
}

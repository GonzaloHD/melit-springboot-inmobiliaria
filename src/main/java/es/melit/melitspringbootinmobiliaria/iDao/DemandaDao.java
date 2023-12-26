package es.melit.melitspringbootinmobiliaria.iDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
	@Query("SELECT d FROM Demanda d WHERE d.activa = TRUE")
	List<Demanda> findAllActivas();

	@Query("SELECT d FROM Demanda d, Inmueble i " +
		       "WHERE UPPER(i.localidad) = UPPER(d.localidad) " +
		       "AND UPPER(i.tipoVivienda) = UPPER(d.tipoVivienda) " +
		       "AND i.numHabitaciones = d.numHabitaciones " +
		       "AND (:localidad IS NULL OR UPPER(i.localidad) = UPPER(:localidad)) " +
		       "AND (:tipoVivienda IS NULL OR UPPER(i.tipoVivienda) = UPPER(:tipoVivienda)) " +
		       "AND (:numHabitaciones IS NULL OR i.numHabitaciones = :numHabitaciones)")
	List<Demanda> findDemandasporIdInmueble(@Param("localidad") String localidad,
		                                @Param("tipoVivienda") String tipoVivienda,
		                                @Param("numHabitaciones") Integer numHabitaciones);
	
		
	@Query("SELECT d FROM Demanda d " +
		       "JOIN Transaccion t ON d.idDemanda = t.demanda.idDemanda " +
		       "JOIN Inmueble i ON t.inmueble.idInmueble = i.idInmueble " +
		       "WHERE i.idInmueble = :idInmueble " +
		       "AND d.numHabitaciones = i.numHabitaciones " +
		       "AND UPPER(d.tipoVivienda) = UPPER(i.tipoVivienda) " +
		       "AND UPPER(d.localidad) = UPPER(i.localidad) " +
		       "AND UPPER(d.cliente.nif) = UPPER(:dniCliente)")
	Demanda findDemandaByInmuebleIdAndClienteDni(@Param("idInmueble") Integer idInmueble, @Param("dniCliente") String dniCliente);

	
}

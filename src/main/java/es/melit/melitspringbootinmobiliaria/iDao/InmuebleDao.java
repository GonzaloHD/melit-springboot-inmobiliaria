package es.melit.melitspringbootinmobiliaria.iDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.melit.melitspringbootinmobiliaria.entities.Inmueble;

public interface InmuebleDao extends JpaRepository <Inmueble, Integer>{

	@Query("SELECT i FROM Inmueble i WHERE UPPER(i.localidad) = UPPER(:localidad)")
    List<Inmueble> findByLocalidad(String localidad);
	
//	@Query("SELECT i FROM Inmueble i WHERE UPPER(i.localidad) = UPPER(:localidad) AND UPPER(i.tipoVivienda) = UPPER(:tipoVivienda) AND i.numHabitaciones = :numHabitaciones")
//	List<Inmueble> findByParametros(String localidad, String tipoVivienda,Integer numHabitaciones);
	
	@Query("SELECT i FROM Inmueble i WHERE " +
		       "(:localidad IS NULL OR UPPER(i.localidad) = UPPER(:localidad)) AND " +
		       "(:tipoVivienda IS NULL OR UPPER(i.tipoVivienda)= UPPER(:tipoVivienda)) AND " +
		       "(:numHabitaciones IS NULL OR i.numHabitaciones  = :numHabitaciones)")
	List<Inmueble> findByParametros(@Param("localidad") String localidad,
		                                @Param("tipoVivienda") String tipoVivienda,
		                                @Param("numHabitaciones") Integer numHabitaciones);	

	@Query("SELECT i FROM Inmueble i " +
		   "JOIN Demanda d ON i.localidad = d.localidad AND i.tipoVivienda = d.tipoVivienda AND i.numHabitaciones = d.numHabitaciones " +
		       "WHERE (:localidad IS NULL OR UPPER(i.localidad) = UPPER(:localidad)) " +
		       "AND (:tipoVivienda IS NULL OR UPPER(i.tipoVivienda) = UPPER(:tipoVivienda)) " +
		       "AND (:numHabitaciones IS NULL OR i.numHabitaciones = :numHabitaciones)")
	List<Inmueble> findDemandaInmueble(@Param("localidad") String localidad,
		                                @Param("tipoVivienda") String tipoVivienda,
		                                @Param("numHabitaciones") Integer numHabitaciones);
	
	
//	select * from inmueble as inm where (inm.num_habitaciones, inm.localidad, inm.tipo_vivienda) in (select num_habitaciones, localidad, tipo_vivienda from demanda where fk_cliente = 1);
	
//	SELECT * FROM Inmueble i WHERE EXISTS (SELECT 1 FROM demanda d WHERE d.fk_cliente = 1 AND i.num_habitaciones = d.num_habitaciones AND i.localidad = d.localidad AND i.tipo_vivienda = d.tipo_vivienda);
	
//	@Query("SELECT i FROM Inmueble i WHERE EXISTS (SELECT 1 FROM Demanda d JOIN d.cliente c WHERE c.idCliente = ?1 "
//	+ "AND i.numHabitaciones = d.numHabitaciones AND i.localidad = d.localidad "
//	+ "AND i.tipoVivienda = d.tipoVivienda)")
	
	@Query("SELECT i FROM Inmueble i WHERE (i.numHabitaciones, i.localidad, i.tipoVivienda) "
			+ "IN (SELECT d.numHabitaciones, d.localidad, d.tipoVivienda FROM Demanda d JOIN d.cliente c WHERE c.idCliente = ?1)")
	List<Inmueble> findDemandadosCliente(Integer idCliente);
	
	@Query("SELECT i FROM Inmueble i, Demanda d " +
		       "WHERE i.localidad = d.localidad AND i.tipoVivienda = d.tipoVivienda AND i.numHabitaciones = d.numHabitaciones")
	List<Inmueble> findInmueblesWithMatchingDemandas();

		
	
	
	

}


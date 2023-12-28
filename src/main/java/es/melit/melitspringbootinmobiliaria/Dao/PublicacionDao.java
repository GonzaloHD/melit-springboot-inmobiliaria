package es.melit.melitspringbootinmobiliaria.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.melit.melitspringbootinmobiliaria.entities.Publicacion;

public interface PublicacionDao extends JpaRepository<Publicacion,Integer>{
	
	@Query("SELECT p FROM Publicacion p WHERE p.fechaFin is null")
	List<Publicacion> findAllActivas();

}

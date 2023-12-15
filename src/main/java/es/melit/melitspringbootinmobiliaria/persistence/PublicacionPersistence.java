package es.melit.melitspringbootinmobiliaria.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import es.melit.melitspringbootinmobiliaria.entities.Publicacion;

public interface PublicacionPersistence extends JpaRepository<Publicacion,Integer>{

}

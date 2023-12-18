package es.melit.melitspringbootinmobiliaria.iDao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.melit.melitspringbootinmobiliaria.entities.Publicacion;

public interface PublicacionDao extends JpaRepository<Publicacion,Integer>{

}

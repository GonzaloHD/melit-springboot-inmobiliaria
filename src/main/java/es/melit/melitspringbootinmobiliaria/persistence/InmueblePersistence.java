package es.melit.melitspringbootinmobiliaria.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import es.melit.melitspringbootinmobiliaria.entities.Inmueble;

public interface InmueblePersistence extends JpaRepository <Inmueble, Integer>{

}

package es.melit.melitspringbootinmobiliaria.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import es.melit.melitspringbootinmobiliaria.entities.Transaccion;

public interface TransaccionPersistence extends JpaRepository<Transaccion, Integer>{

}

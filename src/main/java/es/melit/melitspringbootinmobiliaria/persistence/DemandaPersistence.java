package es.melit.melitspringbootinmobiliaria.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import es.melit.melitspringbootinmobiliaria.entities.Demanda;

public interface DemandaPersistence extends JpaRepository<Demanda,Integer>{

}

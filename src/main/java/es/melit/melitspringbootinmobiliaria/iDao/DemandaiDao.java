package es.melit.melitspringbootinmobiliaria.iDao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.melit.melitspringbootinmobiliaria.entities.Demanda;

public interface DemandaiDao extends JpaRepository<Demanda,Integer>{

}
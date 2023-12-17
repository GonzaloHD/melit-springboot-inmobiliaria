package es.melit.melitspringbootinmobiliaria.iDao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.melit.melitspringbootinmobiliaria.entities.Cliente;

public interface ClienteiDao extends JpaRepository <Cliente, Integer>{

}

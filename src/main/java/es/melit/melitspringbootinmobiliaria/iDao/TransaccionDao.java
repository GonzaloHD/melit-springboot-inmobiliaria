package es.melit.melitspringbootinmobiliaria.iDao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.melit.melitspringbootinmobiliaria.entities.Transaccion;

public interface TransaccionDao extends JpaRepository<Transaccion, Integer>{

}

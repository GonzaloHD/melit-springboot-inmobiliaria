package es.melit.melitspringbootinmobiliaria.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import es.melit.melitspringbootinmobiliaria.entities.Empleado;

public interface EmpleadoPersistence extends JpaRepository<Empleado,Integer>{

}

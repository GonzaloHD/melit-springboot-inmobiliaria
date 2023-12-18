package es.melit.melitspringbootinmobiliaria.iDao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.melit.melitspringbootinmobiliaria.entities.Cliente;

public interface ClienteDao extends JpaRepository <Cliente, Integer>{
	
	@Query ("SELECT c FROM Cliente c WHERE c.nif = :nif")
	Optional<Cliente> findByNif(String nif);

}

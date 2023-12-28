package es.melit.melitspringbootinmobiliaria.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import es.melit.melitspringbootinmobiliaria.entities.Cliente;


public interface ClienteDao extends JpaRepository <Cliente, Integer>{
	
//	@Query ("SELECT c FROM Cliente c WHERE c.nif = :nif")
//	Optional<Cliente> findByNif(String nif);
	
	Optional<Cliente> findFirstByNif(String nif);

}

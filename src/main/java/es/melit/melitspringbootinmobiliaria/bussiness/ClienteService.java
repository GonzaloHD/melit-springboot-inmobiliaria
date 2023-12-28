package es.melit.melitspringbootinmobiliaria.bussiness;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.melit.melitspringbootinmobiliaria.Dao.ClienteDao;
import es.melit.melitspringbootinmobiliaria.entities.Cliente;
import jakarta.transaction.Transactional;

@Service

public class ClienteService implements PlantillaServicio<Cliente> {

	public ClienteDao iDao;
	
	@Autowired
	public ClienteService(ClienteDao iDao) {
		this.iDao = iDao;		
	}
	@Override
	public List<Cliente> listado(){		
		
		try {
			return iDao.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());			
			throw new RuntimeException("Error inesperado en el servidor");
		}		
	}
		
	@Override
	public Cliente buscar(Integer id) {

		Cliente cliente = iDao.findById(id).orElseThrow(()->
		new IllegalStateException("Cliente con id " + id + " no existe"));
		
		return cliente;
	}
	
	public Cliente findByNif(String nif) {		
		Cliente cliente = iDao.findFirstByNif(nif).orElseThrow(()->
		new IllegalStateException("Cliente con NIF " + nif + " no encontrado, compruebe o pruebe más tarde"));
			
		return cliente;
	}
	
	@Override
	public void guardar(Cliente cliente) {
		iDao.save(cliente);
	}
		
	@Transactional
	@Override
	public void actualizar(Cliente actualizado) {
		Cliente clienteActual = iDao.findById(actualizado.getIdCliente()).orElseThrow(()->
		new IllegalStateException("Cliente con id " + actualizado.getIdCliente() + " no existe"));
		
		if(actualizado.getApellidos() != null && actualizado.getApellidos().length()>0 && !Objects.equals(actualizado.getApellidos(), clienteActual.getApellidos())) {
			clienteActual.setApellidos(actualizado.getApellidos());
		}	
		if(actualizado.getDireccion() != null && actualizado.getDireccion().length()>0 && !Objects.equals(actualizado.getDireccion(), clienteActual.getDireccion())) {
			clienteActual.setDireccion(actualizado.getDireccion());
		}
		if(actualizado.getEmail() != null && actualizado.getEmail().length()>0 && !Objects.equals(actualizado.getEmail(), clienteActual.getEmail())) {
			clienteActual.setEmail(actualizado.getEmail());
		}	
		if(actualizado.getNif() != null && actualizado.getNif().length()>0 && !Objects.equals(actualizado.getNif(), clienteActual.getNif())) {
			clienteActual.setNif(actualizado.getNif());
		}	
		if(actualizado.getNombre() != null && actualizado.getNombre().length()>0 && !Objects.equals(actualizado.getNombre(), clienteActual.getNombre())) {
			clienteActual.setNombre(actualizado.getNombre());
		}
		if(actualizado.getTelefono() != null && actualizado.getTelefono().length()>0 && !Objects.equals(actualizado.getTelefono(), clienteActual.getTelefono())) {
			clienteActual.setTelefono(actualizado.getTelefono());
		}
						
	}

	
	@Override
	public void eliminar(Integer id) {
		if(!iDao.existsById(id)) {
			throw new IllegalStateException("Cliente con id: " + id + " no existe");
		}
		iDao.deleteById(id);		
	}		
}

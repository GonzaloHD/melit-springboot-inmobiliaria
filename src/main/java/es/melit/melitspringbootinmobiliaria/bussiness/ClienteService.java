package es.melit.melitspringbootinmobiliaria.bussiness;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.melit.melitspringbootinmobiliaria.entities.Cliente;
import es.melit.melitspringbootinmobiliaria.iDao.ClienteiDao;

@Service
public class ClienteService implements PlantillaServicio<Cliente> {

	public ClienteiDao iDao;
	
	@Autowired
	public ClienteService(ClienteiDao iDao) {
		this.iDao = iDao;
		
	}
	
	public List<Cliente> listado(){		
		
		try {
			return iDao.findAll();
		} catch (Exception e) {
			return null;
		}		
	}
	
	public void guardar(Cliente cliente) {
		iDao.save(cliente);
	}
	
	public Cliente buscar(Integer idCliente) {
		Cliente cliente;
		
		try {
			Optional<Cliente> clienteOp = iDao.findById(idCliente);
			if(clienteOp.isPresent()) cliente= clienteOp.get();
			cliente= clienteOp.get();
			
		}catch(Exception e){
			return null;
		}
		return cliente;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Cliente actualizado) {
		// TODO Auto-generated method stub
		
	}
		
}

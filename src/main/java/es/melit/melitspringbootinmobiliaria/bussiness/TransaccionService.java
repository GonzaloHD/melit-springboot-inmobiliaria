package es.melit.melitspringbootinmobiliaria.bussiness;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.melit.melitspringbootinmobiliaria.entities.Transaccion;
import es.melit.melitspringbootinmobiliaria.iDao.TransaccionDao;

@Service
public class TransaccionService implements PlantillaServicio<Transaccion> {
	
	public TransaccionDao tDao;
	
	public TransaccionService(TransaccionDao tDao) {
		this.tDao = tDao;
	}

	@Override
	public List<Transaccion> listado() {
		try {
			return tDao.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());			
			throw new RuntimeException("Error inesperado en el servidor");
		}		
	}

	@Override
	public Transaccion buscar(Integer id) {
		Optional<Transaccion> optionalInmueble;
		try {			
			optionalInmueble = tDao.findById(id);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error inesperado en el servidor");
		}
		if(optionalInmueble.isEmpty()) {
			throw new IllegalStateException("Transacción buscada no existe");		}
		return optionalInmueble.get();			
	}	

	@Override
	public void guardar(Transaccion inmueble) {
		try {
			tDao.save(inmueble);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error inesperado en el servidor");
		}
				
	}
	@Override
	public void eliminar(Integer id) {
		if(!tDao.existsById(id)) {
			throw new IllegalStateException("Transacción con id: " + id + " no existe");
		}
		tDao.deleteById(id);		
	}

	@Override
	public void actualizar(Transaccion actualizado) {
		Transaccion actual = tDao.findById(actualizado.getIdTransaccion()).orElseThrow(()->
		new IllegalStateException("Inmueble con id " + actualizado.getIdTransaccion() + " no existe"));
		
		if(actualizado.getComentario() != null && actualizado.getComentario().length()>0 && !Objects.equals(actualizado.getComentario(), actual.getComentario())) {
			actual.setComentario(actualizado.getComentario());
		}	
	
	}

}

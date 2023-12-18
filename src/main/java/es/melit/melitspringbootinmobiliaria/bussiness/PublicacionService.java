package es.melit.melitspringbootinmobiliaria.bussiness;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.melit.melitspringbootinmobiliaria.entities.Publicacion;
import es.melit.melitspringbootinmobiliaria.iDao.PublicacionDao;

@Service
public class PublicacionService implements PlantillaServicio<Publicacion> {
	
	public PublicacionDao pDao;	

	public PublicacionService() {
		super();
	}

	public PublicacionService(PublicacionDao pDao) {		
		this.pDao = pDao;
	}

	@Override
	public List<Publicacion> listado() {
		try {
			return pDao.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());			
			throw new RuntimeException("Error inesperado en el servidor");
		}
	}

	@Override
	public Publicacion buscar(Integer id) {
		Optional<Publicacion> optionalPublicacion;
		try {			
			optionalPublicacion = pDao.findById(id);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error inesperado en el servidor");
		}
		if(optionalPublicacion.isEmpty()) {
			throw new IllegalStateException("Publicación buscada no existe");		}
		return optionalPublicacion.get();	
	}

	@Override
	public void guardar(Publicacion publicacion) {
		try {
			pDao.save(publicacion);
		}catch (Exception e) {
			throw new RuntimeException("Error inesperado en el servidor");
		}
		
	}

	@Override
	public void eliminar(Integer id) {
		if(!pDao.existsById(id)) {
			throw new IllegalStateException("Transacción con id: " + id + " no existe");
		}
		try {
			
		}catch (Exception e) {
			throw new RuntimeException("Error inesperado en el servidor");
		}
		pDao.deleteById(id);
	}

	@Override
	public void actualizar(Publicacion actualizado) {
		Publicacion actual = pDao.findById(actualizado.getIdPublicacion()).orElseThrow(()->
		new IllegalStateException("Publicacion con id " + actualizado.getIdPublicacion() + " no existe"));
		
		if(actualizado.getCoste() != null && actualizado.getCoste()>0 && actualizado.getCoste() != actual.getCoste()) {
			actual.setCoste(actualizado.getCoste());
		}				
		
	}

}

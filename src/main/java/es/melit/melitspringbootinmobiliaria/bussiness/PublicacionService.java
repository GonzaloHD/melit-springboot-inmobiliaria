package es.melit.melitspringbootinmobiliaria.bussiness;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.melit.melitspringbootinmobiliaria.entities.Publicacion;
import es.melit.melitspringbootinmobiliaria.iDao.PublicacionDao;
import jakarta.transaction.Transactional;

@Service
public class PublicacionService implements PlantillaServicio<Publicacion> {
	
	public PublicacionDao pDao;	

	@Autowired
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
	
	public List<Publicacion> listadoActivas() {
		try {
			return pDao.findAllActivas();
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
			throw new IllegalStateException("Publicación con id: " + id + " no existe");
		}
		try {			
			pDao.deleteById(id);			
		}catch (Exception e) {
			throw new RuntimeException("Error inesperado en el servidor");
		}		
	}
	@Override
	public void actualizar(Publicacion actualizado) {
		Publicacion actual = pDao.findById(actualizado.getIdPublicacion()).orElseThrow(()->
		new IllegalStateException("Publicacion con id " + actualizado.getIdPublicacion() + " no existe"));
		
		if(actualizado.getCosteDiario() != null && actualizado.getCosteDiario()>0 && actualizado.getCosteDiario() != actual.getCosteDiario()) {
			actual.setCosteDiario(actualizado.getCosteDiario());
		}				
		
	}
	@Transactional
	public Publicacion cerrar(Integer idPublicacion) {
		Publicacion actual = pDao.findById(idPublicacion).orElseThrow(()->
		new IllegalStateException("Publicacion con id " + idPublicacion + " no existe"));
		if(actual.getFechaFin() != null) {
			throw new IllegalStateException("Publicacion con id " + idPublicacion + " ya esta cerrada con fecha: " + actual.getFechaFin());
		}
		actual.setFechaFin(Instant.now());
		return actual;		
	}

}

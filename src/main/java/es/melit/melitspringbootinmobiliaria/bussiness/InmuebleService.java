package es.melit.melitspringbootinmobiliaria.bussiness;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.melit.melitspringbootinmobiliaria.entities.Inmueble;
import es.melit.melitspringbootinmobiliaria.iDao.InmuebleiDao;

@Service
public class InmuebleService implements PlantillaServicio<Inmueble> {
	
//	Preguntar si inyectar en atributo o constructor y constructor vacío?
	public InmuebleiDao iDao;	
	
	@Autowired
	public InmuebleService(InmuebleiDao iDao) {
		this.iDao = iDao;
	}
	
	public List<Inmueble> listado(){		
			
		try {
			return iDao.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());			
			throw new RuntimeException("Error inesperado en el servidor");
		}		
	}
	
	public Inmueble bucar(Integer id) {		
		Optional<Inmueble> optionalInmueble;
		try {			
			optionalInmueble = iDao.findById(id);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error inesperado en el servidor");
		}
		if(optionalInmueble.isEmpty()) {
			throw new IllegalStateException("Inmueble buscado no existe");		}
		return optionalInmueble.get();			
	}
	
	public void guardar(Inmueble inmueble) {
		iDao.save(inmueble);
	}
	
	public void eliminar(Integer id) {
		if(!iDao.existsById(id)) {
			throw new IllegalStateException("Inmueble con id: " + id + " no existe");
		}
		iDao.deleteById(id);	
	}

	
public void actualizar(Inmueble inmuebleActualizado) {
		
		Inmueble inmuebleActual = iDao.findById(inmuebleActualizado.getIdInmuble()).orElseThrow(()->
		new IllegalStateException("Inmueble con id " + inmuebleActualizado.getIdInmuble() + " no existe"));
		
		if(inmuebleActualizado.getDescripcion() != null && inmuebleActualizado.getDescripcion().length()>0 && !Objects.equals(inmuebleActualizado.getDescripcion(), inmuebleActual.getDescripcion())) {
			inmuebleActual.setDescripcion(inmuebleActualizado.getDescripcion());
		}	
		if(inmuebleActualizado.getDireccion() != null && inmuebleActualizado.getDireccion().length()>0 && !Objects.equals(inmuebleActualizado.getDireccion(), inmuebleActual.getDireccion())) {
			inmuebleActual.setDireccion(inmuebleActualizado.getDireccion());
		}	
		if(inmuebleActualizado.getLocalidad() != null && inmuebleActualizado.getLocalidad().length()>0 && !Objects.equals(inmuebleActualizado.getLocalidad(), inmuebleActual.getLocalidad())) {
			inmuebleActual.setLocalidad(inmuebleActualizado.getLocalidad());
		}	
		if(inmuebleActualizado.getTipoVivienda() != null && inmuebleActualizado.getTipoVivienda().length()>0 && !Objects.equals(inmuebleActualizado.getTipoVivienda(), inmuebleActual.getTipoVivienda())) {
			inmuebleActual.setTipoVivienda(inmuebleActualizado.getTipoVivienda());
		}
		if(inmuebleActualizado.getNumHabitaciones() > 0 && inmuebleActualizado.getNumHabitaciones()!= inmuebleActual.getNumHabitaciones()) {
			inmuebleActual.setNumHabitaciones(inmuebleActualizado.getNumHabitaciones());
		}	
		if(inmuebleActualizado.isActivo() != inmuebleActual.isActivo()) {
			inmuebleActual.setNumHabitaciones(inmuebleActualizado.getNumHabitaciones());
		}		
		
	
	}
	
}

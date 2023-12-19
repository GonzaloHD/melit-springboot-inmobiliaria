package es.melit.melitspringbootinmobiliaria.bussiness;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.melit.melitspringbootinmobiliaria.entities.Inmueble;
import es.melit.melitspringbootinmobiliaria.iDao.InmuebleDao;
import jakarta.transaction.Transactional;


@Service
public class InmuebleService implements PlantillaServicio<Inmueble> {
	
//	Preguntar si inyectar en atributo o constructor y constructor vacío?
	public InmuebleDao iDao;	
	
	@Autowired
	public InmuebleService(InmuebleDao iDao) {
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
	
	public Inmueble buscar(Integer id) {		
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
	
	public List<Inmueble> findByLocalidad (String localidad){
		
		 try {
		        return iDao.findByLocalidad(localidad);
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		        throw new RuntimeException("Error inesperado en el servidor");
		    }
	}
	
	public List<Inmueble> findByParametros (String localidad, String tipoVivienda, Integer numHabitaciones){
		
		 try {
		        return iDao.findByParametros(localidad, tipoVivienda, numHabitaciones);
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		        throw new RuntimeException("Error inesperado en el servidor");
		    }
	}
	
	public List<Inmueble> findDemandaInmueble (String localidad, String tipoVivienda, Integer numHabitaciones){
		
		 try {
		        return iDao.findByParametros(localidad, tipoVivienda, numHabitaciones);
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		        throw new RuntimeException("Error inesperado en el servidor");
		    }
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

	@Transactional
	public void actualizar(Inmueble inmuebleActualizado) {
		Inmueble inmuebleActual = iDao.findById(inmuebleActualizado.getIdInmueble()).orElseThrow(()->
		new IllegalStateException("Inmueble con id " + inmuebleActualizado.getIdInmueble() + " no existe"));
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
		if(inmuebleActualizado.getCliente() != null && !Objects.equals(inmuebleActualizado.getCliente(), inmuebleActual.getCliente())) {
			inmuebleActual.setCliente(inmuebleActualizado.getCliente());
		}
		if(inmuebleActualizado.getEmpleado() != null && !Objects.equals(inmuebleActualizado.getEmpleado(), inmuebleActual.getEmpleado())) {
			inmuebleActual.setEmpleado(inmuebleActualizado.getEmpleado());
		}
		
	}

	
}

package es.melit.melitspringbootinmobiliaria.bussiness;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.melit.melitspringbootinmobiliaria.dto.InmuebleUpdateDto;
import es.melit.melitspringbootinmobiliaria.entities.Inmueble;
import es.melit.melitspringbootinmobiliaria.entities.InmuebleEstadoDto;
import es.melit.melitspringbootinmobiliaria.iDao.ClienteDao;
import es.melit.melitspringbootinmobiliaria.iDao.EmpleadoDao;
import es.melit.melitspringbootinmobiliaria.iDao.InmuebleDao;
import jakarta.transaction.Transactional;


@Service
public class InmuebleService implements PlantillaServicio<Inmueble> {
	
	public InmuebleDao iDao;	
	public ClienteDao cDao;
	public EmpleadoDao eDao;
	
	@Autowired
	public InmuebleService(InmuebleDao iDao, ClienteDao cDao, EmpleadoDao eDao) {
		this.iDao = iDao;
		this.cDao = cDao;
		this.eDao = eDao;
	}
	
	public List<Inmueble> listado(){		
			
		try {
			return iDao.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());			
			throw new RuntimeException("Error inesperado en el servidor");
		}		
	}
	
	public List<Inmueble> listadoActivos() {		
		try {
			return iDao.findAllActivos();
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

	
	public List<Inmueble> findByParametros (String localidad, String tipoVivienda, Integer numHabitaciones){
		
		 try {
		        return iDao.findByParametros(numHabitaciones, localidad, tipoVivienda);
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		        throw new RuntimeException("Error inesperado en el servidor");
		    }
	}
	
	public List<Inmueble> findDemandaInmueble (String localidad, String tipoVivienda, Integer numHabitaciones){
		
		 try {
		        return iDao.findByParametros(numHabitaciones, localidad, tipoVivienda);
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		        throw new RuntimeException("Error inesperado en el servidor");
		    }
	}
	
	public List<Inmueble> findDemandadosInmueble (Integer idCliente){
		
		 try {
		        return iDao.findDemandadosCliente(idCliente);
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		        throw new RuntimeException("Error inesperado en el servidor");
		    }
	}
	
	public List<Inmueble> cruzarDemandasInmubles(){
		try {
	        return iDao.findInmueblesWithMatchingDemandas();
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        throw new RuntimeException("Error inesperado en el servidor");
	    }
	}
	
	public void guardar(Inmueble inmueble) {
		iDao.save(inmueble);
	}
	@Transactional
	public void eliminar(Integer id) {
		if(!iDao.existsById(id)) {
			throw new IllegalStateException("Inmueble con id: " + id + " no existe");
		}
		Inmueble in = iDao.findById(id).get(); 
		if(in.getPublicaciones().isEmpty() && in.getTransaccion() == null) {
			iDao.deleteById(id);
		} else {
			in.setActivo(false);
		}
			
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
		if(inmuebleActualizado.getNumHabitaciones() != null && inmuebleActualizado.getNumHabitaciones()!= inmuebleActual.getNumHabitaciones()) {
			inmuebleActual.setNumHabitaciones(inmuebleActualizado.getNumHabitaciones());
		}	
		if(inmuebleActualizado.getPrecio() != null && inmuebleActualizado.getPrecio()!= inmuebleActual.getPrecio()) {
			inmuebleActual.setPrecio(inmuebleActualizado.getPrecio());
		}
		if(inmuebleActualizado.getMetrosCuadrados() != null && inmuebleActualizado.getMetrosCuadrados()!= inmuebleActual.getMetrosCuadrados()) {
			inmuebleActual.setMetrosCuadrados(inmuebleActualizado.getMetrosCuadrados());
		}
		if(inmuebleActualizado.getCliente() != null && !Objects.equals(inmuebleActualizado.getCliente(), inmuebleActual.getCliente())) {
			inmuebleActual.setCliente(inmuebleActualizado.getCliente());
		}
		if(inmuebleActualizado.getEmpleado() != null && !Objects.equals(inmuebleActualizado.getEmpleado(), inmuebleActual.getEmpleado())) {
			inmuebleActual.setEmpleado(inmuebleActualizado.getEmpleado());
		}
		if (inmuebleActualizado.isActivo() != inmuebleActual.isActivo()) {
	        throw new RuntimeException("Para cambiar el estado del inmueble debes usar una solicitud específica (solicitud put con url: http://localhost:8084/api/inmobiliaria/inmuebles/cambiarestado)");
	    }
		
	}
	
	@Transactional
	public void actualizarConId(InmuebleUpdateDto inmuebleActualizado, Integer idInmueble) {
		Inmueble inmuebleActual = iDao.findById(idInmueble).orElseThrow(()->
		new IllegalStateException("Inmueble con id " + idInmueble + " no existe"));
		
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
		if(inmuebleActualizado.getNumHabitaciones() != null && inmuebleActualizado.getNumHabitaciones()!= inmuebleActual.getNumHabitaciones()) {
			inmuebleActual.setNumHabitaciones(inmuebleActualizado.getNumHabitaciones());
		}	
		if(inmuebleActualizado.getPrecio() != null && inmuebleActualizado.getPrecio()!= inmuebleActual.getPrecio()) {
			inmuebleActual.setPrecio(inmuebleActualizado.getPrecio());
		}
		if(inmuebleActualizado.getMetrosCuadrados() != null && inmuebleActualizado.getMetrosCuadrados()!= inmuebleActual.getMetrosCuadrados()) {
			inmuebleActual.setMetrosCuadrados(inmuebleActualizado.getMetrosCuadrados());
		}
		if(inmuebleActualizado.getIdCliente() != null && inmuebleActualizado.getIdCliente() != inmuebleActual.getCliente().getIdCliente()) {
			
			inmuebleActual.setCliente(cDao.findById(inmuebleActualizado.getIdCliente()).get());
		}
		if(inmuebleActualizado.getIdEmpleado() != null && inmuebleActualizado.getIdEmpleado() != inmuebleActual.getEmpleado().getIdEmpleado()) {
			inmuebleActual.setEmpleado(eDao.findById(inmuebleActualizado.getIdEmpleado()).get());
		}
		
		if (inmuebleActualizado.isActivo() != inmuebleActual.isActivo()) {
			inmuebleActual.setActivo(inmuebleActualizado.isActivo());
	    }
		
//		if (inmuebleActualizado.isActivo() != inmuebleActual.isActivo()) {
//	        throw new RuntimeException("Para cambiar el estado del inmueble debes usar una solicitud específica (solicitud put con url: http://localhost:8084/api/inmobiliaria/inmuebles/cambiarestado)");
//	    }
		
	}
	
	@Transactional
	public void actualizarEstado(InmuebleEstadoDto inmuebleActualizado) {
	   Inmueble inmuebleActual = iDao.findById(inmuebleActualizado.getId())
	            .orElseThrow(() -> new IllegalStateException("Inmueble con id " + inmuebleActualizado.getId() + " no existe"));

	    String comentarioEstado = inmuebleActualizado.getComentario();
	    if (comentarioEstado == null || comentarioEstado.trim().isEmpty()) {
	        throw new RuntimeException("Debes escribir la razón por la que se cambia el estado del inmueble en comentarios");
	    }

	    if (inmuebleActualizado.getEstado() ^ inmuebleActual.isActivo()) {
	        inmuebleActual.setActivo(inmuebleActualizado.getEstado());
	    }
	    inmuebleActual.setComentarioEstado(comentarioEstado);
	}



	
}

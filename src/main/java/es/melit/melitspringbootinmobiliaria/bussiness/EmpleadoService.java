package es.melit.melitspringbootinmobiliaria.bussiness;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.melit.melitspringbootinmobiliaria.Dao.EmpleadoDao;
import es.melit.melitspringbootinmobiliaria.entities.Demanda;
import es.melit.melitspringbootinmobiliaria.entities.Empleado;
import jakarta.transaction.Transactional;

@Service
public class EmpleadoService implements PlantillaServicio<Empleado> {

	public EmpleadoDao eDao;
	
	@Autowired
	public EmpleadoService(EmpleadoDao dao) {
		this.eDao = dao;
	}
	
	@Override
	public List<Empleado> listado() {
		try {
			return eDao.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());			
			throw new RuntimeException("Error inesperado en el servidor");
		}	
	}
	
	public List<Empleado> listadoActivos() {
		try {
			return eDao.findAllActivos();
		} catch (Exception e) {
			System.out.println(e.getMessage());			
			throw new RuntimeException("Error inesperado en el servidor");
		}	
	}

	@Override
	public Empleado buscar(Integer id) {
		Empleado empleado;
		
		try {
			Optional<Empleado> empleadoOp = eDao.findById(id);
			if(empleadoOp.isPresent()) ;
			empleado = empleadoOp.get();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());			
			throw new RuntimeException("Error inesperado en el servidor");
		}
		return empleado;
	}
	
	
	public Empleado findByNif(String nif) {
		Empleado empleado;
		
		try {
			Optional<Empleado> empleadoOp  = eDao.findFirstByNif(nif);
			if(empleadoOp.isPresent()) ;
			empleado = empleadoOp.get();
			
			 
		}catch(Exception e) {
			System.out.println(e.getMessage());			
			throw new RuntimeException("Error inesperado en el servidor");
		}
		return empleado;
	}
	
	
	@Override
	public void guardar(Empleado empleado) {
		eDao.save(empleado);
		
	}
	
	@Transactional
	@Override
	public void actualizar(Empleado actualizado) {
		Empleado empleadoActual = eDao.findById(actualizado.getIdEmpleado()).orElseThrow(()->
		new IllegalStateException("Empleao con id " + actualizado.getIdEmpleado() + " no existe"));
		
		if(actualizado.getApellidos() != null && actualizado.getApellidos().length()>0 && !Objects.equals(actualizado.getApellidos(), empleadoActual.getApellidos())) {
			empleadoActual.setApellidos(actualizado.getApellidos());
		}
		if(actualizado.getDireccion() != null && actualizado.getDireccion().length()>0 && !Objects.equals(actualizado.getDireccion(), empleadoActual.getDireccion())) {
			empleadoActual.setDireccion(actualizado.getDireccion());
		}
		if(actualizado.getEmail() != null && actualizado.getEmail().length()>0 && !Objects.equals(actualizado.getEmail(), empleadoActual.getEmail())) {
			empleadoActual.setEmail(actualizado.getEmail());
		}	
		if(actualizado.getNif() != null && actualizado.getNif().length()>0 && !Objects.equals(actualizado.getEmail(), empleadoActual.getEmail())) {
			empleadoActual.setNif(actualizado.getNif());
		}	
		if(actualizado.getNombre() != null && actualizado.getNombre().length()>0 && !Objects.equals(actualizado.getNombre(), empleadoActual.getNombre())) {
			empleadoActual.setNombre(actualizado.getNombre());
		}
		if(actualizado.getTelefono() != null && actualizado.getTelefono().length()>0 && !Objects.equals(actualizado.getTelefono(), empleadoActual.getTelefono())) {
			empleadoActual.setTelefono(actualizado.getTelefono());
		}
		if(actualizado.getNif() != null && actualizado.getNif().length()>0 && !Objects.equals(actualizado.getNif(), empleadoActual.getNif())) {
			empleadoActual.setNif(actualizado.getNif());
		}
		if(actualizado.getActivo() != null && (actualizado.getActivo()^empleadoActual.getActivo())) {
			empleadoActual.setActivo(actualizado.getActivo());
		}
		
	}
	
	@Override
	@Transactional
	public void eliminar(Integer id) {
		if(!eDao.existsById(id)) {
			throw new IllegalStateException("Empleado con id: " + id + " no existe");
		}
		try {
			Empleado empleado = eDao.findById(id).get();
			if(empleado.getTransacciones().isEmpty() && empleado.getInmuebles().isEmpty()) eDao.deleteById(id);
			else empleado.setActivo(false);
		}catch (Exception e) {
			throw new RuntimeException("Error inesperado en el servidor");
		}		
		
	}
	
	

	
}

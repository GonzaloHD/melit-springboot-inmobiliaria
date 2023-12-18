package es.melit.melitspringbootinmobiliaria.bussiness;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.melit.melitspringbootinmobiliaria.entities.Empleado;
import es.melit.melitspringbootinmobiliaria.iDao.EmpleadoDao;
import jakarta.transaction.Transactional;

@Service
public class EmpleadoService implements PlantillaServicio<Empleado> {

	public EmpleadoDao dao;
	
	@Autowired
	public EmpleadoService(EmpleadoDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Empleado> listado() {
		try {
			return dao.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());			
			throw new RuntimeException("Error inesperado en el servidor");
		}	
	}

	@Override
	public Empleado buscar(Integer id) {
		Empleado empleado;
		
		try {
			Optional<Empleado> empleadoOp = dao.findById(id);
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
			Optional<Empleado> empleadoOp  = dao.findByNif(nif);
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
		dao.save(empleado);
		
	}
	
	@Transactional
	@Override
	public void actualizar(Empleado actualizado) {
		Empleado empleadoActual = dao.findById(actualizado.getIdEmpleado()).orElseThrow(()->
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
		
	}

	@Override
	public void eliminar(Integer id) {
		if(!dao.existsById(id)) {
			throw new IllegalStateException("Empleado con id: " + id + " no existe");
		}
		dao.deleteById(id);
		
	}
	
	

	
}

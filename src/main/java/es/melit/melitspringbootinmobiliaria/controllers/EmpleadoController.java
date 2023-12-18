package es.melit.melitspringbootinmobiliaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.melit.melitspringbootinmobiliaria.bussiness.EmpleadoService;
import es.melit.melitspringbootinmobiliaria.entities.Empleado;

@RestController
@RequestMapping(path = "/empleados")
public class EmpleadoController {
	
	private EmpleadoService gestionEmpleados;
	
	@Autowired
	public EmpleadoController (EmpleadoService gestionEmpleados) {
		this.gestionEmpleados = gestionEmpleados;
	}
	
	@GetMapping
	public List<Empleado> getClientes(){
		 return gestionEmpleados.listado();
	 }
	
	@GetMapping("/{id}")
	public Empleado getEmpleadoById(@PathVariable Integer id) {
		return gestionEmpleados.buscar(id);
	}
	
//	@GetMapping("/{nif}")
//	public Empleado getEmpleadoByNif(@PathVariable String nif) {
//		return gestionEmpleados.findByNif(nif);
//	}
	
	@PostMapping(consumes = "application/json")
	public void registerEmpleados(@RequestBody Empleado empleado) {
		gestionEmpleados.guardar(empleado);
	}
	
	@PutMapping(consumes = "application/json")
	public void changeEmpleados(@RequestBody Empleado empleado) {		
		gestionEmpleados.actualizar(empleado);
	}	
	
	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable Integer id) {
		gestionEmpleados.eliminar(id);
	}
	

}

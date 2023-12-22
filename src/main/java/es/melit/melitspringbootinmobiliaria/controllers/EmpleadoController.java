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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Gestion de empleados", description = "CRUD y funcionalidad de empleados")
@RequestMapping(path = "/empleados")
public class EmpleadoController {
	
	private EmpleadoService gestionEmpleados;
	
	@Autowired
	public EmpleadoController (EmpleadoService gestionEmpleados) {
		this.gestionEmpleados = gestionEmpleados;
	}
	
	@Operation(
			   summary = "Listar todos los empleados", 
			   description = "Método get para obtener listado completo de empleados")
	@GetMapping
	public List<Empleado> getClientes(){
		 return gestionEmpleados.listado();
	 }
	
	@Operation(
			   summary = "Proporciona información de un empleado", 
			   description = "Encuentra y trae la información de un empleado a partir de un id enviado por path en la url")
	@GetMapping("/{id}")
	public Empleado getEmpleadoById(@PathVariable Integer id) {
		return gestionEmpleados.buscar(id);
	}
	
	@Operation(
			   summary = "Proporciona información de un empleado", 
			   description = "Encuentra y trae la información de un empleado a partir de su nif enviado por path en la url")
	@GetMapping("/nif/{nif}")
	public Empleado getEmpleadoByNif(@PathVariable String nif) {
		return gestionEmpleados.findByNif(nif);
	}
	
	@Operation(
			   summary = "Registrar un empleado", 
			   description = "Dar de alta un empleado introduciendo Nombre, Apellidos, Nif, Teléfono, Email y Dirección en un json")
	@PostMapping(consumes = "application/json")
	public void registerEmpleados(@RequestBody Empleado empleado) {
		gestionEmpleados.guardar(empleado);
	}
	
	@Operation(
			   summary = "Modificar un empleado", 
			   description = "Envío de json para modificar empleado a partir de su id")
	@PutMapping(consumes = "application/json")
	public void changeEmpleados(@RequestBody Empleado empleado) {		
		gestionEmpleados.actualizar(empleado);
	}	
	
	@Operation(
			   summary = "Eliminar un empleado", 
			   description = "Borra el registro de un empleado a partir de su id enviado en path de url")
	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable Integer id) {
		gestionEmpleados.eliminar(id);
	}
	

}

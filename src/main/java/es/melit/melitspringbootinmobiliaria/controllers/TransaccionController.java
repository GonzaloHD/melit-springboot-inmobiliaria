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

import es.melit.melitspringbootinmobiliaria.bussiness.DemandaService;
import es.melit.melitspringbootinmobiliaria.bussiness.EmpleadoService;
import es.melit.melitspringbootinmobiliaria.bussiness.InmuebleService;
import es.melit.melitspringbootinmobiliaria.bussiness.TransaccionService;
import es.melit.melitspringbootinmobiliaria.dto.FechaMesAnyo;
import es.melit.melitspringbootinmobiliaria.dto.PeriodoFechaDto;
import es.melit.melitspringbootinmobiliaria.dto.TransaccionDto;
import es.melit.melitspringbootinmobiliaria.entities.Demanda;
import es.melit.melitspringbootinmobiliaria.entities.Empleado;
import es.melit.melitspringbootinmobiliaria.entities.Inmueble;
import es.melit.melitspringbootinmobiliaria.entities.Transaccion;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@Tag(name = "Transacciones de compra-venta", description = "Operaciones sobre transacciones. CRUD y busqueda de transacciones")
@RequestMapping(path = "/transacciones")
public class TransaccionController {	
	
	private TransaccionService transaccionService;
	private InmuebleService inmuebleService;
	private DemandaService demandaService;
	private EmpleadoService empleadoService;
	@Autowired
	public TransaccionController(TransaccionService transaccionService, InmuebleService inmuebleService, DemandaService demandaService, EmpleadoService empleadoService) {
		this.transaccionService = transaccionService;
		this.inmuebleService = inmuebleService;
		this.demandaService = demandaService;
		this.empleadoService = empleadoService;
	}
	
	@Operation(
			summary = "Devuelve todas las transacciones", 
			description = "Devuelve todas las transacciones registradas")
	@GetMapping
	public List<Transaccion> getTransacciones(){
		 return transaccionService.listado();
	 }	
	@Operation(
			summary = "Buscar transacion por id de la transacción", 
			description = "Introducir id de transacción para ver sus detalles")
	@GetMapping(path = "{idTransaccion}")
	public Transaccion getTransaccion(@PathVariable("idTransaccion") Integer idTransaccion){
		 return transaccionService.buscar(idTransaccion);
	 }
	@Operation(
			summary = "Buscar transaciones por id del empledo", 
			description = "Introducir id del empleado para ver sus transacciones")
	@GetMapping(path = "/empleado/{idEmpleado}")
	public List<Transaccion> getTransaccionesEmpleado(@PathVariable("idEmpleado") Integer idEmpleado){
		 return transaccionService.buscarPorEmpleado(idEmpleado);
	 }
	
	@Operation(
			summary = "Buscar transacciones por mes y año", 
			description = "Introducir fecha en formato MM/AAAA para recibir las transacciones de ese mes y año, envíado en formato json.")
	@PostMapping(path = "/transaccionesmes", consumes = "application/json")
	public List<Transaccion> getTransaccionesDelMes(@RequestBody FechaMesAnyo fecha){		
		System.out.println(fecha.getFecha());
		 return transaccionService.buscarPorMes(fecha.getFecha());
	}
	
	@Operation(
			summary = "Buscar transacciones por mes y año", 
			description = "Introducir mes y año para recibir las transacciones de ese mes y año")
	@GetMapping(path = "/transaccionesmesformulario/{mes}/{anyo}")
	public List<Transaccion> getTransaccionesMesFormulario(@PathVariable("mes") String mes, @PathVariable("anyo") String anyo){
		 return transaccionService.buscarPorMes(mes + "/" + anyo);
	}
	
	@Operation(
			summary = "Devuelve la cantidad total facturada en ese mes", 
			description = "Introducir fecha en formato MM/AAAA para recibir las transacciones de ese mes y año, envíado en formato json.")
	@PostMapping(path = "/facturadomes", consumes = "application/json")
	public double getFacturadolMes(@RequestBody FechaMesAnyo fecha){		
		 return transaccionService.facturadoMes(fecha.getFecha());
	}
	
	@Operation(
			summary = "Devuelve la cantidad total facturada en ese mes", 
			description = "Introducir mes y año para recibir la cantidad total facturada de ese mes")
	@GetMapping(path = "/facturadomesformulario/{mes}/{anyo}")
	public double getFacturadoMesFormulario(@PathVariable("mes") String mes, @PathVariable("anyo") String anyo){
		 return transaccionService.facturadoMes(mes + "/" + anyo);
	}	

	
	@Operation(
			summary = "Buscar transacciones entre un periodo de fechas", 
			description = "Introducir dos fechas para devolver las transacciones realizadas en ese periodo")
	@PostMapping(path = "/transaccionesperiodo", consumes = "application/json")
	public List<Transaccion> getTransaccionesPeriodo(@RequestBody PeriodoFechaDto periodo){
		 return transaccionService.buscarPorPeriodo(periodo.getFechaInicio(), periodo.getFechaFin());
	 }	
	
	@Operation(
			summary = "Devuelve la cantidad total facturada en un periodo", 
			description = "Devuelve la cantidad total facturada en transacción en un periodo")
	@PostMapping(path = "/facturadoperiodo", consumes = "application/json")
	public double getFacturadoPeriodo(@RequestBody PeriodoFechaDto periodo){
		 return transaccionService.facturadoPeriodo(periodo.getFechaInicio(), periodo.getFechaFin());
	}
	
	
	@Operation(
			summary = "Registrar una transacción por compra y venta de un inmueble", 
			description = "Introducir la demanda, inmueble, empleado así como comentario pertinente. Se generará fecha de transacción y precio final del inmueble")
	@PostMapping(consumes = "application/json")
	public void registrarTransaccion(@RequestBody TransaccionDto transaccionDto) {			
		Demanda demanda = demandaService.buscar(transaccionDto.getIdDemanda());
		Inmueble inmueble = inmuebleService.buscar(transaccionDto.getIdInmueble());
		String comentario = transaccionDto.getComentario();
		Empleado empleado = empleadoService.buscar(transaccionDto.getIdEmpleado());
		Transaccion transaccion = new Transaccion(comentario, inmueble, demanda, empleado);

		transaccionService.guardar(transaccion);
	 }	

//	@PostMapping(consumes = "application/json")
//	public void registrarTeansaccionDNI(@RequestBody)	

	@Operation(
			summary = "Modificar transacción", 
			description = "Modificar comentario de la transacción, el resto de valores no se considera que se deban modificar")

//	@Operation(
//			   summary = "Hacer transacción sin necesidad del id de la demanda", 
//			   description = "Introducir dni del cliente, id de empleado, id del inmueble y un comentario")
//	@PostMapping(path = "/creaciodni/{dniCliente}/{idEmpleado}/{idInmueble}/{comentario}")
//	public void registrarTeansaccionDNI(@PathVariable("dniCliente") String dniCliente, 
//										@PathVariable("idEmpleado") Integer idEmpleado,
//										@PathVariable("idInmueble") Integer idInmueble,
//										@PathVariable("comentario") String comentario) {
//		Demanda demanda = demandaService.buscarPorIdInmuebleDniEmpleado(idInmueble, dniCliente);
//		Inmueble inmueble = inmuebleService.buscar(idInmueble);
//		Empleado empleado = empleadoService.buscar(idEmpleado);
//		
//		Transaccion transaccion = new Transaccion(comentario, inmueble, demanda, empleado);
//		transaccionService.guardar(transaccion);
//	}
	

	@PutMapping(consumes = "application/json")
	public void cambiarTransaccion(@RequestBody Transaccion transaccion) {		
		transaccionService.actualizar(transaccion);
	}
	
	@Operation(
			summary = "Eliminar transacción", 
			description = "Envía solicitud para eliminar transacción")
	@DeleteMapping(path = "{idTransaccion}")
	public void deleteTransaccion(@PathVariable("idTransaccion") Integer idTransaccion) {
		transaccionService.eliminar(idTransaccion);
	}
	
}

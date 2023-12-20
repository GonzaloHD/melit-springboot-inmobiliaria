package es.melit.melitspringbootinmobiliaria.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import es.melit.melitspringbootinmobiliaria.dto.TransaccionDto;
import es.melit.melitspringbootinmobiliaria.entities.Demanda;
import es.melit.melitspringbootinmobiliaria.entities.Empleado;
import es.melit.melitspringbootinmobiliaria.entities.Inmueble;
import es.melit.melitspringbootinmobiliaria.entities.Transaccion;

@RestController
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
	@GetMapping
	public List<Transaccion> getTransacciones(){
		 return transaccionService.listado();
	 }	
	
	@GetMapping(path = "{idTransaccion}")
	public Transaccion getTransaccion(@PathVariable("idTransaccion") Integer idTransaccion){
		 return transaccionService.buscar(idTransaccion);
	 }
	
	@GetMapping(path = "/empleado/{idEmpleado}")
	public List<Transaccion> getTransaccionesEmpleado(@PathVariable("idEmpleado") Integer idEmpleado){
		 return transaccionService.buscarPorEmpleado(idEmpleado);
	 }
	
	@GetMapping(path = "/transaccionesmes")
	public List<Transaccion> getTransaccion(@RequestBody Map<String, Object> fecha){
		 return transaccionService.buscarPorMes(fecha.get("fecha").toString());
	 }

	@PostMapping(consumes = "application/json")
	public void registrarTransaccion(@RequestBody TransaccionDto transaccionDto) {			
		Demanda demanda = demandaService.buscar(transaccionDto.getIdDemanda());
		Inmueble inmueble = inmuebleService.buscar(transaccionDto.getIdInmueble());
		String comentario = transaccionDto.getComentario();
		Empleado empleado = empleadoService.buscar(transaccionDto.getIdEmpleado());
		Transaccion transaccion = new Transaccion(comentario, inmueble, demanda, empleado);

		transaccionService.guardar(transaccion);
	 }

	@PutMapping(consumes = "application/json")
	public void cambiarTransaccion(@RequestBody Transaccion transaccion) {		
		transaccionService.actualizar(transaccion);
	}
	
}

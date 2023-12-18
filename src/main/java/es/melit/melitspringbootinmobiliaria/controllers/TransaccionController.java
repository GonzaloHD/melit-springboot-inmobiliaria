package es.melit.melitspringbootinmobiliaria.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.melit.melitspringbootinmobiliaria.bussiness.DemandaService;
import es.melit.melitspringbootinmobiliaria.bussiness.InmuebleService;
import es.melit.melitspringbootinmobiliaria.bussiness.TransaccionService;
import es.melit.melitspringbootinmobiliaria.dto.TransaccionDto;
import es.melit.melitspringbootinmobiliaria.entities.Demanda;
import es.melit.melitspringbootinmobiliaria.entities.Inmueble;
import es.melit.melitspringbootinmobiliaria.entities.Transaccion;

@RestController
@RequestMapping(path = "/transacciones")
public class TransaccionController {	
	
	private TransaccionService transaccionService;
	private InmuebleService inmuebleService;
	private DemandaService demandaService;
	
	@Autowired
	public TransaccionController(TransaccionService transaccionService, InmuebleService inmuebleService, DemandaService demandaService) {
		this.transaccionService = transaccionService;
		this.inmuebleService = inmuebleService;
		this.demandaService = demandaService;

	}		
	@GetMapping
	public List<Transaccion> getTransacciones(){
		 return transaccionService.listado();
	 }	
	
	@PostMapping(consumes = "application/json")
	public void registrarTransaccion(@RequestBody TransaccionDto transaccionDto) {			
		Demanda demanda = demandaService.buscar(transaccionDto.getIdDemanda());
		Inmueble inmueble = inmuebleService.buscar(transaccionDto.getIdInmueble());
		Date fecha = transaccionDto.getFecha();
		String comentario = transaccionDto.getComentario();
		Transaccion transaccion = new Transaccion(fecha, comentario, inmueble, demanda);
		transaccionService.guardar(transaccion);
	 }
	
	@GetMapping(path = "{idTransaccion}")
	public Transaccion getTransaccion(@PathVariable("idTransaccion") Integer idTransaccion){
		 return transaccionService.buscar(idTransaccion);
	 }

	@PutMapping(consumes = "application/json")
	public void cambiarTransaccion(@RequestBody Transaccion transaccion) {		
		transaccionService.actualizar(transaccion);
	}
	
}

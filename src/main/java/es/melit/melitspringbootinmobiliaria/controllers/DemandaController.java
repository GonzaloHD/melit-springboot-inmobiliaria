package es.melit.melitspringbootinmobiliaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.melit.melitspringbootinmobiliaria.bussiness.ClienteService;
import es.melit.melitspringbootinmobiliaria.bussiness.DemandaService;
import es.melit.melitspringbootinmobiliaria.bussiness.InmuebleService;
import es.melit.melitspringbootinmobiliaria.dto.DemandaDto;
import es.melit.melitspringbootinmobiliaria.entities.Cliente;
import es.melit.melitspringbootinmobiliaria.entities.Demanda;
import es.melit.melitspringbootinmobiliaria.entities.Inmueble;

@RestController
@RequestMapping(path = "/demandas")
public class DemandaController {	
	
	private DemandaService demandaService;
	private ClienteService clienteService;
	private InmuebleService inmuebleService;
	
	@Autowired
	public DemandaController(DemandaService demandaService, ClienteService clienteService, InmuebleService inmuebleService) {
		this.demandaService = demandaService;
		this.clienteService = clienteService;
		this.inmuebleService = inmuebleService;

	}		
	@GetMapping
	public List<Demanda> getDemandas(){
		 return demandaService.listado();
	 }	
	
	@GetMapping(path = "{idDemanda}")
	public Demanda getDemanda(@PathVariable("idDemanda") Integer idDemanda){
		 return demandaService.buscar(idDemanda);
	 }
	
	@GetMapping(consumes = "application/json", path = "demandasporcaracteristicas")
	public List<Demanda> getDemandaCaracteristicas(@RequestBody Demanda demanda){		
			Integer numHabitaciones = demanda.getNumHabitaciones();
			String localidad = demanda.getLocalidad();
			String tipoVivienda = demanda.getTipoVivienda();
		
		return demandaService.buscarPorCaracteristicas(numHabitaciones, localidad, tipoVivienda);
		
	 }
	
	@GetMapping(path = "/demandaInmueble/{idInmueble}")
	public List<Demanda> getDemandaPorInmueble(@PathVariable("idInmueble") Integer idInmueble){		
		Inmueble inmueble = inmuebleService.buscar(idInmueble);
		String localidad = inmueble.getLocalidad();
		String tipoVivienda = inmueble.getTipoVivienda();
		Integer numHabitaciones = inmueble.getNumHabitaciones();
		
		return demandaService.buscarPorCaracteristicas(numHabitaciones, localidad, tipoVivienda);
		
	 }
	
	@PostMapping(consumes = "application/json")
	public void registrarDemanda(@RequestBody DemandaDto demandaDto) {			
		Cliente cliente = clienteService.buscar(demandaDto.getIdCliente());
		String descripcion = demandaDto.getDescripcion();
		String localidad = demandaDto.getLocalidad();
		Integer numHabitaciones = demandaDto.getNumHabitaciones();
		String tipoVivienda = demandaDto.getTipoVivienda();
		Demanda demanda = new Demanda(descripcion, localidad, numHabitaciones, tipoVivienda, cliente);
		demandaService.guardar(demanda);

	 }


	@PutMapping(consumes = "application/json")
	public void cambiarDemanda(@RequestBody Demanda demanda) {		
		demandaService.actualizar(demanda);
	}
	
}

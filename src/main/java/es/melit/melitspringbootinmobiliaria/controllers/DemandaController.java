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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Demandas de clientes", description = "Operaciones sobre demandas. CRUD y busqueda de publicaciones")
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
	
	@Operation(
			summary = "Listar todas las demandas de clientes", 
			description = "Devuelve todas las demandas de clientes")
	@GetMapping
	public List<Demanda> getDemandas(){
		 return demandaService.listado();
	 }	
	@Operation(
			summary = "Busca demanda por id", 
			description = "Devuelve demanda por id de la demanda")
	@GetMapping(path = "{idDemanda}")
	public Demanda getDemanda(@PathVariable("idDemanda") Integer idDemanda){
		 return demandaService.buscar(idDemanda);
	 }
	
	@Operation(
			summary = "Busca demanda por características", 
			description = "Devuelve todas las demandas por características, numero habitaciones, localidad y tipo de vivienda."
					+ " Formato de solicitud en json")
	@PostMapping(consumes = "application/json", path = "/demandasporcaracteristicas")
	public List<Demanda> getDemandaCaracteristicas(@RequestBody Demanda demanda){		
			Integer numHabitaciones = demanda.getNumHabitaciones();
			String localidad = demanda.getLocalidad();
			String tipoVivienda = demanda.getTipoVivienda();
		
		return demandaService.buscarPorCaracteristicas(numHabitaciones, localidad, tipoVivienda);
		
	 }
	
	@Operation(
			summary = "Busca demandas que coinciden con un inmueble por id", 
			description = "Devuelve todas las demandas que coinciden"
					+ " con las características de numero habitaciones, localidad y tipo de vivienda de un inmuelbe ingresado por su id")
	@GetMapping(path = "/demandaInmueble/{idInmueble}")
	public List<Demanda> getDemandaPorInmueble(@PathVariable("idInmueble") Integer idInmueble){		
		Inmueble inmueble = inmuebleService.buscar(idInmueble);
		String localidad = inmueble.getLocalidad();
		String tipoVivienda = inmueble.getTipoVivienda();
		Integer numHabitaciones = inmueble.getNumHabitaciones();
		
		return demandaService.buscarPorCaracteristicas(numHabitaciones, localidad, tipoVivienda);
		
	 }
	
	@Operation(
			summary = "Registrar demanda de cliente", 
			description = "Ingresa una nueva demanda para un cliente")
	@PostMapping(consumes = "application/json")
	public void registrarDemanda(@RequestBody DemandaDto demandaDto) {			
		Cliente cliente = clienteService.buscar(demandaDto.getIdCliente());
		String descripcion = demandaDto.getDescripcion();
		String localidad = demandaDto.getLocalidad();
		Integer numHabitaciones = demandaDto.getNumHabitaciones();
		String tipoVivienda = demandaDto.getTipoVivienda();
		Demanda demanda = new Demanda(descripcion, localidad, numHabitaciones, tipoVivienda, cliente, true);
		demandaService.guardar(demanda);

	 }

	@Operation(
			summary = "Modificar demanda", 
			description = "Devuelve todas las transacciones registradas")
	@PutMapping(consumes = "application/json")
	public void cambiarDemanda(@RequestBody Demanda demanda) {		
		demandaService.actualizar(demanda);
	}
	
}

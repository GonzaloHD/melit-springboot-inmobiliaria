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

import es.melit.melitspringbootinmobiliaria.bussiness.ClienteService;
import es.melit.melitspringbootinmobiliaria.bussiness.EmpleadoService;
import es.melit.melitspringbootinmobiliaria.bussiness.InmuebleService;
import es.melit.melitspringbootinmobiliaria.dto.InmuebleDto;
import es.melit.melitspringbootinmobiliaria.entities.Cliente;
import es.melit.melitspringbootinmobiliaria.entities.Empleado;
import es.melit.melitspringbootinmobiliaria.entities.Inmueble;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Gestion de inmuebles", description = "CRUD y funcionalidad de inmuebles")
@RequestMapping(path = "/inmuebles")
public class InmuebleController {
	
	private InmuebleService inmuebleService;
	private ClienteService gestionClientes;
	private EmpleadoService empleadoService;
	
	@Autowired
	public InmuebleController(InmuebleService inmuebleService, ClienteService gestionClientes, EmpleadoService empleadoService) {
		this.inmuebleService = inmuebleService;
		this.gestionClientes = gestionClientes;
		this.empleadoService = empleadoService;

	}
	@Operation(
			   summary = "Listar todos los inmuebles", 
			   description = "Método get para obtener listado completo de inmuebles")
	@GetMapping
	public List<Inmueble> getInmuebles(){

		 return inmuebleService.listado();
	 }	
	
	@Operation(
			   summary = "Proporciona información de un inmueble", 
			   description = "Encuentra y trae la información de un inmueble a partir de un id enviado por path en la url")
	@GetMapping(path = "{idInmueble}")
	public Inmueble getInmueble(@PathVariable("idInmueble") Integer idInmueble){
		 return inmuebleService.buscar(idInmueble);
	 }
	
	@Operation(
			   summary = "Listar inmuebles de una localidad", 
			   description = "Obtiene la lista de todos los inmuebles registrados en una localidad introduciendo ésta por path de url")
	@GetMapping(path = "/localidad/{localidad}")
	public List<Inmueble> findByLocalidad (@PathVariable String localidad){
		return inmuebleService.findByLocalidad(localidad);
	}
	
	@Operation(
			   summary = "Listar todos los inmuebles que coincidan con ciertos parámetros", 
			   description = "Envío de un json con los parámetros localidad, tipoVivienda y numHabitaciones para "
			   		+ "obtener la lista de inmuebles que se ajustan a estos criterios")
	@GetMapping(path = "/busquedaparametros")
	public List<Inmueble> findByParametros (@RequestBody InmuebleDto inmuebleDto){
		
		String localidad = inmuebleDto.getLocalidad();
		String tipoVivienda = inmuebleDto.getTipoVivienda();
		Integer numHabitaciones = inmuebleDto.getNumHabitaciones();

        return inmuebleService.findByParametros(localidad, tipoVivienda, numHabitaciones);
	    }
	
	
//	@GetMapping(path = "/inmuebledemanda/{idInmueble}")
//	public List<Inmueble> findDemandaInmuebleById (@PathVariable("idInmueble") Integer idInmueble){
//		
//		String localidad = inmuebleDto.getLocalidad();
//		String tipoVivienda = inmuebleDto.getTipoVivienda();
//		Integer numHabitaciones = inmuebleDto.getNumHabitaciones();
//
//        return inmuebleService.findByParametros(localidad, tipoVivienda, numHabitaciones);
//	    }	
	
	@Operation(
			   summary = "Listar todos los inmuebles que se ajusten a la demanda de un cliente", 
			   description = "Introducir por path de url el id de un cliente para listar los "
			   		+ "inmuebles que se ajusten a alguna de sus demandas")
	@GetMapping(path = "/inmueblesdemandados/{idCliente}")
	public List<Inmueble> findInmueblesDemandadosCliente (@PathVariable Integer idCliente){
		System.out.println(idCliente);
        return inmuebleService.findDemandadosInmueble(idCliente);
	    }		
	    
	@Operation(
			   summary = "Listar todos los inmuebles que coincidan con alguna demanda", 
			   description = "Cruza los datos de inmuebles con los de demandas y devuelve "
			   		+ "los que coincidan en localidad, tipo de vivienda y número de habitaciones")
	@GetMapping(path = "/inmueblesmacthdemandas")
	public List<Inmueble> cruzarInmuebleDemanda (){
		return inmuebleService.cruzarDemandasInmubles();
	}
	
	@Operation(
			   summary = "Registrar un inmueble", 
			   description = "Envío de json con los datos del inmueble y el id de cliente "
			   		+ "propietario para registarlo. El id de empleado es optativo")
	@PostMapping(consumes = "application/json")
	public void registerInmueble(@RequestBody InmuebleDto inmuebleDto) {
		Cliente cliente = gestionClientes.buscar(inmuebleDto.getIdCliente());
		
		Inmueble inmuebleDao = new Inmueble();
		
		inmuebleDao.setActivo(inmuebleDto.isActivo());
		inmuebleDao.setCliente(cliente);
		inmuebleDao.setDescripcion(inmuebleDto.getDescripcion());
		inmuebleDao.setDireccion(inmuebleDto.getDireccion());
		inmuebleDao.setLocalidad(inmuebleDto.getLocalidad());
		inmuebleDao.setNumHabitaciones(inmuebleDto.getNumHabitaciones());
		inmuebleDao.setTipoVivienda(inmuebleDto.getTipoVivienda());
		if (inmuebleDto.getIdEmpleado() != null) {
			Empleado empleado = empleadoService.buscar(inmuebleDto.getIdEmpleado());
			inmuebleDao.setEmpleado(empleado);
		}
				
		inmuebleService.guardar(inmuebleDao);
		
	 }	
	
	@Operation(
			   summary = "Modificar un inmueble", 
			   description = "Envío de json con el id del inmueble y los parámetros que se desean modificar")
	@PutMapping(consumes = "application/json")
	public void changeInmueble(@RequestBody Inmueble inmueble) {		
		inmuebleService.actualizar(inmueble);
	}	
	
	@Operation(
			   summary = "Borrar un inmueble", 
			   description = "Borrar inmueble introduciendo su id en el path de url")
	@DeleteMapping("/{id}")
	public void deleteInmueble(@PathVariable Integer id) {
		inmuebleService.eliminar(id);
	}
	

}

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

@RestController

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
	@GetMapping
	public List<Inmueble> getInmuebles(){

		 return inmuebleService.listado();
	 }	
	
	@GetMapping(path = "{idInmueble}")
	public Inmueble getInmueble(@PathVariable("idInmueble") Integer idInmueble){
		 return inmuebleService.buscar(idInmueble);
	 }
	
	@GetMapping(path = "/localidad/{localidad}")
	public List<Inmueble> findByLocalidad (@PathVariable String localidad){
		return inmuebleService.findByLocalidad(localidad);
	}
	
	@GetMapping(path = "/busquedaparametros")
	public List<Inmueble> findByParametros (@RequestBody InmuebleDto inmuebleDto){
		
		String localidad = inmuebleDto.getLocalidad();
		String tipoVivienda = inmuebleDto.getTipoVivienda();
		Integer numHabitaciones = inmuebleDto.getNumHabitaciones();

        return inmuebleService.findByParametros(localidad, tipoVivienda, numHabitaciones);
	    }
	
	@GetMapping(path = "/inmuebledemanda")
	public List<Inmueble> findDemandaInmueble (@RequestBody InmuebleDto inmuebleDto){
		
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
	
	
	
	@GetMapping(path = "/inmueblesdemandados/{idCliente}")
	public List<Inmueble> findInmueblesDemandadosCliente (@PathVariable Integer idCliente){
		System.out.println(idCliente);
        return inmuebleService.findDemandadosInmueble(idCliente);
	    }
		
	
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
		
	@PutMapping(consumes = "application/json")
	public void changeInmueble(@RequestBody Inmueble inmueble) {		
		inmuebleService.actualizar(inmueble);
	}	
	
	@DeleteMapping("/{id}")
	public void deleteInmueble(@PathVariable Integer id) {
		inmuebleService.eliminar(id);
	}
	

}

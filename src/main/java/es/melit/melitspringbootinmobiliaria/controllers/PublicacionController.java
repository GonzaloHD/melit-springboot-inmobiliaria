package es.melit.melitspringbootinmobiliaria.controllers;

import java.time.Instant;
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

import es.melit.melitspringbootinmobiliaria.bussiness.InmuebleService;
import es.melit.melitspringbootinmobiliaria.bussiness.PublicacionService;
import es.melit.melitspringbootinmobiliaria.dto.PublicacionDto;
import es.melit.melitspringbootinmobiliaria.entities.Inmueble;
import es.melit.melitspringbootinmobiliaria.entities.Publicacion;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Publicaciones de inmuebles", description = "Operaciones sobre publicaciones. CRUD y busqueda de publicaciones")
@RequestMapping(path = "/publicaciones")
public class PublicacionController {	
	
	private PublicacionService publicacionService;
	private InmuebleService inmuebleService;	
	
	@Autowired
	public PublicacionController(PublicacionService publicacionService, InmuebleService inmuebleService) {
		this.publicacionService = publicacionService;
		this.inmuebleService = inmuebleService;
	}
	
	@Operation(
			summary = "Devuelve todas las publicaciones", 
			description = "Devuelve todas las publicaciones que se han registrado")
	@GetMapping
	public List<Publicacion> getPublicaciones(){
		 return publicacionService.listado();
	 }	
	
	@Operation(
			summary = "Devuelve todas las publicaciones activas", 
			description = "Devuelve todas las publicaciones activas que no han sido cerradas")
	@GetMapping(path = "/activas/")
	public List<Publicacion> getPublicacionesActivas(){
		 return publicacionService.listadoActivas();
	 }	
	
	@Operation(
			summary = "Modificar publicaciones", 
			description = "Devuelve todas las transacciones registradas")
	@PostMapping(consumes = "application/json")
	public void registrarPublicacion(@RequestBody PublicacionDto publicacionDto) {	
		
		Inmueble inmueble = inmuebleService.buscar(publicacionDto.getIdInmueble());
		Double coste = publicacionDto.getCoste();
		Instant fechaInicio = publicacionDto.getFechaInicio();		
		
		Publicacion publicacion = new Publicacion(inmueble, fechaInicio, coste);
		
		publicacionService.guardar(publicacion);
	 }
	
	@Operation(
			summary = "Devuelve publicación por id", 
			description = "Busqueda de publicación por id")
	@GetMapping(path = "{idPublicacion}")
	public Publicacion getPublicacion(@PathVariable("idPublicacion") Integer idPublicacion){
		 return publicacionService.buscar(idPublicacion);
	 }
	
	@Operation(
			summary = "Modificación de publicación", 
			description = "Para modificar coste de la publicación, resto de parámetros no son modificables por coherencia")
	@PutMapping(consumes = "application/json")
	public void cambiarPublicacion(@RequestBody Publicacion publicacion) {		
		publicacionService.actualizar(publicacion);
	}
	
	@Operation(
			summary = "Cerrar publicación", 
			description = "Comprueba si existe la publicación y si no esta ya cerrada, en cuyo caso le pone fecha de cierre a la misma")
	@PutMapping(path = "{idPublicacion}")
	public Publicacion cerrarPublicacion(@PathVariable("idPublicacion") Integer idPublicacion) {		
		return publicacionService.cerrar(idPublicacion);
	}
	
	@Operation(
			summary = "Elimina publicación", 
			description = "Elimina la publicación por id")
	@DeleteMapping(path = "{idPublicacion}")
	public void eliminarPublicacion(@PathVariable("idPublicacion") Integer idPublicacion) {
		publicacionService.eliminar(idPublicacion);
	}
	
}

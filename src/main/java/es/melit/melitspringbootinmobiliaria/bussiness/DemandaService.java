package es.melit.melitspringbootinmobiliaria.bussiness;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.melit.melitspringbootinmobiliaria.entities.Demanda;
import es.melit.melitspringbootinmobiliaria.entities.Inmueble;
import es.melit.melitspringbootinmobiliaria.iDao.DemandaDao;
import jakarta.transaction.Transactional;

@Service
public class DemandaService implements PlantillaServicio<Demanda> {
	
	public DemandaDao dDao;	
	
	@Autowired
	public DemandaService(DemandaDao dDao) {
		super();
		this.dDao = dDao;
	}

	@Override
	public List<Demanda> listado() {
		try {
			return dDao.findAll();
		}catch (Exception e) {
			throw new RuntimeException("Error inesperado en el servidor");
		}		
	}

	@Override
	public Demanda buscar(Integer id) {
		Optional<Demanda> optionalDemanda;
		try {			
			optionalDemanda = dDao.findById(id);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Error inesperado en el servidor");
		}
		if(optionalDemanda.isEmpty()) {
			throw new IllegalStateException("Demanda buscada no existe");		}
		return optionalDemanda.get();	
	}
	
	
	public List<Demanda> buscarPorCaracteristicas(Integer numHabitaciones, String localidad, String tipoVivienda){
		
		if(localidad != null) localidad = localidad.toLowerCase();
		if(tipoVivienda != null) tipoVivienda = tipoVivienda.toLowerCase();
		
		System.out.println("---------------");
		System.out.println(localidad);
		System.out.println(tipoVivienda);
		System.out.println(numHabitaciones);
		System.out.println("---------------");
		
		return dDao.findByCaracteristicas(numHabitaciones, localidad, tipoVivienda);		
	}
	
	public List<Demanda> findByParametros (String localidad, String tipoVivienda, Integer numHabitaciones){
		
		 try {
		        return dDao.findDemandasporIdInmueble(localidad, tipoVivienda, numHabitaciones);
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		        throw new RuntimeException("Error inesperado en el servidor");
		    }
	}
	

	@Override
	public void guardar(Demanda demanda) {
		try {
			dDao.save(demanda);
		} catch (Exception e) {
			throw new RuntimeException("Error inesperado en el servidor");
		}		
	}

	@Override
	public void eliminar(Integer id) {
		if(!dDao.existsById(id)) {
			throw new IllegalStateException("Demanda con id: " + id + " no existe");
		}
		try {
			dDao.deleteById(id);
		}catch (Exception e) {
			throw new RuntimeException("Error inesperado en el servidor");
		}
	}

	@Override
	@Transactional
	public void actualizar(Demanda actualizado) {		
		Demanda actual = dDao.findById(actualizado.getIdDemanda()).orElseThrow(()->
		new IllegalStateException("Demanda con id " + actualizado.getIdDemanda() + " no existe"));
		
		if(actualizado.getDescripcion() != null && actualizado.getDescripcion().length()>0 && !Objects.equals(actualizado.getDescripcion(), actual.getDescripcion())) {
			actual.setDescripcion(actualizado.getDescripcion());
		}		
		
	}

}

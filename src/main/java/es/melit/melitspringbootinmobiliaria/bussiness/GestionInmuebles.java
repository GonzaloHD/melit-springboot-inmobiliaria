package es.melit.melitspringbootinmobiliaria.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.melit.melitspringbootinmobiliaria.entities.Inmueble;
import es.melit.melitspringbootinmobiliaria.persistence.InmueblePersistence;

@Service
public class GestionInmuebles {
	
//	Preguntar si inyectar en atributo o constructor y constructor vacío?
	public InmueblePersistence iDao;	
	
	@Autowired
	public GestionInmuebles(InmueblePersistence iDao) {
		this.iDao = iDao;
	}
	
	public List<Inmueble> listadoInmuebles(){		
			
		try {
			return iDao.findAll();
		} catch (Exception e) {
			return null;
		}		
	}
	
	public void guardarInmueble(Inmueble inmueble) {
		iDao.save(inmueble);
	}
	
}

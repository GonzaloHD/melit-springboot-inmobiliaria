package es.melit.melitspringbootinmobiliaria.config;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.melit.melitspringbootinmobiliaria.entities.Cliente;
import es.melit.melitspringbootinmobiliaria.entities.Demanda;
import es.melit.melitspringbootinmobiliaria.entities.Empleado;
import es.melit.melitspringbootinmobiliaria.entities.Inmueble;
import es.melit.melitspringbootinmobiliaria.entities.Publicacion;
import es.melit.melitspringbootinmobiliaria.entities.Transaccion;
import es.melit.melitspringbootinmobiliaria.iDao.ClienteDao;
import es.melit.melitspringbootinmobiliaria.iDao.DemandaDao;
import es.melit.melitspringbootinmobiliaria.iDao.EmpleadoDao;
import es.melit.melitspringbootinmobiliaria.iDao.InmuebleDao;
import es.melit.melitspringbootinmobiliaria.iDao.PublicacionDao;
import es.melit.melitspringbootinmobiliaria.iDao.TransaccionDao;


@Configuration
public class InmobiliariaConfig {
	@Bean	
	CommandLineRunner commandLineRunner(ClienteDao cDao, DemandaDao dDao, EmpleadoDao eDao, InmuebleDao iDao, PublicacionDao pDao, TransaccionDao tDao) {

		return args-> {
			
			System.out.println("Hola CommandLineRunner");
			
			Cliente c1 = new Cliente("UNO", "Lolo", "Lopez", "Sin direccion", "asdf@asdf.com", "65448");
			Cliente c2 = new Cliente("DOS", "Lola", "Lopez", "con direccion", "asdf@asdf.com", "65448");
			
			cDao.saveAll(List.of(c1,c2));
			
			Empleado e1 = new Empleado("UNO", "Jorje", "Sin casa","HOLA" , "sdffsdf@ewr.sda", "654");
			Empleado e2 = new Empleado("DOS", "Jorje", "Sin casa","HOLA" , "sdffsdf@ewr.sda", "654");
			
			eDao.saveAll(List.of(e1,e2));

			Inmueble i1 = new Inmueble("PRIMERO", "Calle asdf", "Madrid", "Piso", 3, false, c1, e1);
			Inmueble i2 = new Inmueble("OTRA", "Calle asdf asdfw", "Madrid", "Piso", 3, false, c2, e2);			
			
			iDao.saveAll(List.of(i1,i2));
			
			Demanda d1 = new Demanda("Quiero una casa muy grande", "Almeria", 1, "Dupex", c1);
			Demanda d2 = new Demanda("Quiero una casa muy pequeña", "Armenia", 4, "Castillo", c2);
			
			dDao.saveAll(List.of(d1,d2));
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			String fechaString1 = "24/11/2022";
			String fechaString2 = "25/10/2023";
			
			Transaccion t1 = new Transaccion(sdf.parse(fechaString1), "Genial", i1, d1);
			Transaccion t2 = new Transaccion(sdf.parse(fechaString2), "No problema", i2, d2);
			
			tDao.saveAll(List.of(t1,t2));
			
			String fechaString3 = "24/01/2022";
			String fechaString4 = "25/10/2022";
			
			String fechaString5 = "24/10/2022";
			String fechaString6 = "25/01/2023";
			
			Publicacion p1 = new Publicacion(i1, sdf.parse(fechaString3), sdf.parse(fechaString4), 5.3);
			Publicacion p2 = new Publicacion(i2, sdf.parse(fechaString5), sdf.parse(fechaString6), 7.77);
			
			pDao.saveAll(List.of(p1,p2));


		};
		
	}


}





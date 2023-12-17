package es.melit.melitspringbootinmobiliaria.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.melit.melitspringbootinmobiliaria.entities.Inmueble;
import es.melit.melitspringbootinmobiliaria.persistence.InmueblePersistence;


@Configuration
public class InmobiliariaConfig {
//	@Bean	
//	CommandLineRunner commandLineRunner(InmueblePersistence iDao) {
//		
//		return args-> {
//			
//			System.out.println("HOLA CommandLineRunner");
//			
//			Inmueble i1 = new Inmueble("Primero", "prueba1", "prueba1","prueba1", 3, true);
//			Inmueble i2 = new Inmueble("Segundo", "prueba2", "prueba2","prueba2", 2, false);
//			iDao.saveAll(List.of(i1,i2));
//
//		};
//		
//	}

}

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
			
			Cliente c1 = new Cliente("50348755F", "Lolo", "Lopez", "Calle Altamira, 40 28032 Madrid", "lololopez@abcd.com", "653587485");
			Cliente c2 = new Cliente("78601449J", "Lola", "Lopez", "Calle Aquitania, 22 04720 Almeria", "Lolapez@abcd.com", "687394124");
			Cliente c3 = new Cliente("74879668I", "Alberto", "Fernandez", "Calle de Balmes, 24 08012 Barcelona", "alfernan@abcd.com", "681579400");
			Cliente c4 = new Cliente("18547960J", "Yolanda", "Martinez", "Calle Nuñez de Arce, 30 47002 Valladoliz", "yolandamartinez@abcd.com", "667751171");
			Cliente c5 = new Cliente("54087884O", "Alfredo", "García", "Calle Rosario, 7 02004 Albacete", "alfredgar@abcd.com", "689117558");
			
			cDao.saveAll(List.of(c1,c2,c3,c4,c5));
			
			Empleado e1 = new Empleado("480189674R", "Jorje", "Gutierrez", "Calle Segovia, 12 28020 Madrid", "jorje.gutierrez@immoservices.com", "658794588", true);
			Empleado e2 = new Empleado("18455970N", "Maria", "Fernandez", "Calle Avila, 8 28023 Madrid", "maria.fernandez@immoservices.com", "645855211", true);
			Empleado e3 = new Empleado("24477460K", "Mario", "Delgado", "Calle Almeria, 7 28027 Madrid", "mario.delgado@immoservices.com", "646859047", true);
			Empleado e4 = new Empleado("16287440P", "Miguel", "Casado", "Calle Luis Badia, 3 28002 Madrid", "miguel.casado@immoservices.com", "678998411", true);
			Empleado e5 = new Empleado("25477486L", "Sonia", "Perez", "Calle Islas Baleares, 4 28028 Madrid", "sonia.perez@immoservices.com", "6886958725", false);
			
			eDao.saveAll(List.of(e1,e2,e3,e4,e5));

			Inmueble i1 = new Inmueble("Primero sin ascensor", "Calle de Fernan, 11 28014", "Madrid", "Piso", 2, true, c4, e1, 200000.0, 80.6);
			Inmueble i2 = new Inmueble("Duplx adosado 3 plantas", "Calle Santa Mónica, 14 04722", "Almeria", "Dupex", 3, true, c5, e2, 150000.0, 98.00);
			Inmueble i3 = new Inmueble("Duplex 2 plantas", "Calle Fenix,12 04720", "Almeria", "Duplex", 2, true, c5, e2, 145500.0, 79.00);
			Inmueble i4 = new Inmueble("Segundo con ascensor", "Calle de Nicaragua, 14 08013", "Barcelona", "Piso", 2, true, c4, e3, 280000.0, 67.00);	
			Inmueble i5 = new Inmueble("Tercero con ascensor", "Calle Parador del sol 12, 28037", "Madrid", "Piso", 1, true, c5, e1, 230000.0, 150.00);
			Inmueble i6 = new Inmueble("Duplex 2 plantas", "Calle de la Higueras, 4 04727", "Almeria", "Piso", 3, false, c2, e2, 135000.0, 80.00);	
			
			iDao.saveAll(List.of(i1,i2,i3,i4,i5,i6));			
			
			Demanda d1 = new Demanda("Piso centrico con ascensor", "Madrid", 2, "Piso", c1, true);
			Demanda d2 = new Demanda("Casa de pueblo", "Almeria", 2, "Duplex", c2, true);
			Demanda d3 = new Demanda("Duplex grande", "Barcelona", 5, "Duplex", c3, true);
			
			dDao.saveAll(List.of(d1,d2,d3));
			
			Transaccion t1 = new Transaccion( "Genial", i1, d1, e1);
			Transaccion t2 = new Transaccion( "No problema", i2, d2, e2);			
			Transaccion t3 = new Transaccion( "Otra transaccion", i3, d2, e3);
			Transaccion t4 = new Transaccion( "Cliente satisfecho", i4, d3, e3);
			Transaccion t5 = new Transaccion( "Perfecto", i5, d1, e1);
			
			tDao.saveAll(List.of(t1,t2,t3,t4,t5));
			
			String fechaString1 = "24/05/2022";
			String fechaString2 = "18/11/2023";			
			String fechaString3 = "11/06/2023";
			String fechaString4 = "03/08/2023";
			String fechaString5 = "03/10/2023";
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Publicacion p1 = new Publicacion(i1, sdf.parse(fechaString1).toInstant(), 2.55);
			Publicacion p2 = new Publicacion(i2, sdf.parse(fechaString2).toInstant(), 2.78);
			Publicacion p3 = new Publicacion(i3, sdf.parse(fechaString3).toInstant(), 2.32);
			Publicacion p4 = new Publicacion(i4, sdf.parse(fechaString4).toInstant(), 2.71);
			Publicacion p5 = new Publicacion(i5, sdf.parse(fechaString5).toInstant(), 2.05);
			
			pDao.saveAll(List.of(p1,p2,p3,p4,p5));


		};
		
	}


}





package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = {"service","dao","controller"})
@EnableJpaRepositories(basePackages = {"dao"})
@EntityScan(basePackages = {"model"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/* Activa la libreria Ribbon para acceder al servicio utilizando eureka*/
	@LoadBalanced
	@Bean	
	public RestTemplate crearTemplate() {
		return new RestTemplate();
	}

}

//GET: http://localhost:10000/reservas y de aquí copiamos una para ponerla en el body
//Tenemos que arrancar tanto reservas como vuelos
//POST: http://localhost:10000/reserva/3 (VAMOS A QUERER 3 PLAZAS, HAY 5 DISPONIBLES. PODEMOS VERLO) y en el body copiamos una de ellas (raw JSON)
//DNI: 99999, HOTEL: 2, NOMBRE: PERSONA RESERVADA, VUELO:1. LANZAMOS y comprobamos en bbdd las reservas
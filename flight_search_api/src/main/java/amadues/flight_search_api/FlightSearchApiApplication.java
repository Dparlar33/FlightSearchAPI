package amadues.flight_search_api;

import amadues.flight_search_api.business.rules.FlightBusinessRules;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FlightSearchApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightSearchApiApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

	@Bean
	public FlightBusinessRules getFlightBusinessRules(){return new FlightBusinessRules();}
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}

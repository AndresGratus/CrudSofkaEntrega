package co.com.sofka.crud.andres.sofkacrud2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Sofkacrud2Application {

	public static void main(String[] args) {
		SpringApplication.run(Sofkacrud2Application.class, args);
	}


	//Agre4gamos el un bean

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/api/todos").allowedOrigins("http://localhost:3000");
			}
		};
	}
}

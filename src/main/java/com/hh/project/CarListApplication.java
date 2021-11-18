package com.hh.project;

import org.slf4j.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hh.project.domain.*;

@SpringBootApplication
public class CarListApplication 
{
	private static final Logger log = LoggerFactory.getLogger(CarListApplication.class);

	public static void main(String[] args) 
	{
		SpringApplication.run(CarListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner carDemo(CarRepository carRepo, CategoryRepository catRepo)
	{
		return (args) -> 
		{
			log.info("save a couple of cars");
			catRepo.save(new Category("Wagon"));
			catRepo.save(new Category("Sedan"));
			catRepo.save(new Category("Van"));
			catRepo.save(new Category("Other"));
			
			carRepo.save(new Car("Mercedes", "AMG", "Diesel", "Automatic", "100 000€", "10 000 km", "2018", catRepo.findByName("Other").get(0)));
			carRepo.save(new Car("Nissan", "GTR", "Bensin", "Manual", "45 000€", "50 000 km", "2016", catRepo.findByName("Other").get(0)));
			
			log.info("fetch all cars");
			for (Car car : carRepo.findAll())
			{
				log.info(car.toString());
			}
		};
	}
}

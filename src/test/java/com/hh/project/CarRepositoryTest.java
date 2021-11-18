package com.hh.project;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;

import com.hh.project.domain.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CarRepositoryTest 
{
    @Autowired
    private CarRepository repository;

    @Test
    public void findByTitleShouldReturnCar()
    {
        List<Car> cars = repository.findByMake("Mercedes");
        
        assertThat(cars).hasSize(1);
        assertThat(cars.get(0).getMake()).isEqualTo("Mercedes");
    }
    
    @Test
    public void createNewCar() 
    {    	    	
    	Car car = new Car("Toyota", "Corolla", "Hybrid", "Automatic", "15 000€", "74 500 km", "2016", new Category("Category"));
    	repository.save(car);
    	assertThat(car.getId()).isNotNull();
    }    

	
}

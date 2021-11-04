package com.hh.project.domain;

import java.util.*;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long>
{
    List<Car> findByMake(String make);   
}
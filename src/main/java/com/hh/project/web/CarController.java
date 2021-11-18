package com.hh.project.web;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hh.project.domain.*;

@Controller
public class CarController
{
	@Autowired
	private CarRepository carRepo; 
	
	@Autowired
	private CategoryRepository catRepo; 
	
	// Show all cars
    @RequestMapping(value= {"/", "/carlist"})
    public String carlist(Model model)
    {	
        model.addAttribute("car", carRepo.findAll());
        return "carlist";
    }
    
    // Get all cars
    @RequestMapping(value="/cars", method = RequestMethod.GET)
    public @ResponseBody List<Car> CarListRest()
    {	
        return (List<Car>) carRepo.findAll();
    }    

	// Get car by id
    @RequestMapping(value="/car/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Car> findCarRest(@PathVariable("id") Long carId)
    {	
    	return carRepo.findById(carId);
    }    

    // Add car
    @RequestMapping(value = "/add")
    public String addCar(Model model)
    {
    	model.addAttribute("car", new Car());
    	model.addAttribute("categories", catRepo.findAll());
        return "addcar";
    }     

    // Save car
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Car car)
    {
        carRepo.save(car);
        return "redirect:carlist";
    }    

    // Delete car
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCar(@PathVariable("id") Long carId, Model model)
    {
    	carRepo.deleteById(carId);
        return "redirect:../carlist";
    }  
    
    // Edit car
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editCar(@PathVariable("id") Long carId, Model model)
    {
    	model.addAttribute("car", carRepo.findById(carId));
    	model.addAttribute("categories", catRepo.findAll());
    	return "editcar";
    }

}

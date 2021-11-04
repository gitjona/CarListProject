package com.hh.project.domain;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category 
{
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryId;
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Car> cars;
	
	public Category() {}
	
	public Category(String name)
	{
		super();
		this.name = name;
	}
	
	public Long getCategoryId()
	{
		return categoryId;
	}
	
	public void setCategoryId(Long categoryId)
	{
		this.categoryId = categoryId;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public List<Car> getCars()
	{
		return cars;
	}

	public void setCars(List<Car> cars)
	{
		this.cars = cars;
	}

	@Override
	public String toString()
	{
		return "Category [categoryId=" + categoryId + ", name=" + name + "]";
	}
}

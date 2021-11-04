package com.hh.project.domain;

import javax.persistence.*;

@Entity
public class Car
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String make;
    private String model;
    private String powerType;
    private String gearbox;
    private String price;
    private String kilometers;
    private String year;
    
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Car() {}

	public Car(String make, String model, String powerType, String gearbox, String price, String kilometers, String year, Category category) 
	{
		super();
		this.make = make;
		this.model = model;
		this.powerType = powerType;
		this.gearbox = gearbox;
		this.price = price;
		this.kilometers = kilometers;
		this.year = year;
		this.category = category;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getMake()
	{
		return make;
	}

	public void setMake(String make)
	{
		this.make = make;
	}
	
	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public String getPowerType()
	{
		return powerType;
	}

	public void setPowerType(String powerType)
	{
		this.powerType = powerType;
	}

	public String getGearbox()
	{
		return gearbox;
	}

	public void setGearbox(String gearbox)
	{
		this.gearbox = gearbox;
	}
	
	public String getPrice()
	{
		return price;
	}

	public void setPrice(String price)
	{
		this.price = price;
	}
	
	public String getKilometers()
	{
		return kilometers;
	}

	public void setKilometers(String kilometers)
	{
		this.kilometers = kilometers;
	}
	
	public String getYear()
	{
		return year;
	}

	public void setYear(String year)
	{
		this.year = year;
	}
	
	public Category getCategory()
	{
		return category;
	}

	public void setCategory(Category category)
	{
		this.category = category;
	}

	@Override
	public String toString()
	{
		if (this.category != null)
			return "Car [id=" + id + ", make=" + make + ", model=" + model + ", powerType=" + powerType + ", gearbox=" + gearbox + ", price=" + price + ", year=" + year + ",  category =" + this.getCategory() + "]";
		else
			return "Car [id=" + id + ", make=" + make + ", model=" + model + ", powerType=" + powerType + ", gearbox=" + gearbox + ", price=" + price + ", year=" + year + "]";
	}
}

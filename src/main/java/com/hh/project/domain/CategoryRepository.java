package com.hh.project.domain;

import java.util.*;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>
{
	List<Category> findByName(String name);
}

package yummypizza.repo;

import org.springframework.data.repository.CrudRepository;

import yummypizza.model.Pizza;

public interface PizzaList extends CrudRepository<Pizza, Integer> {
	
}
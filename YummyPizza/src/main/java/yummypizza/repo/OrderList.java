package yummypizza.repo;



import org.springframework.data.repository.CrudRepository;

import yummypizza.model.Order2;

public interface OrderList extends CrudRepository<Order2, Integer> {
	
}

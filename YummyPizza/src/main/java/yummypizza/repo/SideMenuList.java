package yummypizza.repo;

import org.springframework.data.repository.CrudRepository;

import yummypizza.model.SideMenu;

public interface SideMenuList extends CrudRepository<SideMenu, Integer> {
	
}
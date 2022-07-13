package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Villagers;

public interface VillagerDAOInterface {

	//insert new villager
	boolean insertVillager(Villagers villager);
	
	//get all villagers
	ArrayList<Villagers> getVillagers();
	
	//delete a villager
	public void deleteVillager(int id);
	
	//update villager's name
	boolean updateVillagerName(String newName, String oldName);
	
	

}
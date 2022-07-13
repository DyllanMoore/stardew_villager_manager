package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Villagers;

public interface VillagerDAOInterface {

	//insert new villager
	void insertVillager(Villagers villager_name, Villagers villager_birthday, int gender_id, int marriage_candidacy_id, int address_id, int career_id, int movie_id);
	
	//get all villagers
	ArrayList<Villagers> getVillagers();
	
	//delete a villager
	public void deleteVillager(int id);
	
	//update villager's name
	boolean updateVillagerName(String newName, int id);
	
	

}
package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.daos.VillagerDAO;
import com.revature.models.Villagers;

import io.javalin.http.Handler;

public class VillagerController {
	
	VillagerDAO vDAO = new VillagerDAO();
	
	
	
	public Handler getVillagersHandler = (ctx) -> {
		ArrayList<Villagers> villagers = vDAO.getVillagers();
		Gson gson = new Gson();
		String JSONvillagers = gson.toJson(villagers);
		ctx.result(JSONvillagers);
		ctx.status(200);
	};
	
	public Handler deleteVillagerHandler = (ctx) -> {
		int villagerToDelete = Integer.valueOf(ctx.pathParam("villager_id"));
		vDAO.deleteVillager(villagerToDelete);
		
		ctx.result("A villager has been removed from Stardew Valley.");
		ctx.status(200);
		
	};
	
	public Handler updateVillagerHandler = (ctx) -> {
		int id = Integer.parseInt(ctx.body());
		String newName = ctx.pathParam("new_name");
		
		
		if(vDAO.updateVillagerName(newName, id)) {
			ctx.status(202);
		} else {
			ctx.status(406);
		}
	};

}
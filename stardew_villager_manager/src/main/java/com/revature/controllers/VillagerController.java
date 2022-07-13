package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.daos.VillagerDAO;
import com.revature.models.Villagers;

import io.javalin.http.Handler;

public class VillagerController {
	
	VillagerDAO vDAO = new VillagerDAO();
	
	
	
	public Handler getVillagersHandler = (ctx) -> {
		if(AuthController.ses != null) {
			ArrayList<Villagers> villagers = vDAO.getVillagers();
			Gson gson = new Gson();
			String JSONvillagers = gson.toJson(villagers);
			ctx.result(JSONvillagers);
			ctx.status(200);
		} else {
			ctx.result("You are not logged in");
			ctx.status(401);
		}
	};
	
	public Handler deleteVillagerHandler = (ctx) -> {
		if(AuthController.ses != null) {
			int villagerToDelete = Integer.valueOf(ctx.pathParam("villager_id"));
			vDAO.deleteVillager(villagerToDelete);
		
			ctx.result("A villager has been removed from Stardew Valley.");
			ctx.status(200);
		} else {
			ctx.result("You are not logged in");
			ctx.status(401);
		}
		
	};
	
	public Handler updateVillagerHandler = (ctx) -> {
		if(AuthController.ses != null) {
			String oldName = ctx.pathParam("old_name");
			String newName = ctx.body();
		
		
			if(vDAO.updateVillagerName(newName, oldName)) {
				ctx.status(202);
			} else {
				ctx.status(406);
			}
		} else {
			ctx.result("You are not logged in");
			ctx.status(401);
		}
	};

	public Handler insertVillagerHandler = (ctx) -> {
		if(AuthController.ses != null) {
			String body = ctx.body();
			Gson gson = new Gson();
			Villagers newVillager = gson.fromJson(body, Villagers.class);
		
			if(vDAO.insertVillager(newVillager)) {
				ctx.status(202);
			} else {
				ctx.status(406);
			}
		} else {
			ctx.result("You are not logged in");
			ctx.status(401);
		}
	};
}
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

}

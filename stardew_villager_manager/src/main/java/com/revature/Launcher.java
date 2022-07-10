package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.VillagerController;
import com.revature.daos.AddressesDAO;
import com.revature.daos.CareersDAO;
import com.revature.daos.GendersDAO;
import com.revature.daos.MarriageCandidacyDAO;
import com.revature.daos.MovieDAO;
import com.revature.daos.VillagerDAO;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {

		VillagerDAO vDAO = new VillagerDAO();
		GendersDAO gDAO = new GendersDAO();
		MarriageCandidacyDAO mcDAO = new MarriageCandidacyDAO();
		AddressesDAO aDAO = new AddressesDAO();
		CareersDAO cDAO = new CareersDAO();
		MovieDAO mDAO = new MovieDAO();
		
		System.out.println(vDAO.getVillagers());
		
		
		System.out.println("=========Stardew Valley Villager Management System==========");
		
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("Connection successful");
		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		
		
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins();
				}
				
				).start(3000);
		
		VillagerController vc = new VillagerController();
		
		app.get("/stardew_villagers", vc.getVillagersHandler);
	

	}
	


}
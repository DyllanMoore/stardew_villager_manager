package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Addresses;
import com.revature.models.Careers;
import com.revature.models.Genders;
import com.revature.models.MarriageCandidacy;
import com.revature.models.Movies;
import com.revature.models.Villagers;
import com.revature.utils.ConnectionUtil;

public class VillagerDAO implements VillagerDAOInterface {

	@Override
	public boolean insertVillager(Villagers villager) {

		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "insert into stardew_villagers (villager_name, villager_birthday, villager_gender_fk, "
					+ "villager_marriage_candidacy_fk, villager_address_fk, villager_career_fk, villager_favorite_movie_fk)"
					+ "values (?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, villager.getVillager_name());
			ps.setString(2, villager.getVillager_birthday());
			ps.setInt(3, villager.getVillager_gender_fk());
			ps.setInt(4, villager.getVillager_marriage_candidacy_fk());
			ps.setInt(5, villager.getVillager_address_fk());
			ps.setInt(6, villager.getVillager_career_fk());
			ps.setInt(7, villager.getVillager_favorite_movie_fk());
			
			ps.executeUpdate();
			
			System.out.println("Villager " + villager.getVillager_name() + " was added!");
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Insert Villager Failed");
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public ArrayList<Villagers> getVillagers() {

		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from stardew_villagers;";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			ArrayList<Villagers> villagerList = new ArrayList<>();
			
			while(rs.next()) {
				Villagers v = new Villagers(
						rs.getInt("villager_id"),
						rs.getString("villager_name"),
						rs.getString("villager_birthday"),
						null, null, null, null, null
						);
				
				int genderFK = rs.getInt("villager_gender_fk");
				GendersDAO gDAO = new GendersDAO();
				Genders g = gDAO.getGenderById(genderFK);
				v.setGender(g);
				
				int marriageCandidacyFK = rs.getInt("villager_marriage_candidacy_fk");
				MarriageCandidacyDAO mcDAO = new MarriageCandidacyDAO();
				MarriageCandidacy mc = mcDAO.getMarriageCandidacyById(marriageCandidacyFK);
				v.setMarriagecandidacy(mc);
				
				int addressFK = rs.getInt("villager_address_fk");
				AddressesDAO aDAO = new AddressesDAO();
				Addresses a = aDAO.getAddressById(addressFK);
				v.setAddress(a);
				
				int careerFK = rs.getInt("villager_career_fk");
				CareersDAO cDAO = new CareersDAO();
				Careers c = cDAO.getCareerById(careerFK);
				v.setCareer(c);
				
				int movieFK = rs.getInt("villager_favorite_movie_fk");
				MovieDAO mDAO = new MovieDAO();
				Movies m = mDAO.getMovieById(movieFK);
				v.setMovie(m);
				
				villagerList.add(v);
			}
			
			return villagerList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong getting villagers");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void deleteVillager(int id) {

		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "delete from stardew_villagers where villager_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("A villager was removed from Stardew Valley.");
		} catch(SQLException e) {
			System.out.println("Removing the villager was unsuccessful.");
			e.printStackTrace();
		}
	}

	
	@Override
	public boolean updateVillagerName(String newName, String oldName) {

		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "update stardew_villagers set villager_name = ? where villager_name = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setString(2, oldName);
			ps.executeUpdate();
			System.out.println( oldName + "'s name has been changed to " + newName);
			

			return true;
		} catch (SQLException e) {
			System.out.println("Failed to update villager's name.");
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}
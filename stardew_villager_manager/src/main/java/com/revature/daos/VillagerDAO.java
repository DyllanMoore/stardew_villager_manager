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
	public void insertVillager(Villagers villager_name, Villagers villager_birthday, int gender_id,
			int marriage_candidacy_id, int address_id, int career_id, int movie_id) {

		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "insert into villagers (villager_name, villager_birthday, villager_gender_fk, "
					+ "villager_marriage_candidcay_fk, villager_address_fk, villager_career_fk, villager_movie_fk)"
					+ "values (?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, villager_name.getVillager_name());
			ps.setString(2, villager_birthday.getVillager_birthday());
			ps.setInt(3, gender_id);
			ps.setInt(4, marriage_candidacy_id);
			ps.setInt(5, address_id);
			ps.setInt(6, career_id);
			ps.setInt(7, movie_id);
			
			ps.executeUpdate();
			
			System.out.println("Village " + villager_name.getVillager_name() + " was added!");
			
		} catch (SQLException e) {
			System.out.println("Insert Villager Failed");
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Villagers> getVillagers() {

		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from villagers;";
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
				
				int genderFK = rs.getInt("gender_id");
				GendersDAO gDAO = new GendersDAO();
				Genders g = gDAO.getGenderById(genderFK);
				v.setGender(g);
				
				int marriageCandidacyFK = rs.getInt("marriage_candidacy_id");
				MarriageCandidacyDAO mcDAO = new MarriageCandidacyDAO();
				MarriageCandidacy mc = mcDAO.getMarriageCandidacyById(marriageCandidacyFK);
				v.setMarriagecandidacy(mc);
				
				int addressFK = rs.getInt("address_id");
				AddressesDAO aDAO = new AddressesDAO();
				Addresses a = aDAO.getAddressById(addressFK);
				v.setAddress(a);
				
				int careerFK = rs.getInt("career_id");
				CareersDAO cDAO = new CareersDAO();
				Careers c = cDAO.getCareerById(careerFK);
				v.setCareer(c);
				
				int movieFK = rs.getInt("movie_id");
				MovieDAO mDAO = new MovieDAO();
				Movies m = mDAO.getMovieById(movieFK);
				v.setMovie(m);
				
				villagerList.add(v);
			}
			
		} catch (SQLException e) {
			System.out.println("Something went wrong getting villagers");
			e.printStackTrace();
		}
		
		return null;
	}

}

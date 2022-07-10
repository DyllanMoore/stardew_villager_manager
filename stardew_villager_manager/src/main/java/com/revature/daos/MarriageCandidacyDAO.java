package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.MarriageCandidacy;
import com.revature.utils.ConnectionUtil;

public class MarriageCandidacyDAO implements MarriageCandidacyDAOInterface{

	@Override
	public MarriageCandidacy getMarriageCandidacyById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from marriage_candidacy where marriage_candidacy_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				MarriageCandidacy marriageCandidacy = new MarriageCandidacy(
						rs.getInt("address_id"),
						rs.getString("address")
						);
				return marriageCandidacy;
			}
		} catch (SQLException e) {
			System.out.println("Get Marriage Candidacy Failed");
			e.printStackTrace();
		}
		
		return null;
	}

}

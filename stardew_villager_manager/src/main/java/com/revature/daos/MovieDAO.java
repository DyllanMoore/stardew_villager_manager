package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Movies;
import com.revature.utils.ConnectionUtil;

public class MovieDAO implements MovieDAOInterface{

	@Override
	public Movies getMovieById(int id) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from village_movies where movie_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Movies movie = new Movies(
						rs.getInt("movie_id"),
						rs.getString("movie")
						);
				return movie;
			}
		} catch (SQLException e) {
			System.out.println("Get Movie Failed");
			e.printStackTrace();
		}
		
		return null;
	}

}

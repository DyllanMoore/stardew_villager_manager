package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Addresses;
import com.revature.utils.ConnectionUtil;

public class AddressesDAO implements AddressesDAOInterface {
	
	@Override 
	public Addresses getAddressById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from villager_addresses where address_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Addresses address = new Addresses(
						rs.getInt("address_id"),
						rs.getString("address")
						);
				return address;
			}
		} catch (SQLException e) {
			System.out.println("Get Address Failed");
			e.printStackTrace();
		}
		return null;
	}
	

}

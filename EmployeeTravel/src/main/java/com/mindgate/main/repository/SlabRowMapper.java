package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Slab;

public class SlabRowMapper implements RowMapper<Slab> {

	@Override
	public Slab mapRow(ResultSet rs, int rowNum) throws SQLException {
		int slabId=rs.getInt("SLAB_ID");
		String role=rs.getString("ROLE");
		String internationalTravel=rs.getString("INTERNATIONAL_TRAVEL");
		int slab_Amount=rs.getInt("SLAB_AMMOUNT");
		String internationalForex=rs.getString("INTERNATIONAL_FOREX");
		
		Slab slab=new Slab(slabId,role,internationalTravel,slab_Amount,internationalForex);
		return slab;
	}

}

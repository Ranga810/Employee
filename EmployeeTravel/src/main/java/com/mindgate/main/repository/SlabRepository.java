package com.mindgate.main.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Slab;

@Repository
public class SlabRepository implements SlabRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SELECT_ALL_SLAB = "select * from slab";
	private final static String SELECT_ONE_SLAB = "select * from slab where SLAB_ID=?";
	private final static String INSERT_NEW_SLAB = "insert into slab values(SLAB_ID.nextVal,?,?,?,?)";
	private final static String UPDATE_EXISTING_SLAB = "update slab set ROLE=?,INTERNATIONAL_TRAVEL=?,SLAB_AMMOUNT=?,INTERNATIONAL_FOREX=? where SLAB_ID=?";
	private final static String DELETE_EXISTING_SLAB = "delete from slab where SLAB_ID=?";;

	private List<Slab> employeeList = new ArrayList<Slab>();

	public void testConnection() {
		if (jdbcTemplate != null) {
			System.out.println("Connected Successfully !!");
		} else {
			System.out.println(" Not Connected !!");
		}
	}

	@Override
	public boolean addNewSlab(Slab slab) {
		Object parameters[] = { slab.getRole(), slab.getInternationalTravel(), slab.getSlab_Amount(),
				slab.getInternationalForex() };
		int rowcount = jdbcTemplate.update(INSERT_NEW_SLAB, parameters);
		if (rowcount > 0) {
			return true;
		}
		return false;
	}

	@Override
	 public Slab updateSlab(Slab slab){
    	Object[] parameters={slab.getRole(),slab.getInternationalTravel(),slab.getSlab_Amount(),slab.getInternationalForex(),slab.getSlabId()};
    	int rowCount = jdbcTemplate.update(UPDATE_EXISTING_SLAB, parameters);
    	if(rowCount>0){
    		return getSlabBySlabId(slab.getSlabId());
    	}
    	return null;
    }

	@Override
	public boolean deleteSlab(int SLAB_ID) {
		int rowCount=jdbcTemplate.update(DELETE_EXISTING_SLAB, SLAB_ID);
		if(rowCount>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Slab getSlabBySlabId(int SLAB_ID) {
		SlabRowMapper slabRowMapper = new SlabRowMapper();
		Slab slab = jdbcTemplate.queryForObject(SELECT_ONE_SLAB, slabRowMapper, SLAB_ID);
		return slab;

	}

	@Override
	public List<Slab> getAllSlab() {
		SlabRowMapper slabRowMapper = new SlabRowMapper();
		return jdbcTemplate.query(SELECT_ALL_SLAB, slabRowMapper);
	}

}

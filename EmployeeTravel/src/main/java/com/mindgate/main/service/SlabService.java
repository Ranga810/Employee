package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Slab;
import com.mindgate.main.repository.SlabRepositoryInterface;

@Service
@Scope("prototype")
public class SlabService implements SlabServiceInterface{
	
	@Autowired
	private SlabRepositoryInterface slabRepositoryInterface;

	@Override
	public boolean addNewSlab(Slab slab) {
		return slabRepositoryInterface.addNewSlab(slab);
	}

	@Override
	public Slab updateSlab(Slab slab) {
		return slabRepositoryInterface.updateSlab(slab);}

	@Override

	public boolean deleteSlab(int SLAB_ID) {
		
		return slabRepositoryInterface.deleteSlab(SLAB_ID);
	}

	@Override
	public Slab getSlabBySlabId(int slabId) {
		return slabRepositoryInterface.getSlabBySlabId(slabId);
	}

	@Override
	public List<Slab> getAllSlab() {
		return slabRepositoryInterface.getAllSlab();
	}

	
}

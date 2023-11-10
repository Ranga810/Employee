package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.Slab;

public interface SlabServiceInterface {
	public boolean addNewSlab(Slab slab);

	public Slab updateSlab(Slab slab);

	public boolean deleteSlab(int slabId);

	public Slab getSlabBySlabId(int slabId);

	public List<Slab> getAllSlab();
}

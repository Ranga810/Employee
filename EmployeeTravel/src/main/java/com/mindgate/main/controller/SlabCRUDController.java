package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Slab;
import com.mindgate.main.service.SlabServiceInterface;

@RestController
@RequestMapping("slabapi")
public class SlabCRUDController {
	
	@Autowired
	private SlabServiceInterface slabServiceInterface;
	
	//http://localhost:8088/slabapi/slab
		@RequestMapping(value="slab", method=RequestMethod.GET)
		public List<Slab> getAllSlab(){
			return slabServiceInterface.getAllSlab();
		}
		
		//http://localhost:8088/slabapi/getoneslab/{SLAB_ID}
		@RequestMapping(value="getoneslab/{SLAB_ID}",method=RequestMethod.GET)
		public Slab getSlabBySlabId(@PathVariable int SLAB_ID) {
			Slab slab=slabServiceInterface.getSlabBySlabId(SLAB_ID);
			return slab;
		}
		
		//http://localhost:8088/slabapi/addnewslab
		@RequestMapping(value="addnewslab",method=RequestMethod.POST)
		public boolean addNewSlab(@RequestBody Slab slab) {
			return slabServiceInterface.addNewSlab(slab);
		}
		
		//http://localhost:8088/slabapi/updateslab
		@RequestMapping(value="updateslab", method=RequestMethod.PUT)
	public Slab updateEmployee(@RequestBody Slab slab) {
		return slabServiceInterface.updateSlab(slab);
	}
		
		//http://localhost:8088/slabapi/deleteslab/{SLAB_ID}
				@RequestMapping(value="deleteslab/{SLAB_ID}", method=RequestMethod.DELETE)
			public boolean deleteSlab(@PathVariable int SLAB_ID) {
				return slabServiceInterface.deleteSlab(SLAB_ID);
			}
}

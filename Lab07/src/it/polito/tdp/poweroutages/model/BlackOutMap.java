package it.polito.tdp.poweroutages.model;

import java.util.*;

public class BlackOutMap {
	
	private Map<Integer, Blackout> map;

	public BlackOutMap() {
		map = new HashMap<Integer, Blackout>();
	} 
	
	public Blackout get(int id) {
		return map.get(id);
	}
	
	public Blackout get(Blackout blackout) {
		Blackout old = map.get(blackout.getId());
		if (old == null) {
			map.put(blackout.getId(), blackout);
			return blackout;
		}
		return old;
	}
	
	public void put(Integer id, Blackout blackout) {
		map.put(id, blackout);
	}
	

}

package it.polito.tdp.poweroutages.model;

import java.util.*;

public class NercIdMap {
	
	private Map<Integer, Nerc> map;

	public NercIdMap() {
		map = new HashMap<Integer, Nerc>();
	}
	
	public Nerc get(int id) {
		return map.get(id);
	}
	
	public Nerc get(Nerc nerc) {
		Nerc old = map.get(nerc.getId());
		if (old == null) {
			map.put(nerc.getId(), nerc);
			return nerc;
		}
		return old;
	}
	
	public void put(Integer id, Nerc nerc) {
		map.put(id, nerc);
	}

}

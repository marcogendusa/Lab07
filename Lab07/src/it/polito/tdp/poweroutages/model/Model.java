package it.polito.tdp.poweroutages.model;

import java.util.*;

import it.polito.tdp.poweroutages.db.PowerOutageDAO;

public class Model {

	private PowerOutageDAO podao;
	
	private NercIdMap nercmap;
	private List<Nerc> nerc;
	
	private BlackOutMap blackoutmap;
	
	private List<Blackout> best;
		
	public Model() {
		podao = new PowerOutageDAO();
		
		nercmap = new NercIdMap();
		nerc = podao.getNercList(nercmap);
		
		blackoutmap = new BlackOutMap();
	}
	
	public List<Blackout> getAllBalckoutsFromNerc(Nerc n) {
		if(n != null) {
			return podao.getBlackoutList(n, blackoutmap);
		}
		
		return new ArrayList<Blackout>();
	}
	
	public int calcolaMinutiBlackOut(Date d1, Date d2) {
		return (int) ((d1.getTime()-d2.getTime()) / (1000*60));
	}
	
	
	public List<Blackout> calcolaSequenza(Nerc n, int anni, int ore) {
		this.best = new ArrayList<Blackout>();
		List<Blackout> parziale = new ArrayList<Blackout>();
		
		cerca(parziale, 0);
		return best;
	}
	
	public void cerca(List<Blackout> parziale, int step) {
		
	}
	
	

}

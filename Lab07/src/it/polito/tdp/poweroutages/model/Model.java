package it.polito.tdp.poweroutages.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

import it.polito.tdp.poweroutages.db.PowerOutageDAO;

public class Model {

	private PowerOutageDAO podao;

	private NercIdMap nercmap;
	private List<Nerc> nerc;

	private BlackOutMap blackoutmap;
	private List<Blackout> blackout;

	private List<Blackout> best;

	public Model() {
		podao = new PowerOutageDAO();

		nercmap = new NercIdMap();
		nerc = podao.getNercList(nercmap);

		blackoutmap = new BlackOutMap();
	}

	public List<Blackout> getAllBalckoutsFromNerc(Nerc n) {
		if (n != null) {
			return podao.getBlackoutList(n, blackoutmap);
		}

		return new ArrayList<Blackout>();
	}
	
	public List<Nerc> getAllNerc() {
		return this.nerc;
	}

	public List<Blackout> calcolaSequenza(Nerc n, int anni, int ore) {
		this.best = new ArrayList<Blackout>();
		List<Blackout> parziale = new ArrayList<Blackout>();

		blackout = this.getAllBalckoutsFromNerc(n);

		cerca(parziale, anni, ore);
		return best;
	}

	public void cerca(List<Blackout> parziale, int anni, int ore) {

		// condizione terminazione
		if (this.totPersone(parziale) > this.totPersone(best)) {
			this.best = new ArrayList<Blackout>(parziale);
		}

		for (Blackout prova : blackout) {
			if (!parziale.contains(prova)) {
				parziale.add(prova);

				if (this.parzialeValida(parziale, anni, ore)) {
					cerca(parziale, anni, ore);
				}

				parziale.remove(parziale.size() - 1);
			}
		}

	}

	public boolean parzialeValida(List<Blackout> l, int anni, int ore) {
		
		if (this.calcolaOre(l) > ore) {
			return false;
		}
		
		for (Blackout b1 : l) {
			for (Blackout b2 : l) {
				if (controllaData(b1.getDataFine(), b2.getDataFine()) > anni)
					return false;
			}
		}
		return true;
	}

	public int calcolaOre(List<Blackout> l) {
		int sum = 0;

		for (Blackout b : l)
			sum += b.getDurata();

		return sum;
	}

	public int controllaData(LocalDateTime d1, LocalDateTime d2) {
		return Math.abs(d1.getYear() - d2.getYear());
	}

	public int totPersone(List<Blackout> l) {
		int sum = 0;
		for (Blackout b : l) {
			sum += b.getNumeroPersone();
		}
		return sum;
	}

}

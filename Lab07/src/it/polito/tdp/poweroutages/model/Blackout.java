package it.polito.tdp.poweroutages.model;

import java.sql.Date;

public class Blackout {
	
	
	private int id, numeroPersone;
	private Date dataInizio, dataFine;
	
	public Blackout(int id, int numeroPersone, Date dataInizio, Date dataFine) {
		this.id = id;
		this.numeroPersone = numeroPersone;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	public int getId() {
		return id;
	}

	public int getNumeroPersone() {
		return numeroPersone;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	

}

package it.polito.tdp.poweroutages.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Blackout {
	
	
	private int id, numeroPersone;
	private LocalDateTime dataInizio, dataFine;
	private long durata;
	
	public Blackout(int id, int numeroPersone, LocalDateTime dataInizio, LocalDateTime dataFine) {
		this.id = id;
		this.numeroPersone = numeroPersone;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		
		this.durata = Duration.between(dataInizio, dataFine).toHours();
	}

	public int getId() {
		return id;
	}

	public int getNumeroPersone() {
		return numeroPersone;
	}

	public LocalDateTime getDataInizio() {
		return dataInizio;
	}

	public LocalDateTime getDataFine() {
		return dataFine;
	}

	public long getDurata() {
		return durata;
	}

	public String toString() {
		return ""+dataInizio + " "
				+ dataFine + " " + durata + " " + numeroPersone;
	}
	

	
	
	

}

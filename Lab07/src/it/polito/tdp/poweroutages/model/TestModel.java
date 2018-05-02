package it.polito.tdp.poweroutages.model;

import it.polito.tdp.poweroutages.db.PowerOutageDAO;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		PowerOutageDAO po = new PowerOutageDAO();
		NercIdMap nercmap = new NercIdMap();
		//System.out.println(po.getNercList(nercmap));
		
		System.out.println(model.getAllNerc());

		
		BlackOutMap blackoutmap = new BlackOutMap();
		//System.out.println(po.getBlackoutList(po.getNercList(nercmap).get(1), blackoutmap));
		
		//System.out.println(model.calcolaSequenza(po.getNercList(nercmap).get(3), 4, 100));


		
	}
}

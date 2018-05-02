package it.polito.tdp.poweroutages.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.model.BlackOutMap;
import it.polito.tdp.poweroutages.model.Blackout;
import it.polito.tdp.poweroutages.model.Nerc;
import it.polito.tdp.poweroutages.model.NercIdMap;

public class PowerOutageDAO {

	public List<Nerc> getNercList(NercIdMap nercmap) {

		String sql = "SELECT id, value FROM nerc";
		List<Nerc> nercList = new ArrayList<Nerc>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Nerc n = new Nerc(res.getInt("id"), res.getString("value"));
				nercList.add(nercmap.get(n));
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return nercList;
	}

	public List<Blackout> getBlackoutList(Nerc nerc, BlackOutMap blackoutmap) {
		
		String sql = "SELECT id, customers_affected, date_event_began, date_event_finished FROM PowerOutages WHERE nerc_id=?";
		List<Blackout> blackoutList = new ArrayList<Blackout>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, nerc.getId());
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Blackout b = new Blackout(res.getInt("id"), res.getInt("customers_affected"), res.getTimestamp("date_event_began").toLocalDateTime(),
										  res.getTimestamp("date_event_finished").toLocalDateTime());
				blackoutList.add(blackoutmap.get(b));
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return blackoutList;
	}
	

}

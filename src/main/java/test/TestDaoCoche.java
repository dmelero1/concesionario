package test;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoCoche;
import entidad.Coche;

public class TestDaoCoche {
	public static void main(String[] args) {
		testListCoches();
	}
	
	public static void testListCoches() {
		DaoCoche dao = new DaoCoche();
		try {
			ArrayList<Coche>coches=dao.getCoches(0,"null");
			for(Coche c: coches) {
				System.out.println(c.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

package test;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoMarca;
import entidad.Marca;

public class TestDaoMarca {
	public static void main(String[] args) {
		testListMarcas();
	}
	
	public static void testListMarcas() {
		DaoMarca dao = new DaoMarca();
		try {
			ArrayList<Marca>marcas=dao.getMarcas();
			for(Marca m: marcas) {
				System.out.println(m.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void testListNombreMarcas() {
		DaoMarca dao = new DaoMarca();
		try {
			ArrayList<Marca>marcas=dao.getNombreMarcas();
			for(Marca m: marcas) {
				System.out.println(m.getNombre());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

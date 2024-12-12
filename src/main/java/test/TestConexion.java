package test;

import java.sql.Connection;
import java.sql.SQLException;

import conexion.Conexion;

public class TestConexion {
	public static void main(String[] args) {
	    Conexion conexion=new Conexion();
	    try {
			Connection con=conexion.getConexion();
			System.out.println(con.getSchema());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

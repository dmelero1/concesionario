package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import entidad.Marca;

public class DaoMarca {
	public ArrayList<Marca> getMarcas() throws SQLException{
		ResultSet rs=null;
		ArrayList<Marca> lista = new ArrayList<Marca>();
		Connection con  = new Conexion().getConexion();
		Statement st=null;
		try {
		st = con.createStatement();
		String ordenSql;
		ordenSql = "SELECT * FROM MARCA";
	   	rs = st.executeQuery(ordenSql);
		while (rs.next()) {
			Marca marca = new Marca();
			marca.setId(rs.getInt("id"));
			marca.setNombre(rs.getString("nombre"));
			
			lista.add(marca);
		}
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}

		return lista;
	}
	public ArrayList<Marca> getNombreMarcas() throws SQLException{
		ResultSet rs = null;
		ArrayList<Marca> lista = new ArrayList<Marca>();
		Connection con  = new Conexion().getConexion();
		Statement st = null;
		try {
		st = con.createStatement();
		String ordenSql;
		ordenSql = "SELECT NOMBRE FROM MARCA";
	   	rs = st.executeQuery(ordenSql);
		while (rs.next()) {
			Marca marca = new Marca();
			marca.setId(rs.getInt("id"));
			marca.setNombre(rs.getString("nombre"));
			
			lista.add(marca);
		}
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}

		return lista;
	}
	public ArrayList<Marca> getMarcasCoche(int idcoche) throws SQLException{
		ResultSet rs=null;
		ArrayList<Marca> lista = new ArrayList<Marca>();
		Connection con  = new Conexion().getConexion();
		Statement st=null;
		try {
		st = con.createStatement();
		String ordenSql;
		ordenSql = "SELECT * FROM MARCA WHERE ID="+idcoche;

		rs = st.executeQuery(ordenSql);

		while (rs.next()) {
			Marca marca = new Marca();
			marca.setId(rs.getInt("ID"));
			marca.setNombre(rs.getString("NOMBRE"));
			lista.add(marca);
		}
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}

		return lista;
	}
}

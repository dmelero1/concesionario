package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import entidad.Coche;

public class DaoCoche {
	public ArrayList<Coche> getCoches() throws SQLException{
		ArrayList<Coche> lista;
		lista = new ArrayList<Coche>();
		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			st = con.createStatement();
			String ordenSql = "SELECT * FROM COCHE";
			rs = st.executeQuery(ordenSql);
		while (rs.next()) {
			Coche coche = new Coche();
			coche.setId(rs.getInt("id"));
			coche.setMarca(rs.getInt("marca"));
			coche.setFoto(rs.getString("foto"));
			coche.setNombre(rs.getString("nombre"));
			coche.setModelo(rs.getString("modelo"));
			coche.setPrecio(rs.getInt("precio"));
			coche.setPrecioantes(rs.getInt("precioantes"));
			coche.setAnio(rs.getInt("anio"));
			coche.setKm(rs.getInt("km"));
			coche.setCv(rs.getInt("cv"));
			coche.setFav(rs.getInt("fav"));
			coche.setLikes(rs.getInt("likes"));

			
			lista.add(coche);
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
	public ArrayList<Coche> getCoches(int idmarca, String ordenar) throws SQLException{
		ResultSet rs=null;
		ArrayList<Coche> lista = new ArrayList<Coche>();
		Connection con  = new Conexion().getConexion();
		Statement st=null;
		try {
		st = con.createStatement();
		String idmarcatxt = String.valueOf(idmarca);
		if (idmarca ==0) idmarcatxt="%";
		String ordenSql;
		ordenSql = "select c.id, c.marca, c.nombre, c.foto, m.nombre, c.modelo, c.precio, c.precioantes, c.anio, c.km, c.cv, c.fav, c.likes "
	   					+ "from coche c, marca m "
	   					+ "where c.marca=m.id and "
	   					+ "marca like '"+idmarcatxt+"' order by "+ordenar;

		rs = st.executeQuery(ordenSql);

		while (rs.next()) {
			Coche coche = new Coche();
			coche.setId(rs.getInt("id"));
			coche.setMarca(rs.getInt("marca"));
			coche.setFoto(rs.getString("foto"));
			coche.setNombre(rs.getString("nombre"));
			coche.setModelo(rs.getString("modelo"));
			coche.setPrecio(rs.getInt("precio"));
			coche.setPrecioantes(rs.getInt("precioantes"));
			coche.setAnio(rs.getInt("anio"));
			coche.setKm(rs.getInt("km"));
			coche.setCv(rs.getInt("cv"));
			coche.setFav(rs.getInt("fav"));
			coche.setLikes(rs.getInt("likes"));
			
			lista.add(coche);
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
	public void addLike(int idcoche) throws SQLException {
		Connection con  = new Conexion().getConexion();
		Statement st;
		st = con.createStatement();
		String ordenSql;
		ordenSql = "UPDATE COCHE SET LIKES=(SELECT LIKES+1 FROM COCHE WHERE ID="+idcoche+") WHERE ID="+idcoche;
	   	st.executeUpdate(ordenSql);
		
		st.close();
	}
	
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Editorial;
import utilidades.ConexionBD;

public class EditorialDAOJDBC implements EditorialDAO {
	
	private ConexionBD conexion;
	
	

	public EditorialDAOJDBC() {
		conexion = new ConexionBD();
	}

	@Override
	public List<Editorial> getListaEditorial() {
		List<Editorial> lista = new ArrayList<>();
		Connection c = conexion.getConexion();
		Statement consulta = null;
		ResultSet rs=null;
		
		try {
			consulta = c.createStatement();
			rs= consulta.executeQuery("select * from editoriales");
			while(rs.next()) {
				
				int codEditorial = rs.getInt("codEditorial");
				String nombre = rs.getString("nombre");
				int año = rs.getInt("anio");
				
				Editorial editorial = new Editorial(codEditorial, nombre, año);
				lista.add(editorial);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				consulta.close();
				conexion.cerrarConexion();
				
			} catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
			
		}		
		return lista;
	}

	@Override
	public Editorial getEditorial(int codEditorial) {
		Connection c = conexion.getConexion();
		PreparedStatement consulta = null;
		ResultSet rs=null;
		Editorial editorial=null;
		
		try {
			consulta = c.prepareStatement("select * from editoriales"
					+ " where codEditorial=?" );
			consulta.setInt(1, codEditorial);
			rs= consulta.executeQuery();
			if(rs.next()) {
				
				String nombre = rs.getString("nombre");
				int año = rs.getInt("anio");
				
				editorial = new Editorial(codEditorial,nombre, año);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				consulta.close();
				conexion.cerrarConexion();
				
			} catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
			
		}		
		return editorial;
	}

	@Override
	public int insertarEditorial(Editorial editorial) {
		Connection c = conexion.getConexion();
		PreparedStatement consulta = null;
		int num=0;
		
		try {
			consulta = c.prepareStatement("insert into editoriales(nombre,anio) values (?,?)");
			
			consulta.setString(1, editorial.getNombre());
			consulta.setInt(2, editorial.getAño());
			num= consulta.executeUpdate();
			System.out.println("Editorial insertada correctamente");
				
			
			
		} catch (SQLException e) {
			System.out.println("Error insertando editorial");
			e.printStackTrace();
		} finally {
			
			try {
			
				consulta.close();
				conexion.cerrarConexion();
				
			} catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
			
		}		
		return num;
		
	}

	@Override
	public int editarEditorial(Editorial editorial) {
		Connection c = conexion.getConexion();
		PreparedStatement consulta = null;
		int num=0;
		
		try {
			consulta = c.prepareStatement("UPDATE editoriales\r\n"
					+ "SET\r\n"
					+ "nombre = ?,\r\n"
					+ "anio = ?\r\n"
					+ "WHERE codEditorial = ?");
			
			consulta.setString(1, editorial.getNombre());
			consulta.setInt(2, editorial.getAño());
			consulta.setInt(3, editorial.getCodEditorial());
			
			num= consulta.executeUpdate();
			System.out.println("Editorial actualizada correctamente");
				
			
			
		} catch (SQLException e) {
			System.out.println("Error actualizando editorial");
			e.printStackTrace();
		} finally {
			
			try {
			
				consulta.close();
				conexion.cerrarConexion();
				
			} catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
			
		}		
		return num;
	}

	@Override
	public int eliminarEditorial(int codEditorial) {
		Connection c = conexion.getConexion();
		PreparedStatement consulta = null;
		int num=0;
		
		try {
			consulta = c.prepareStatement("delete from editoriales where codEditorial=?");
			
			consulta.setInt(1, codEditorial);
			
			num= consulta.executeUpdate();
			System.out.println("Editorial eliminada correctamente");
				
			
			
		} catch (SQLException e) {
			System.out.println("Error eliminando editorial"+codEditorial);
			e.printStackTrace();
		} finally {
			
			try {
			
				consulta.close();
				conexion.cerrarConexion();
				
			} catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
			
		}		
		return num;
	}

}

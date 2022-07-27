package dao;

import java.util.List;

import modelo.Editorial;

public interface EditorialDAO {

	public List<Editorial> getListaEditorial();
	public Editorial getEditorial(int codEditorial);
	public int insertarEditorial(Editorial editorial);
	public int editarEditorial(Editorial editorial);
	public int eliminarEditorial(int codEditorial);
	
}

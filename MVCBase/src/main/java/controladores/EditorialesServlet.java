package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Editorial;


import java.io.IOException;
import java.util.List;

import dao.EditorialDAO;
import dao.EditorialDAOJDBC;


/**
 * Servlet implementation class EditorialesServlet
 */

public class EditorialesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorialesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		if (opcion ==null || opcion.equals("editoriales")) {
			mostrarEditoriales(request,response);
		}
	
}

private void mostrarEditoriales(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EditorialDAO dao = new EditorialDAOJDBC();
		List<Editorial>lista=dao.getListaEditorial();
		request.setAttribute("listaEditoriales", lista);
		request.getRequestDispatcher("/libros/editoriales.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

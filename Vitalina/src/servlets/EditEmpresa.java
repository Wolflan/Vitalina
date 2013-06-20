package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidade.Empresa;

import DAO.DAOEmpresa;

/**
 * Servlet implementation class EditEmpresa
 */
@WebServlet("/EditEmpresa")
public class EditEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmpresa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Empresa empresa = new Empresa (Integer.parseInt(request.getParameter("id")),request.getParameter("nome"));
		DAOEmpresa daoEmpresa = new DAOEmpresa();
		daoEmpresa.update(empresa);
		
		RequestDispatcher r = request.getRequestDispatcher( "CadEmpresa.jsp" );  
		r.forward( request, response );
	}

}

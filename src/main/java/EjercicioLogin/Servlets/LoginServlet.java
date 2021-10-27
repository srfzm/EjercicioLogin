package EjercicioLogin.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import EjercicioLogin.Utilidades.*;
import EjercicioLogin.DAO.UsuariosDAO;
import EjercicioLogin.Modelos.Usuarios;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String nombre = request.getParameter("user");
		String clave = request.getParameter("psw");
		if(nombre==null || clave==null) {
			response.sendRedirect("login.html");
		} else {
			Session s = HibernateUtil.getSessionFactory().openSession();
			Usuarios us = UsuariosDAO.getUsuarioLogin(s, nombre, clave);
			if(us==null) {
				response.sendRedirect("login.html");
			} else {
				response.getWriter().println("Login correcto.");
			}
		}
	}

}

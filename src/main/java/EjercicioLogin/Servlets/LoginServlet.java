package EjercicioLogin.Servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HibernateUtil.logger.info("Acceso al metodo doGet de LoginServlet, redirigiendo la ejecucion a doPost");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HibernateUtil.logger.info("Acceso al metodo doGet de LoginServlet.");
		String nombre = request.getParameter("user");
		String clave = request.getParameter("psw");
		if(nombre==null || clave==null) {
			HibernateUtil.logger.info("Falta el nombre o la contraseña, por lo quese manda al HTML de login.");
			response.sendRedirect("login.html");
		} else {
			Session s = HibernateUtil.getSessionFactory().openSession();
			Usuarios us = UsuariosDAO.getUsuarioLogin(s, nombre, clave);
			if(us==null) {
				HibernateUtil.logger.info("No se a encontrado el usuario que coincida con los datos del formulario, por lo que se redirige de nuevo al formulario.");
				response.sendRedirect("login.html");
			} else {
				HibernateUtil.logger.info("Login correcto del usuario "+us.getNombre()+".");
				//response.getWriter().println("Login correcto.");
				HttpSession sesion = request.getSession();
				sesion.setAttribute("usuario", us);
				s.close();
				LocalDateTime fecha = LocalDateTime.now();
				sesion.setAttribute("fecha", fecha);
				request.getRequestDispatcher("menu.jsp").forward(request, response);
			}
		}
	}

}

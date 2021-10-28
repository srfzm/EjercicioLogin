package EjercicioLogin.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import EjercicioLogin.Modelos.Roles;
import EjercicioLogin.DAO.RolesDAO;
import EjercicioLogin.Utilidades.HibernateUtil;

/**
 * Servlet implementation class AltaRolServlet
 */
@WebServlet("/AltaRol")
public class AltaRolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaRolServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HibernateUtil.logger.info("Acceso al metodo doGet de AltaRolServlet, redirigiendo la ejecucion a doPost");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HibernateUtil.logger.info("Acceso al metodo doPost de AltaRolServlet.");
		Transaction tx = null;
		String rol = request.getParameter("rol");
		if(rol==null) {
			HibernateUtil.logger.info("Falta el nombre del rol, por lo que se manda al jsp del formulario.");
			request.getRequestDispatcher("altaRol.jsp").forward(request, response);
		} else {
			Session s = HibernateUtil.getSessionFactory().openSession();
			try {
				tx = s.beginTransaction();
				Roles rolIns = new Roles(rol);
				RolesDAO.insertRoles(s, rolIns);
				tx.commit();
			} catch(Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				HibernateUtil.logger.warn("Excepcion al Insertar el rol.",e);
			} finally {
				if (s != null) {
					s.close();
					HibernateUtil.logger.info("Sesion cerrada");
				}
				//request.getRequestDispatcher("menu.jsp").forward(request, response);
				request.getRequestDispatcher("listadoRoles.jsp").forward(request, response);
			}
		}
	}

}

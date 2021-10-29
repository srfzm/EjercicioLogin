package EjercicioLogin.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import EjercicioLogin.DAO.CategoriasDAO;
import EjercicioLogin.Modelos.Categorias;
import EjercicioLogin.Utilidades.HibernateUtil;

/**
 * Servlet implementation class NuevaCategoriaServlet
 */
@WebServlet("/NuevaCategoria")
public class NuevaCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevaCategoriaServlet() {
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
		HibernateUtil.logger.info("Acceso al metodo doPost de NuevaCategoriaServlet.");
		Transaction tx = null;
		String nombre = request.getParameter("nombreCategoria");
		String descripcion = request.getParameter("descripcionCategoria");
		if(nombre==null || descripcion==null) {
			HibernateUtil.logger.info("Falta el nombre o la descripcion de la categoria, por lo que se manda al jsp del formulario.");
			request.getRequestDispatcher("nuevaCategoria.jsp").forward(request, response);
		} else {
			Session s = HibernateUtil.getSessionFactory().openSession();
			try {
				tx = s.beginTransaction();
				Categorias cat = new Categorias(nombre, descripcion);
				CategoriasDAO.insertCategoria(s, cat);
				tx.commit();
			} catch(Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				HibernateUtil.logger.warn("Excepcion al Insertar la categoria.",e);
			} finally {
				if (s != null) {
					s.close();
					HibernateUtil.logger.info("Sesion cerrada");
				}
				//request.getRequestDispatcher("menu.jsp").forward(request, response);
				request.getRequestDispatcher("listadoCategorias.jsp").forward(request, response);
			}
		}
	}

}

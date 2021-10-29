package EjercicioLogin.Filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import EjercicioLogin.Modelos.Usuarios;
import EjercicioLogin.Utilidades.HibernateUtil;

/**
 * Servlet Filter implementation class FiltroControlServNCategoria
 */
@WebFilter(filterName="FiltroControlServNCategoria")
public class FiltroControlServNCategoria implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroControlServNCategoria() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HibernateUtil.logger.info("Accediendo al filtro de control del servlet de crear categorias.");
		HttpServletRequest req = (HttpServletRequest)request;
		// pass the request along the filter chain
		HttpSession sesion = req.getSession(false);
		if(((Usuarios)sesion.getAttribute("usuario")).getId_rol()==1)
			chain.doFilter(request, response);
		else
			req.getRequestDispatcher("menu.jsp").forward(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

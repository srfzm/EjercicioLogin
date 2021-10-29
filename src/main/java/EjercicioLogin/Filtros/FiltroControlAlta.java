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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EjercicioLogin.Modelos.Usuarios;
import EjercicioLogin.Utilidades.HibernateUtil;

/**
 * Servlet Filter implementation class FiltroControlAlta
 */
@WebFilter(filterName="FiltroControlAlta")
public class FiltroControlAlta implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroControlAlta() {
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

		// pass the request along the filter chain
		HibernateUtil.logger.info("Accediendo al filtro de control del servlet AltaRolServlet.");
		HttpServletRequest req = (HttpServletRequest)request;
		// pass the request along the filter chain
		HttpSession sesion = req.getSession(false);
		//incluido login.html para evitar error en navegador por redirigir muchas veces
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

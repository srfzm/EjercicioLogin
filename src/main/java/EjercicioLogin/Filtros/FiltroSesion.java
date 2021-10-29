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

/**
 * Servlet Filter implementation class FiltroSesion
 */
@WebFilter("/*")
public class FiltroSesion implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroSesion() {
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
		HttpServletRequest req = (HttpServletRequest)request;
		// pass the request along the filter chain
		HttpSession sesion = req.getSession(false);
		//incluido login.html para evitar error en navegador por redirigir muchas veces
		if(sesion!=null || req.getRequestURI().endsWith("Login") || req.getRequestURI().endsWith("login.html") || req.getRequestURI().contains("css"))
			chain.doFilter(request, response);
		else
			((HttpServletResponse)response).sendRedirect("login.html");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

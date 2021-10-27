package EjercicioLogin.DAO;

import org.hibernate.Session;

import EjercicioLogin.Modelos.Usuarios;
import EjercicioLogin.Utilidades.HibernateUtil;

public class UsuariosDAO {

	public static Usuarios getUsuarioLogin(Session s, String nombre, String clave) {
		HibernateUtil.logger.info("Busqueda en la base del usuario="+nombre+".");
		String hQuery = " from Usuarios where nombre = :nombre and clave = :clave";
		Usuarios us = s.createQuery(hQuery, Usuarios.class).setParameter("nombre", nombre).setParameter("clave", clave)
				.setMaxResults(1).uniqueResult();
		return us;
	}

}

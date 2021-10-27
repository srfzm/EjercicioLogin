package EjercicioLogin.DAO;

import org.hibernate.Session;

import EjercicioLogin.Modelos.Usuarios;

public class UsuariosDAO {

	public static Usuarios getUsuarioLogin(Session s, String nombre, String clave) {
		String hQuery = " from Usuarios where nombre = :nombre and clave = :clave";
		Usuarios us = s.createQuery(hQuery, Usuarios.class).setParameter("nombre", nombre).setParameter("clave", clave)
				.setMaxResults(1).uniqueResult();
		return us;
	}

}

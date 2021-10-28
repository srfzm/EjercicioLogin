package EjercicioLogin.DAO;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;

import EjercicioLogin.Modelos.Roles;
import EjercicioLogin.Utilidades.HibernateUtil;

public class RolesDAO {

	public static void insertRoles(Session s, Roles roles) {
		s.save(roles);
		HibernateUtil.logger.info("Realizada inserccion del rol.");
	}
	
	public static ArrayList<Roles> getLista(Session s) {
		String hql= "from Roles";
		Query query = s.createQuery(hql);
		return (ArrayList<Roles>) query.list();
	}
}

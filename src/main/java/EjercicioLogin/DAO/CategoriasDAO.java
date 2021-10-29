package EjercicioLogin.DAO;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;

import EjercicioLogin.Modelos.Categorias;
import EjercicioLogin.Utilidades.HibernateUtil;

public class CategoriasDAO {

	public static void insertCategoria(Session s, Categorias categoria) {
		s.save(categoria);
		HibernateUtil.logger.info("Realizada inserccion de la categoria.");
	}
	
	public static ArrayList<Categorias> getLista(Session s) {
		String hql= "from Categorias";
		Query query = s.createQuery(hql);
		return (ArrayList<Categorias>) query.list();
	}
}

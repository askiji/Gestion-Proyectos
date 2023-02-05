package ejercicios;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import clases.AsignaProyecto;
import utiles.SessionFactoryUtil;

public class ejercicio7 {
	public static void main(String[] args) {
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		// abrimos la sesión
		Session s = sf.openSession();
		Date d1 = new Date(2023-1900, 2, 2);
		ejercicio7(s, "01",d1);
	}
	
	/**
	 * 7. Crea un programa con un método que a partir del DNI de un empleado y de la fecha de
		inicio en la asignación de un proyecto, les asigne como fecha fin una fecha pasada (por
		ejemplo, el día anterior a la fecha actual)
	 */

	private static void ejercicio7(Session s, String  i, Date d1) {
		//creamos una transaccio para que no tengamos problemas si no funciona
		Transaction t = s.beginTransaction();
		System.out.println(d1.toString());
		try {
			//Creamos las query para buscar en base de datos
			Query q = s.createQuery("from AsignaProyecto where empleado.dni=:dni and proyecto.fechaIni =:fechaInicio").setMaxResults(1);
			q.setParameter("dni", i);
			q.setParameter("fechaInicio", d1);
			AsignaProyecto ee  = (AsignaProyecto) q.getSingleResult();
			System.out.println(ee+"---------------");
			ee.setFechaFin(new Date(2023-1900, 2, 1));
			s.saveOrUpdate(ee);
			// hacemos el comit para que se cumplan los cambios
			t.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		}
		
	}
}

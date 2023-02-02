package ejercicios;

import org.hibernate.query.Query;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import clases.DatosProfesionales;
import clases.Empleado;
import utiles.SessionFactoryUtil;

public class Ejercicio6 {
	public static void main(String[] args) {
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		// abrimos la sesión
		Session s = sf.openSession();
		ejercicio6(s);
	}
	/**
	 * 6. Crea un programa que cree un empleado con sus datos profesionales y que asigne a un
	 *	empleado ya existente sus datos profesionales a partir del DNI
	 * 
	 */
	private static void ejercicio6(Session s) {
		// empezamos con los datos profesionales porque son necesarios para 
		// crear el empleado con los datos profesionales
		
		Transaction t = s.beginTransaction();
		try {
			
			// creamos el empleado
			Empleado e = new Empleado("05", "Numero4");
			// creamos los datos personales
			DatosProfesionales dp = new DatosProfesionales(e, "05");
			e.setDatosProfesionales(dp);
			// generamso la query del empleado con us dni
			String dniEmpleado = "01";
			Query q = s.createQuery("from Empleado where dni like :dni");
			q.setParameter("dni", dniEmpleado).setMaxResults(1);
			Empleado eSegundo = (Empleado) q.getSingleResult();
			// nos creamos otros datos profesionales para asignarselo al empleado que hemos obtenido
			DatosProfesionales dp1 = new DatosProfesionales(eSegundo, "01", new BigDecimal(33333.0));
			s.saveOrUpdate(e);
			s.saveOrUpdate(dp);
			//s.saveOrUpdate(dp1);
			System.out.println("Termina el programa");
			t.commit();
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println("Error");
			e2.printStackTrace();
			t.rollback();
		}
		
	}
}

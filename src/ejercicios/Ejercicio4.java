package ejercicios;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import clases.AsignaProyecto;
import clases.AsignaProyectoId;
import clases.Empleado;
import clases.Proyecto;
import utiles.SessionFactoryUtil;


public class Ejercicio4 {
	public static void main(String[] args) {
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		// abrimos la sesión
		Session s = sf.openSession();
		ejercicio4(s);
	}


	private static void ejercicio4(Session s) {
		Transaction t = s.beginTransaction();
		try {
			Empleado e1 = new Empleado("01","Numero1");
			Empleado e2 = new Empleado("02","Numero2");
			Empleado e3 = new Empleado("03","Numero3");
			s.saveOrUpdate(e1);
			s.saveOrUpdate(e2);
			s.saveOrUpdate(e3);
			Date d1 = new Date(2023-1900, 1, 1);
			Date d2 = new Date(2023-1900, 2, 2);
			Date d3 = new Date(2023-1900, 3, 3);
			Proyecto p1 = new Proyecto(1, e1, "Proyecto1", d1);
			Proyecto p2 = new Proyecto(2, e2, "Proyecto2", d2);
			Proyecto p3 = new Proyecto(3, e3, "Proyecto3", d3);
			s.saveOrUpdate(p1);
			s.saveOrUpdate(p2);
			s.saveOrUpdate(p3);
			t.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erroraco");
			e.printStackTrace();
			t.rollback();
		}
	}
}

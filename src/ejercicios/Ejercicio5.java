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

public class Ejercicio5 {
	public static void main(String[] args) {
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		// abrimos la sesión
		Session s = sf.openSession();

		ejercicio5(s);
	}
	private static void ejercicio5(Session s) {
		Transaction t = s.beginTransaction();
		try {
			System.out.println("WAIT?");
			Query q = s.createQuery("from Empleado");
			List<Empleado> listaEmpleados= q.getResultList();
			System.out.println(listaEmpleados.size());
			Query q2 = s.createQuery("from Proyecto");
			List<Proyecto> listaProyectos = q2.getResultList();
			System.out.println(listaProyectos.size());
			System.out.println("lsitas creadas");
			Date d1 = new Date(2023-1900, 2, 2);
			AsignaProyectoId p1 = new AsignaProyectoId(listaEmpleados.get(0).getDni().toString(),1, d1);
			AsignaProyectoId p2 = new AsignaProyectoId(listaEmpleados.get(0).getDni().toString(),2, d1);
			AsignaProyectoId p3 = new AsignaProyectoId(listaEmpleados.get(0).getDni().toString(),3, d1);
			AsignaProyectoId p4 = new AsignaProyectoId(listaEmpleados.get(1).getDni().toString(),2, d1);
			AsignaProyectoId p5 = new AsignaProyectoId(listaEmpleados.get(2).getDni().toString(),3, d1);
			System.out.println("ID del proyecto creadas");
//			s.saveOrUpdate(p5);
//			s.saveOrUpdate(p4);
//			s.saveOrUpdate(p3);
//			s.saveOrUpdate(p2);
//			s.saveOrUpdate(p1);
			AsignaProyecto ap1 = new AsignaProyecto(p1, listaEmpleados.get(0), listaProyectos.get(0));
			AsignaProyecto ap2 = new AsignaProyecto(p2, listaEmpleados.get(0), listaProyectos.get(1));
			AsignaProyecto ap3 = new AsignaProyecto(p3, listaEmpleados.get(0), listaProyectos.get(2));
			AsignaProyecto ap4 = new AsignaProyecto(p4, listaEmpleados.get(1), listaProyectos.get(1));
			AsignaProyecto ap5 = new AsignaProyecto(p5, listaEmpleados.get(2), listaProyectos.get(2));
			s.saveOrUpdate(ap5);
			s.saveOrUpdate(ap4);
			s.saveOrUpdate(ap3);
			s.saveOrUpdate(ap2);
			s.saveOrUpdate(ap1);
			t.commit();
			System.out.println("WHAT?");
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		}
	
}

}

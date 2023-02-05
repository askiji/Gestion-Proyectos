package ejercicios;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import clases.AsignaProyecto;
import utiles.SessionFactoryUtil;

public class ejercicio9 {

	public static void main(String[] args) {
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		// abrimos la sesión
		Session s = sf.openSession();
		ejercicio9(s);
	}
//	9. Haz lo mismo que en el ejercicio anterior, pero sólo para asignaciones vigentes, es decir,
//	no se deben mostrar asignaciones cuya fecha inicio sea futura o la fecha fin exista y ya haya
//	pasado.


	private static void ejercicio9(Session s) {
		//creamos una transaccio para que no tengamos problemas si no funciona
		Transaction t = s.beginTransaction();
		try {
			//Creamos las query para buscar en base de datos
			Query q = s.createQuery("from AsignaProyecto where proyecto.fechaIni > fechaFin and fechaFin is not null and fechaFin > :hoy");
			q.setParameter("hoy", new Date());
			List<AsignaProyecto> lista = q.getResultList();
			lista.stream().forEach(ap -> {
				// usamos el ternario para la fecha fin (ap.getFechaFin() != null ? " hasta "+
				// ap.getFechaFin() : " y sin fecha fin")
				System.out.println("El proyecto " + ap.getProyecto().getNomProyecto() + " tiene asignado a "
						+ ap.getEmpleado().getNomEmp() + " desde " + ap.getProyecto().getFechaIni()
						+ (ap.getFechaFin() != null ? " hasta " + ap.getFechaFin() : " y sin fecha fin"));
			});
			// hacemos el comit para que se cumplan los cambios
			t.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			t.rollback();
		}
	}


}

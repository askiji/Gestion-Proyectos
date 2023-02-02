package clases;
// Generated 2 feb 2023 17:33:59 by Hibernate Tools 5.4.33.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Empleado generated by hbm2java
 */
public class Empleado implements java.io.Serializable {

	private String dni;
	private String nomEmp;
	private Set asignaProyectos = new HashSet(0);
	private DatosProfesionales datosProfesionales;
	private Set proyectos = new HashSet(0);

	public Empleado() {
	}

	public Empleado(String dni, String nomEmp) {
		this.dni = dni;
		this.nomEmp = nomEmp;
	}

	public Empleado(String dni, String nomEmp, Set asignaProyectos, DatosProfesionales datosProfesionales,
			Set proyectos) {
		this.dni = dni;
		this.nomEmp = nomEmp;
		this.asignaProyectos = asignaProyectos;
		this.datosProfesionales = datosProfesionales;
		this.proyectos = proyectos;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomEmp() {
		return this.nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public Set getAsignaProyectos() {
		return this.asignaProyectos;
	}

	public void setAsignaProyectos(Set asignaProyectos) {
		this.asignaProyectos = asignaProyectos;
	}

	public DatosProfesionales getDatosProfesionales() {
		return this.datosProfesionales;
	}

	public void setDatosProfesionales(DatosProfesionales datosProfesionales) {
		this.datosProfesionales = datosProfesionales;
	}

	public Set getProyectos() {
		return this.proyectos;
	}

	public void setProyectos(Set proyectos) {
		this.proyectos = proyectos;
	}

}

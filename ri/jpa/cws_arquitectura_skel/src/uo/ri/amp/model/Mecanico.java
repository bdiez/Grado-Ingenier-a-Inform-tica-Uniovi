package uo.ri.amp.model;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TMecanicos")
public class Mecanico {
    @Id
    @GeneratedValue
    private Long id;
    private String dni;
    private String nombre;

    @Column(name = "apellidos")
    private String apellido;

    @OneToMany(mappedBy = "mecanico")
    private Set<Intervencion> intervenciones = new HashSet<Intervencion>();

    @OneToMany(mappedBy = "mecanico")
    private Set<Averia> averias = new HashSet<Averia>();

    @OneToMany(mappedBy = "mecanico")
    private Set<Contrato> contratos = new HashSet<Contrato>();

    public Long getId() {
	return id;
    }

    Mecanico() {

    }

    public Mecanico(String dni, String nombre, String apellido) {
	this.setDni(dni);
	this.nombre = nombre;
	this.apellido = apellido;
    }

    public String getNombre() {
	return nombre;
    }

    public String getApellido() {
	return apellido;
    }

    public void addAveria(Averia averia) {
	averia.setMecanico(this);
	averias.add(averia);
    }

    public void removeAveria(Averia averia) {
	this.averias.remove(averia);
	averia.setMecanico(null);
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((dni == null) ? 0 : dni.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Mecanico other = (Mecanico) obj;
	if (dni == null) {
	    if (other.dni != null)
		return false;
	} else if (!dni.equals(other.dni))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Mecanico [nombre=" + nombre + ", apellido=" + apellido + "]";
    }

    Set<Intervencion> _getIntervenciones() {

	return intervenciones;
    }

    public Set<Intervencion> getIntervenciones() {
	return Collections.unmodifiableSet(intervenciones);
    }

    public Set<Averia> getAsignadas() {
	return Collections.unmodifiableSet(averias);
    }

    public String getDni() {
	return dni;
    }

    public void setDni(String dni) {
	this.dni = dni;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;

    }

    public void setApellidos(String apellidos) {
	this.apellido = apellidos;

    }

    public Set<Contrato> getContrato() {
	return Collections.unmodifiableSet(contratos);
    }

    protected Set<Contrato> _getContrato() {
	return contratos;
    }

    public boolean isEraseable() {
	if (intervenciones.isEmpty() && averias.isEmpty()
		&& contratos.isEmpty())
	    return true;
	return false;
    }
    /**
     * Metodo que calcula el importe de las intervenciones de un mecanico
     * @param fechaInicio
     * @return importe intervenciones
     */
    public double calcularImporteIntervenciones(Calendar fechaInicio) {
	double importe = 0;
	Calendar fechaFin = fechaInicio;
	Date fInicio = fechaInicio.getTime();
	Date fFin = fechaFin.getTime();
	fechaFin.add(Calendar.MONTH, -1);
	for (Intervencion intervencion : intervenciones) {
	    Averia averia = intervencion.getAveria();
	    if (averia.getFecha().getTime() >= fInicio.getTime()
		    && averia.getFecha().getTime() <= fFin.getTime()) {
		importe += intervencion.getImporte();
	    }
	}

	return importe;
    }
    public void addContrato(Contrato c) {
  	c.setMecanico(this);
  	contratos.add(c);
      }

      public void removeContrato(Contrato c) {
  	contratos.remove(c);
  	c.setMecanico(null);
      }

   
}

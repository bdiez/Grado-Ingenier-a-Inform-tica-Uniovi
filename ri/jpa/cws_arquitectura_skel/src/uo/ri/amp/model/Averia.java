package uo.ri.amp.model;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import uo.ri.amp.model.types.AveriaStatus;

@Entity
@Table(name = "TAverias")
public class Averia {
    @Id
    @GeneratedValue
    private Long id;
    private String descripcion;

    private Date fecha = new Date();
    private double importe;
    @Enumerated(EnumType.STRING)
    private AveriaStatus status;
    @ManyToOne
    private Factura factura;
    @ManyToOne
    private Vehiculo vehiculo;
    @ManyToOne
    private Mecanico mecanico;

    @OneToMany(mappedBy = "averia")
    private Set<Intervencion> intervenciones = new HashSet<Intervencion>();

    Averia() {
    }

    public Long getId() {
	return id;
    }

    public Averia(Date fecha, Vehiculo vehiculo) {
	vehiculo.addAveria(this);
	this.vehiculo = vehiculo;
	this.fecha = fecha;
    }

    public Averia(Vehiculo vehiculo, String descripcion) {
	this.descripcion = descripcion;
	this.vehiculo = vehiculo;
	vehiculo.addAveria(this);
    }

    public void addIntervenciones(Intervencion intervencion) {
	intervencion.setAveria(this);
	intervenciones.add(intervencion);
    }

    public void removeIntervenciones(Intervencion intervencion) {
	intervenciones.remove(intervencion);
	intervencion.setAveria(null);
    }

    public String getDescripcion() {
	return descripcion;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    public double getImporte() {
	return importe;
    }

    public void setImporte(double importe) {
	this.importe = importe;
    }

    public AveriaStatus getStatus() {
	return status;
    }

    public void setStatus(AveriaStatus status) {
	this.status = status;
    }

    public Date getFecha() {
	return fecha;
    }

    public void setFecha(Date fecha) {
	this.fecha = fecha;
    }

    public Vehiculo getVehiculo() {
	return vehiculo;
    }

    public Factura getFactura() {
	return factura;
    }

    public void setFactura(Factura factura) {
	this.factura = factura;
    }

    public Mecanico getMecanico() {
	return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
	this.mecanico = mecanico;
    }

    public void setVehiculo(Vehiculo vehiculo) {
	this.vehiculo = vehiculo;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
	result = prime * result
		+ ((vehiculo == null) ? 0 : vehiculo.hashCode());
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
	Averia other = (Averia) obj;
	if (fecha == null) {
	    if (other.fecha != null)
		return false;
	} else if (!fecha.equals(other.fecha))
	    return false;
	if (vehiculo == null) {
	    if (other.vehiculo != null)
		return false;
	} else if (!vehiculo.equals(other.vehiculo))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Averia [descripcion=" + descripcion + ", fecha=" + fecha
		+ ", importe=" + importe + ", status=" + status + ", vehiculo="
		+ vehiculo + "]";
    }

    public void _setVehiculo(Vehiculo vehiculo) {
	this.vehiculo = vehiculo;

    }

    public Set<Intervencion> _getIntervenciones() {
	return intervenciones;
    }

    public Set<Intervencion> getIntervenciones() {
	return Collections.unmodifiableSet(intervenciones);
    }

    public double calcularImporte() {
	importe = 0.0;
	for (Intervencion i : intervenciones)
	    importe += i.getImporte();
	return importe;
    }

    public void setAveria(AveriaStatus averia) {
	this.status = averia;

    }

}

package uo.ri.amp.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import uo.ri.amp.model.types.IntervencionKey;

@Entity
@IdClass(IntervencionKey.class)
@Table(name = "TIntervenciones")
public class Intervencion {
    private int minutos;

    @Id
    @ManyToOne
    private Mecanico mecanico;
    @Id
    @ManyToOne
    private Averia averia;

    public void setMecanico(Mecanico mecanico) {
	this.mecanico = mecanico;
    }

    public void setAveria(Averia averia) {
	this.averia = averia;
    }

    Intervencion() {
    }

    @OneToMany(mappedBy = "intervencion")
    private Set<Sustitucion> sustituciones = new HashSet<Sustitucion>();

    public Intervencion(Mecanico mecanico, Averia averia) {
	this.mecanico = mecanico;
	this.averia = averia;

	mecanico._getIntervenciones().add(this);
	averia._getIntervenciones().add(this);
    }

    public void addSustituciones(Sustitucion sustitucion) {
	sustitucion.setIntervencion(this);
	sustituciones.add(sustitucion);
    }

    public void removeSustituciones(Sustitucion sustitucion) {
	sustituciones.remove(sustitucion);
	sustitucion.setIntervencion(null);
    }

    public int getMinutos() {
	return minutos;
    }

    public void setMinutos(int minutos) {
	this.minutos = minutos;
    }

    public Mecanico getMecanico() {
	return mecanico;
    }

    public Averia getAveria() {
	return averia;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((averia == null) ? 0 : averia.hashCode());
	result = prime * result
		+ ((mecanico == null) ? 0 : mecanico.hashCode());
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
	Intervencion other = (Intervencion) obj;
	if (averia == null) {
	    if (other.averia != null)
		return false;
	} else if (!averia.equals(other.averia))
	    return false;
	if (mecanico == null) {
	    if (other.mecanico != null)
		return false;
	} else if (!mecanico.equals(other.mecanico))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Intervencion [minutos=" + minutos + ", mecanico=" + mecanico
		+ ", averia=" + averia + "]";
    }

    public void unlink() {
	mecanico._getIntervenciones().remove(this);
	averia._getIntervenciones().remove(this);

	this.mecanico = null;
	this.averia = null;
    }

    public Set<Sustitucion> _getSustituciones() {
	return sustituciones;
    }

    public Set<Sustitucion> getSustituciones() {
	return Collections.unmodifiableSet(sustituciones);
    }

    public double getImporte() {
	double precio = 0;
	double precioHora = 0;
	double manoObra = 0;
	for (Sustitucion s : sustituciones)
	    precio += s.getImporte();

	precioHora = averia.getVehiculo().getTipo().getPrecioHora();
	manoObra = (minutos * precioHora) / 60;
	return manoObra + precio;
    }
}

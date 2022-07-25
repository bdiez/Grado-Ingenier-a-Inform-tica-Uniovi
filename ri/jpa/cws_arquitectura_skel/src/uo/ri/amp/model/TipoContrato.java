package uo.ri.amp.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TTipoContrato")
public class TipoContrato {
    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    private int indemnizacion;

    @OneToMany(mappedBy = "tipoContrato")
    private Set<Contrato> contratos = new HashSet<Contrato>();

    TipoContrato() {
    }

    public TipoContrato(String nombreDelTipo, Integer numeroDias) {
	this.nombre = nombreDelTipo;
	this.indemnizacion = numeroDias;
    }

    public Long getID() {
	return id;

    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public void setIndemnizacion(Integer indemnizacion) {
	this.indemnizacion = indemnizacion;
    }

    public int getIndemnizacion() {
	return indemnizacion;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
	return result;
    }

    @Override
    public String toString() {
	return "TipoContrato [nombre=" + nombre + ", indemnizacion="
		+ indemnizacion;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	TipoContrato other = (TipoContrato) obj;
	if (nombre == null) {
	    if (other.nombre != null)
		return false;
	} else if (!nombre.equals(other.nombre))
	    return false;
	return true;
    }

    public boolean tieneContratosAsociados(TipoContrato tipoContrato) {
	if (contratos.isEmpty())
	    return false;
	return true;
    }

    public void addContratos(Contrato contrato) {
	contrato.setTipoContrato(this);
	contratos.add(contrato);
    }

    public void removeContrato(Contrato contrato) {
	contratos.remove(contrato);
	contrato.setTipoContrato(null);
    }
    public Set<Contrato> getContrato() {
	return Collections.unmodifiableSet(contratos);
    }

}

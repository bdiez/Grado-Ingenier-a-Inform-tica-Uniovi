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
@Table(name = "TTiposVehiculo")
public class TipoVehiculo {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private double precioHora;

    public Long getId() {
	return id;
    }

    TipoVehiculo() {
    }

    @OneToMany(mappedBy = "tipo")
    private Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();

    public TipoVehiculo(String nombre, double precioHora) {
	this.nombre = nombre;
	this.precioHora = precioHora;
    }

    public void addVehiculo(Vehiculo v) {
	v._setTipoVehiculo(this);
	vehiculos.add(v);
    }

    public void removeVehiculo(Vehiculo v) {
	vehiculos.remove(v);
	v._setTipoVehiculo(null);
    }

    public Set<Vehiculo> getVehiculos() {
	return Collections.unmodifiableSet(vehiculos);// para no poder
						      // modificarlo
    }

    public String getNombre() {
	return nombre;
    }

    public double getPrecioHora() {
	return precioHora;
    }

    public void setPrecioHora(double precioHora) {
	this.precioHora = precioHora;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
	TipoVehiculo other = (TipoVehiculo) obj;
	if (nombre == null) {
	    if (other.nombre != null)
		return false;
	} else if (!nombre.equals(other.nombre))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "TipoVehiculo [nombre=" + nombre + ", precioHora=" + precioHora
		+ "]";
    }

}

package uo.ri.amp.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import uo.ri.amp.model.types.Address;

@Entity
@Table(name = "TClientes")
public class Cliente {
    @Id
    @GeneratedValue
    private Long id;
    private String dni;
    private String nombre;
    private String apellidos;

    private Address direccion;

    @OneToMany(mappedBy = "cliente")
    private Set<MedioPago> mediosPago = new HashSet<MedioPago>();
    @OneToMany(mappedBy = "cliente")
    private Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();

    Cliente() {
    }

    public Long getId() {
	return id;
    }

    public Cliente(String dni) {
	this.dni = dni;
    }

    public Cliente(String dni, String nombre, String apellidos) {
	this.dni = dni;
	this.nombre = nombre;
	this.apellidos = apellidos;
    }

    public void addVehiculo(Vehiculo v) {
	v.setCliente(this);
	vehiculos.add(v);
    }

    public void removeVehiculo(Vehiculo v) {
	vehiculos.remove(v);
	v.setCliente(null);
    }

    public Set<Vehiculo> getVehiculo() {
	return Collections.unmodifiableSet(vehiculos);
    }

    public void addMedioPago(MedioPago mp) {
	mp.setCliente(this);
	mediosPago.add(mp);
    }

    public void removeMedioPago(MedioPago mp) {
	mediosPago.remove(mp);
	mp.setCliente(null);
    }

    public Set<MedioPago> getMedioPago() {
	return Collections.unmodifiableSet(mediosPago);
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getApellidos() {
	return apellidos;
    }

    public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
    }

    public Address getDireccion() {
	return direccion;
    }

    public void setDireccion(Address direccion) {
	this.direccion = direccion;
    }

    public String getDni() {
	return dni;
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
	Cliente other = (Cliente) obj;
	if (dni == null) {
	    if (other.dni != null)
		return false;
	} else if (!dni.equals(other.dni))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellidos="
		+ apellidos + ", direccion=" + direccion + "]";
    }

    public Set<Vehiculo> getVehiculos() {
	return Collections.unmodifiableSet(vehiculos);
    }

    public Set<MedioPago> getMediosPago() {
	return Collections.unmodifiableSet(mediosPago);
    }

}

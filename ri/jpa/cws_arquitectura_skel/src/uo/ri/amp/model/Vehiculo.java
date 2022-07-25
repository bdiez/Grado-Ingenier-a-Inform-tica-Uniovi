package uo.ri.amp.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TVehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue
    private Long id;
    private String matricula;
    private String marca;
    private String modelo;
    @Column(name = "num_averias")
    private Integer numAverias = 0;
    @ManyToOne
    private TipoVehiculo tipo;
    @ManyToOne
    private Cliente cliente;
    @OneToMany(mappedBy = "vehiculo")
    private Set<Averia> averias = new HashSet<Averia>();

    Vehiculo() {

    }

    public Long getId() {
	return id;
    }

    public Vehiculo(String matricula, String modelo, String marca) {
	this.matricula = matricula;
	this.marca = marca;
	this.modelo = modelo;
    }

    public Vehiculo(String matricula) {
	this.matricula = matricula;
    }

    void addAveria(Averia a) {
	a._setVehiculo(this);
	averias.add(a);
	numAverias++;

    }

    public void removeAveria(Averia a) {
	averias.remove(a);
	a._setVehiculo(null);
	numAverias--;
    }

    public Set<Averia> getAveria() {
	return Collections.unmodifiableSet(averias);// para no poder modificarlo
    }

    public String getMarca() {
	return marca;
    }

    public void setMarca(String marca) {
	this.marca = marca;
    }

    public String getModelo() {
	return modelo;
    }

    public void setModelo(String modelo) {
	this.modelo = modelo;
    }

    public int getNumAverias() {
	return numAverias;
    }

    public void setNumAverias(int numAverias) {
	this.numAverias = numAverias;
    }

    public String getMatricula() {
	return matricula;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((matricula == null) ? 0 : matricula.hashCode());
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
	Vehiculo other = (Vehiculo) obj;
	if (matricula == null) {
	    if (other.matricula != null)
		return false;
	} else if (!matricula.equals(other.matricula))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Vehiculo [matricula=" + matricula + ", marca=" + marca
		+ ", modelo=" + modelo + ", numAverias=" + numAverias + "]";
    }

    void _setTipoVehiculo(TipoVehiculo tipoVehiculo) {
	this.tipo = tipoVehiculo;

    }

    public TipoVehiculo getTipo() {
	return tipo;
    }

    public Cliente getCliente() {
	return cliente;
    }

    public void setCliente(Cliente cliente) {
	this.cliente = cliente;
    }

    public Set<Averia> getAverias() {
	return Collections.unmodifiableSet(averias);
    }

}

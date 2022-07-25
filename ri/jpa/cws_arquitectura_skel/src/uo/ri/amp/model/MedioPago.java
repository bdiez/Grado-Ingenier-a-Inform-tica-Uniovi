package uo.ri.amp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "TMediosPago")
public abstract class MedioPago {
    @Id
    @GeneratedValue
    protected Long id;
    private Double acumulado = 0.0;
    @ManyToOne
    protected Cliente cliente;

    @OneToMany(mappedBy = "medioPago")
    private Set<Cargo> cargos = new HashSet<Cargo>();

    MedioPago() {
    }

    public Long getId() {
	return id;
    }

    public Double getAcumulado() {
	return acumulado;
    }

    public void setAcumulado(Double acumulado) {
	this.acumulado = acumulado;
    }

    public Cliente getCliente() {
	return cliente;
    }

    public void setCliente(Cliente cliente) {
	this.cliente = cliente;
    }

    public Set<Cargo> getCargos() {
	return this.cargos;
    }

    Set<Cargo> _getCargos() {
	return this.cargos;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
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
	MedioPago other = (MedioPago) obj;
	if (cliente == null) {
	    if (other.cliente != null)
		return false;
	} else if (!cliente.equals(other.cliente))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "MedioPago [acumulado=" + acumulado + ", cliente=" + cliente
		+ "]";
    }

    public String toFormatedString() {
	// TODO Auto-generated method stub
	return null;
    }

}

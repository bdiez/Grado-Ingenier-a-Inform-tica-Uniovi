package uo.ri.amp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TCategoria")
public class Categoria {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private int importe;
    @Column(name = "plus_productividad")
    private double plusProductividad;

    @OneToMany(mappedBy = "categoria")
    private Set<Contrato> contratos = new HashSet<Contrato>();

    public int getImporte() {
	return importe;
    }

    public void setImporte(int importe) {
	this.importe = importe;
    }

    public double getPlusProductividad() {
	return plusProductividad;
    }

    public void setPlusProductividad(double plusProductividad) {
	this.plusProductividad = plusProductividad;
    }

    public String getNombre() {
	return nombre;
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
	Categoria other = (Categoria) obj;
	if (nombre == null) {
	    if (other.nombre != null)
		return false;
	} else if (!nombre.equals(other.nombre))
	    return false;
	return true;
    }

}

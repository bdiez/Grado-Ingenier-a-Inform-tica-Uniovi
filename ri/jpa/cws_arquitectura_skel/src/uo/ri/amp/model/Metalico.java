package uo.ri.amp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Metalico")
public class Metalico extends MedioPago {
    public Metalico(Cliente cliente) {
	this.cliente = cliente;
	cliente.addMedioPago(this);
    }

    Metalico() {
    }

    @Override
    public String toString() {
	return "Metalico [toString()=" + super.toString() + "]";
    }
}

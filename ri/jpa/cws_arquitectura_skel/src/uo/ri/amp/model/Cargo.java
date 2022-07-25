package uo.ri.amp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import uo.ri.amp.model.types.CargoKey;

@Entity
@IdClass(CargoKey.class)
@Table(name = "TCargos")
public class Cargo {
	private double importe;
	@Id
	@ManyToOne
	private Factura factura;
	@Id
	@ManyToOne
	private MedioPago medioPago;

	Cargo() {

	}

	public Cargo(Factura factura, MedioPago medio, double importe) {
		this.importe = importe;
		this.factura = factura;
		this.medioPago = medio;
		medio.setAcumulado(importe);

		factura._getCargos().add(this);
		medio.getCargos().add(this);
	}

	public void unlink() {
		this.factura._getCargos().remove(this);
		this.medioPago.getCargos().remove(this);

		medioPago.setAcumulado(medioPago.getAcumulado() - importe);
		factura = null;
		medioPago = null;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public MedioPago getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((factura == null) ? 0 : factura.hashCode());
		result = prime * result
				+ ((medioPago == null) ? 0 : medioPago.hashCode());
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
		Cargo other = (Cargo) obj;
		if (factura == null) {
			if (other.factura != null)
				return false;
		} else if (!factura.equals(other.factura))
			return false;
		if (medioPago == null) {
			if (other.medioPago != null)
				return false;
		} else if (!medioPago.equals(other.medioPago))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cargo [importe=" + importe + ", factura=" + factura
				+ ", medioPago=" + medioPago + "]";
	}
}

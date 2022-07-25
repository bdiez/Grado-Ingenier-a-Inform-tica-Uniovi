package uo.ri.amp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.model.types.AveriaStatus;
import uo.ri.amp.model.types.FacturaStatus;
import alb.util.date.DateUtil;

@Entity
@Table(name = "TFacturas")
public class Factura {
    @Id
    @GeneratedValue
    private Long id;
    private long numero = 0l;
    private Date fecha;
    private Double iva = 0.0;
    private Double importe = 0.0;
    @Enumerated(EnumType.STRING)
    private FacturaStatus status;
    @OneToMany(mappedBy = "factura")
    private Set<Cargo> cargos = new HashSet<Cargo>();
    @OneToMany(mappedBy = "factura")
    private List<Averia> averias = new ArrayList<Averia>();

    Factura() {
    }

    public Long getId() {
	return id;
    }

    public Factura(Long numero, Date fecha) {
	super();
	this.numero = numero;
	this.fecha = fecha;
	if (fecha.before(DateUtil.fromString("1/7/2014")))
	    iva = 0.18;
	else
	    iva = 0.21;
	setStatus(FacturaStatus.SIN_ABONAR);
    }

    public Factura(Long numero) {
	this.numero = numero;
	iva = 0.21;
	setStatus(FacturaStatus.SIN_ABONAR);

    }

    public Factura(long numero2, List<Averia> averias2)
	    throws BusinessException {
	this.numero = numero2;
	this.averias = averias2;
	iva = 0.21;
	for (Averia a : averias) {
	    if (a.getStatus() != AveriaStatus.TERMINADA)
		throw new BusinessException("Averia no terminada");
	    a.setAveria(AveriaStatus.FACTURADA);
	}
	setStatus(FacturaStatus.SIN_ABONAR);

    }

    public Factura(long l, Date fecha, List<Averia> averias2)
	    throws BusinessException {
	this.numero = l;
	this.fecha = fecha;
	averias = averias2;
	setStatus(FacturaStatus.SIN_ABONAR);
	if (fecha.before(DateUtil.fromString("1/7/2014")))
	    iva = 0.18;
	else
	    iva = 0.21;
	for (Averia a : averias) {
	    if (a.getStatus() != AveriaStatus.TERMINADA)
		throw new BusinessException("Averia no terminada");
	    a.setAveria(AveriaStatus.FACTURADA);
	}
    }

    public Date getFecha() {
	return fecha;
    }

    public void setFecha(Date fecha) {
	this.fecha = fecha;
    }

    public double getIva() {
	return iva;
    }

    public void setIva(double iva) {
	this.iva = iva;
    }

    public double getImporte() {
	for (Averia a : averias)
	    importe += a.calcularImporte();
	importe += importe * iva;
	importe = redondear(importe, 2);
	return importe;
    }

    private Double redondear(Double numero, int decimales) {
	return Math.round(numero * Math.pow(10, decimales))
		/ Math.pow(10, decimales);
    }

    public void setImporte(double importe) {
	this.importe = importe;
    }

    public FacturaStatus getStatus() {
	return status;
    }

    public void setStatus(FacturaStatus status) {
	this.status = status;
    }

    public long getNumero() {
	return numero;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (numero ^ (numero >>> 32));
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
	Factura other = (Factura) obj;
	if (numero != other.numero)
	    return false;
	return true;
    }

    public Set<Cargo> getCargos() {
	return Collections.unmodifiableSet(cargos);
    }

    Set<Cargo> _getCargos() {
	return this.cargos;
    }

    @Override
    public String toString() {
	return "Factura [numero=" + numero + ", fecha=" + fecha + ", iva="
		+ iva + ", importe=" + importe + ", status=" + status + "]";
    }

    public List<Averia> getAverias() {
	return Collections.unmodifiableList(averias);
    }

    public void removeAveria(Averia averia) {
	averias.remove(averia);
	averia.setFactura(null);

    }

    public void addAveria(Averia averia) {
	averia.setFactura(this);
	averias.add(averia);
	averia.setAveria(AveriaStatus.FACTURADA);

    }

}

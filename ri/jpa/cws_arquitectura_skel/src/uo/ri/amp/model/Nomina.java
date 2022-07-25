package uo.ri.amp.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TNomina")
public class Nomina {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "salario_base")
    private double salarioBase;
    @Column(name = "paga_extra")
    private double pagaExtra;
    @Column(name = "plus_productividad")
    private double plusProductividad;
    private double trienios;
    @Column(name = "descuentos_irpf")
    private double descuentosIRPF;
    @Column(name = "seguridad_social")
    private double descuentoSS;
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;

    public Nomina() {
    }

    public Nomina(Date fecha, Contrato contrato) {
	this.fecha = fecha;
	this.contrato = contrato;
    }

    public double getSalarioBase() {
	return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
	this.salarioBase = salarioBase;
    }

    public double getPagaExtra() {
	return pagaExtra;
    }

    public void setPagaExtra(double pagaExtra) {
	this.pagaExtra = pagaExtra;
    }

    public double getPlusProductividad() {
	return plusProductividad;
    }

    public void setPlusProductividad(double plusProductividad) {
	this.plusProductividad = plusProductividad;
    }

    public double getTrienios() {
	return trienios;
    }

    public void setTrienios(double trienios) {
	this.trienios = trienios;
    }

    public double getDescuentosIRPF() {
	return descuentosIRPF;
    }

    public void setDescuentosIRPF(double descuentosIRPF) {
	this.descuentosIRPF = descuentosIRPF;
    }

    public double getDescuentoSS() {
	return descuentoSS;
    }

    public void setDescuentoSS(double descuentoSS) {
	this.descuentoSS = descuentoSS;
    }

    public Date getFecha() {
	return fecha;
    }

    public void setFecha(Date fecha) {
	this.fecha = fecha;
    }

    public Long getId() {
	return id;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((contrato == null) ? 0 : contrato.hashCode());
	result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
	long temp;
	temp = Double.doubleToLongBits(salarioBase);
	result = prime * result + (int) (temp ^ (temp >>> 32));
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
	Nomina other = (Nomina) obj;
	if (contrato == null) {
	    if (other.contrato != null)
		return false;
	} else if (!contrato.equals(other.contrato))
	    return false;
	if (fecha == null) {
	    if (other.fecha != null)
		return false;
	} else if (!fecha.equals(other.fecha))
	    return false;
	if (Double.doubleToLongBits(salarioBase) != Double
		.doubleToLongBits(other.salarioBase))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Nomina [salarioBase=" + salarioBase + ", pagaExtra="
		+ pagaExtra + ", plusProductividad=" + plusProductividad
		+ ", trienios=" + trienios + ", descuentosIRPF="
		+ descuentosIRPF + ", descuentoSS=" + descuentoSS + ", fecha="
		+ fecha + "]";
    }

    public double calcularDescuentoIRPF() {
	double descuento = 0;
	if (salarioBase < 12000)
	    descuento = salarioBase * 0.07f / 12;
	else if (salarioBase < 12000)
	    descuento = salarioBase * 0.10f / 12;
	else if (salarioBase < 20.000)
	    descuento = salarioBase * 0.13f / 12;
	else if (salarioBase < 25.000)
	    descuento = salarioBase * 0.17f / 12;
	else if (salarioBase < 30.000)
	    descuento = salarioBase * 0.20f / 12;
	return descuento;

    }

    /**
     * Metodo que comprueba el descuento de la seguridad social
     * 
     * @return descuento seguridad social
     */
    public double calcularDescuentoSeguridadSocial() {
	return (salarioBase + pagaExtra) * 0.05;

    }

    /**
     * Metodo que calcula el salario neto
     * 
     * @return salario neto
     */
    public double getSalarioNeto() {
	double salarioNeto = 0;
	salarioNeto = salarioBase + pagaExtra - descuentosIRPF - descuentoSS;
	return salarioNeto;
    }

    /**
     * Metodo que asigna si corresponde paga extra en el mes de la nomina o
     * no
     * 
     * @param fecha
     */
    public void asignarPagaExtra(Calendar fecha) {
	if (fecha.get(Calendar.MONTH) == Calendar.JUNE
		|| fecha.get(Calendar.MONTH) == Calendar.DECEMBER)
	    this.pagaExtra = salarioBase;
	else
	    this.pagaExtra = 0;

    }

    public void setContrato(Contrato contrato) {
	this.contrato = contrato;

    }

}

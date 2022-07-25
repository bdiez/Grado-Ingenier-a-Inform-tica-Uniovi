package uo.ri.amp.model;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import uo.ri.amp.model.types.ContratoStatus;

@Entity
@Table(name = "TContratos")
public class Contrato {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    private Date fechaFin;
    @Column(name = "fecha_liquidacion")
    private Date fechaLiquidacion;
    private double salario;

    @Enumerated(EnumType.STRING)
    private ContratoStatus activo;

    private Double liquidacion;

    @ManyToOne
    @JoinColumn(name = "mecanico_id")
    private Mecanico mecanico;
    @ManyToOne
    @JoinColumn(name = "tipo_contrato_id")
    private TipoContrato tipoContrato;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "contrato")
    private Set<Nomina> nominas = new HashSet<Nomina>();

    Contrato() {
    }

    public Contrato(Mecanico mecanico, Categoria categoria,
	    TipoContrato tipoContrato, Double salario,Date fechaInicio, Date fechaFin) {
	this.mecanico = mecanico;
	this.fechaInicio = fechaInicio;
	this.fechaFin = fechaFin;
	this.salario = salario;
	this.categoria = categoria;
	this.tipoContrato = tipoContrato;
	this.activo = ContratoStatus.ACTIVO;
	this.liquidacion = 0.0;
	this.mecanico._getContrato().add(this);
    }

    public long getId() {
	return id;
    }


    public Date getFechaInicio() {
	return fechaInicio;
    }

    public Mecanico getMecanico() {
	return mecanico;
    }

    public Date getFechaFin() {
	return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
	this.fechaFin = fechaFin;
    }

    public Date getFechaLiquidacion() {
	return fechaLiquidacion;
    }

    public void setFechaLiquidacion(Date fechaLiquidacion) {
	this.fechaLiquidacion = fechaLiquidacion;
    }

    public double getSalario() {
	return salario;
    }

    public void setSalario(double salario) {
	this.salario = salario;
    }

    public ContratoStatus getActivo() {
	return activo;
    }

    public void setActivo(ContratoStatus activo) {
	this.activo = activo;
    }

    public Double getLiquidacion() {
	return liquidacion;
    }

    public void setLiquidacion(Double liquidacion) {
	this.liquidacion = liquidacion;
    }

    public TipoContrato getTipoContrato() {
	return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
	this.tipoContrato = tipoContrato;
    }

    public Categoria getCategoria() {
	return categoria;
    }

    public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
	result = prime * result
		+ ((mecanico == null) ? 0 : mecanico.hashCode());
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
	Contrato other = (Contrato) obj;
	if (fechaInicio == null) {
	    if (other.fechaInicio != null)
		return false;
	} else if (!fechaInicio.equals(other.fechaInicio))
	    return false;
	if (mecanico == null) {
	    if (other.mecanico != null)
		return false;
	} else if (!mecanico.equals(other.mecanico))
	    return false;
	return true;
    }

    public double calcularTrienios() {
	int anios = contarAniosContrato(fechaInicio, fechaFin);
	return (int) (anios / 3 * (double) categoria.getImporte());
    }

    public Double calcularLiquidacion(int dias) {
	return salario * dias;
    }

    private int contarAniosContrato(Date fechaInicio, Date fechaFin) {
	Calendar fechaFinContrato = new GregorianCalendar();
	fechaFinContrato.setTime(fechaFin);

	Calendar fechaIni = new GregorianCalendar();
	fechaIni.setTime(fechaInicio);

	int anioFin = fechaFinContrato.get(Calendar.YEAR);
	int anioInicio = fechaIni.get(Calendar.YEAR);

	int anios = anioInicio - anioFin;

	int mesInicio = fechaIni.get(Calendar.MONTH);
	int mesFin = fechaFinContrato.get(Calendar.MONTH);

	if (mesInicio > mesFin) {
	    anios--;
	}
	return anios;
    }

    @Override
    public String toString() {
	return "Contrato [fechaInicio=" + fechaInicio + ", fechaFin="
		+ fechaFin + ", fechaLiquidacion=" + fechaLiquidacion
		+ ", salario=" + salario + ", activo=" + activo
		+ ", liquidacion=" + liquidacion + ", mecanico=" + mecanico
		+ ", tipoContrato=" + tipoContrato + ", categoria=" + categoria
		+ ", nominas=" + nominas + "]";
    }

    public void setFechaInicio(Date fechaInicio) {
	this.fechaInicio = fechaInicio;
    }
    public void addNomina(Nomina n) {
  	n.setContrato(this);
  	nominas.add(n);
      }

      public void removeNomina(Nomina n) {
  	nominas.remove(n);
  	n.setContrato(null);
      }

      public Set<Nomina> getNominas() {
  	return Collections.unmodifiableSet(nominas);
      }

    public void setMecanico(Mecanico mecanico) {
	this.mecanico = mecanico;
	
    }


}

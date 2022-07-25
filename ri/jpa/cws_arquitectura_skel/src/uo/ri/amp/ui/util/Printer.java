package uo.ri.amp.ui.util;

import java.util.Calendar;
import java.util.List;

import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.Factura;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.MedioPago;
import uo.ri.amp.model.Nomina;
import uo.ri.amp.model.TipoContrato;
import alb.util.console.Console;

public class Printer {

    public static void printInvoice(Factura invoice) {

	double importeConIVa = invoice.getImporte();
	double iva = (Double) invoice.getIva();
	double importeSinIva = importeConIVa / (1 + iva / 100);

	Console.printf("Factura nº: %d\n", invoice.getNumero());
	Console.printf("\tFecha: %1$td/%1$tm/%1$tY\n", invoice.getFecha());
	Console.printf("\tTotal: %.2f €\n", importeSinIva);
	Console.printf("\tIva: %.1f %% \n", invoice.getIva());
	Console.printf("\tTotal con IVA: %.2f €\n", invoice.getImporte());
	Console.printf("\tEstado: %s\n", invoice.getStatus());
    }

    public static void printPaymentMeans(List<MedioPago> medios) {
	Console.println();
	Console.println("Medios de pago disponibles");

	Console.printf("\t%s \t%-8.8s \t%s \n", "ID", "Tipo", "Acumulado");
	for (MedioPago medio : medios) {
	    Console.println(medio.toString());
	}
    }

    public static void printRepairing(Averia rep) {

	Console.printf("\t%d \t%-40.40s \t%td/%<tm/%<tY \t%-12.12s \t%.2f\n",
		rep.getId(), rep.getDescripcion(), rep.getFecha(),
		rep.getStatus(), rep.getImporte());
    }

    public static void printMechanic(Mecanico m) {

	Console.printf("\t%d %-10.10s %-25.25s %-25.25s\n", m.getId(),
		m.getDni(), m.getNombre(), m.getApellido());
    }

    public static void printContrato(Contrato contrato) {
	Console.println("Id: " + contrato.getId() + "\t" + contrato.getActivo()
		+ "\tsalario: " + contrato.getSalario() + "\n\tfechaInicio: "
		+ contrato.getFechaInicio() + "\tfechaFin: "
		+ contrato.getFechaFin() + "\n\tdniMecanico: "
		+ contrato.getMecanico().getDni() + "\tcategoria: "
		+ contrato.getCategoria().getNombre());
	if (contrato.getActivo().equals("INACTIVO")) {
	    Console.println("Liquidación: " + contrato.getLiquidacion());
	}
    }

    public static void printTipoContrato(TipoContrato tipoContrato) {
	Console.println(tipoContrato.getNombre());

    }

    public static void printNominaGeneral(Nomina n) {
	Console.println("Mes de la nomina: " + n.getFecha().toString());

    }

    public static void printNominaEspecifico(Nomina n) {
	Calendar fecha = Calendar.getInstance();
	fecha.setTime(n.getFecha());
	Console.println("Mes:" + Calendar.MONTH + " Total bruto: "
		+ n.getSalarioBase() + " Total neto: " + n.getSalarioNeto());
	Console.println("\tConceptos:\n\t\t" + "Plus productividad: "
		+ n.getPlusProductividad() + "\n\t\tTrienios: "
		+ n.getTrienios() + "\n\t\tDescuento IRPF: "
		+ n.getDescuentosIRPF()
		+ "\n\t\tDescuentos por aportación a la SS: "
		+ n.getDescuentoSS());

    }
}

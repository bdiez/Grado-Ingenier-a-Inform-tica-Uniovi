package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.Nomina;
import uo.ri.amp.persistence.util.Jpa;

public class NominasFinder {

    public static long contar(int mes, int anio, Mecanico mecanico) {
	return Jpa.getManager()
		.createNamedQuery("Nomina.contarNominas", Long.class)
		.setParameter(1, mes).setParameter(2, anio)
		.setParameter(3, mecanico).getSingleResult();
    }

    public static Long contarNominasMecanico(Mecanico mecanico) {
	return Jpa.getManager()
		.createNamedQuery("Nomina.contarNominasMecanico", Long.class)
		.setParameter(1, mecanico).getSingleResult();
    }

    public static Nomina findUltimaNominaMecanico(Mecanico mecanico) {
	return Jpa
		.getManager()
		.createNamedQuery("Nomina.findUltimaNominaMecanico",
			Nomina.class).setParameter(1, mecanico).getResultList()
		.get(0);
    }

    public static List<Nomina> findNominasGeneralMecanico(Mecanico mecanico) {
	return Jpa
		.getManager()
		.createNamedQuery("Nomina.listadoGeneralNominasMecanico",
			Nomina.class).setParameter(1, mecanico.getId())
		.getResultList();
    }
}

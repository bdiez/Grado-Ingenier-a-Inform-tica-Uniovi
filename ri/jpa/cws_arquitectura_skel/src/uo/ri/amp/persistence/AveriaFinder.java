package uo.ri.amp.persistence;

import java.util.Date;
import java.util.List;

import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.persistence.util.Jpa;

public class AveriaFinder {

    public static List<Averia> findByIds(List<Long> idsAveria) {

	return Jpa.getManager()
		.createNamedQuery("Averia.findByIds", Averia.class)
		.setParameter(1, idsAveria).getResultList();
    }

    public static List<Averia> findNoFacturadasByDni(String dni) {

	return null;
    }

    public static Long contarIntervencionesPeriodo(Mecanico mecanico,
	    Date fechaInicio, Date fechaFin) {
	return Jpa
		.getManager()
		.createNamedQuery("Averia.contarIntervencionesEnPeriodo",
			Long.class).setParameter(1, mecanico)
		.setParameter(2, fechaInicio).setParameter(3, fechaFin)
		.getSingleResult();
    }

}

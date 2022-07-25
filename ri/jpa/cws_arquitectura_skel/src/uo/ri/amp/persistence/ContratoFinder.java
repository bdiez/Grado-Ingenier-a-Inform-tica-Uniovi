package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.TipoContrato;
import uo.ri.amp.persistence.util.Jpa;

public class ContratoFinder {

    public static List<Contrato> buscarTipoContrato(TipoContrato tipoContrato) {
	return Jpa
		.getManager()
		.createNamedQuery("Contrato.buscarTipoContrato", Contrato.class)
		.setParameter(1, tipoContrato.getID()).getResultList();
    }

    public static Contrato buscarActivoPorMecanico(Mecanico mecanico) {
	return Jpa
		.getManager()
		.createNamedQuery("Contrato.findContratoActivo", Contrato.class)
		.setParameter(1, mecanico.getId()).getSingleResult();
    }

    public static Long contarContratosActivos(Mecanico mecanico) {
	return Jpa
		.getManager()
		.createNamedQuery("Contrato.contarContratosActivos", Long.class)
		.setParameter(1, mecanico.getId()).getSingleResult();
    }

    public static List<Contrato> findContratosMecanico(Long idMecanico) {
	return Jpa
		.getManager()
		.createNamedQuery("Contrato.findContratosMecanico",
			Contrato.class).setParameter(1, idMecanico)
		.getResultList();
    }

    public static List<Contrato> findContratosActivosPorTipo(Long idTipo) {
	return Jpa
		.getManager()
		.createNamedQuery("Contrato.findContratosActivos",
			Contrato.class).setParameter(1, idTipo).getResultList();
    }

    public static  List<Contrato> findAll() {
	return Jpa.getManager()
		.createNamedQuery("Contrato.findAll", Contrato.class)
		.getResultList();
    }
}
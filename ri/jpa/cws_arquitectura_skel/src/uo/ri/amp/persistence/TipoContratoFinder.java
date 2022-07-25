package uo.ri.amp.persistence;

import uo.ri.amp.model.TipoContrato;
import uo.ri.amp.persistence.util.Jpa;

public class TipoContratoFinder {
    public static TipoContrato findById(Long id) {

	return Jpa.getManager()
		.createNamedQuery("TipoContrato.findById", TipoContrato.class)
		.getSingleResult();
    }
}

package uo.ri.amp.persistence;

import uo.ri.amp.persistence.util.Jpa;

public class FacturaFinder {

    public static Long getNextInvoiceNumber() {

	return Jpa.getManager()
		.createNamedQuery("Factura.getNextInvoiceNumber", Long.class)
		.getSingleResult();
    }

}

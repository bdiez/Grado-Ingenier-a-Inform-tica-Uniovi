package uo.ri.amp.business.impl.admin.contrato;

import java.util.Date;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.AveriaFinder;
import uo.ri.amp.persistence.util.Jpa;

public class DeleteContrato implements Command {
    private Long idContrato;

    /**
     * Contructor de la clase
     * 
     * @param idContrato
     */
    public DeleteContrato(Long idContrato) {
	this.idContrato = idContrato;
    }

    @Override
    public Object execute() throws BusinessException {
	Contrato contrato = Jpa.getManager().find(Contrato.class, idContrato);
	if (contrato != null
		&& !tieneIntervenciones(contrato.getMecanico(),
			contrato.getFechaInicio(), contrato.getFechaFin()))
	    Jpa.getManager().remove(contrato);
	else {
	    throw new BusinessException("No puede borrarse el contrato");
	}
	return null;
    }

    /**
     * Método que comprueba si el mecánico realizó alguna intervención durante
     * el periodo de vigencia del contrato
     * 
     * @param mecanico
     * @param fechaInicio
     * @param fechaFin
     */
    private boolean tieneIntervenciones(Mecanico mecanico, Date fechaInicio,
	    Date fechaFin) {
	Long numeroIntervenciones = AveriaFinder.contarIntervencionesPeriodo(
		mecanico, fechaInicio, fechaFin);
	return (numeroIntervenciones != 0) ? true : false;

    }
}

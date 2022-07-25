package uo.ri.amp.business.impl.admin.tipoContrato;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.TipoContrato;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.util.Jpa;

public class DeleteTipoContrato implements Command {

    private Long tipoContratoID;

    /**
     * Constructor de la clase
     * 
     * @param tipoContratoID
     */
    public DeleteTipoContrato(Long tipoContratoID) {
	this.tipoContratoID = tipoContratoID;
    }

    @Override
    public Object execute() throws BusinessException {
	TipoContrato tipoContrato = Jpa.getManager().find(TipoContrato.class,
		tipoContratoID);

	if (tipoContrato == null)
	    throw new BusinessException(
		    "El tipo de contrato no se ha encontrado");

	else if (tipoContrato.tieneContratosAsociados(tipoContrato))
	    throw new BusinessException(
		    "El tipo de contrato no se puede borrar");

	Jpa.getManager().remove(tipoContrato);

	return null;

    }

}

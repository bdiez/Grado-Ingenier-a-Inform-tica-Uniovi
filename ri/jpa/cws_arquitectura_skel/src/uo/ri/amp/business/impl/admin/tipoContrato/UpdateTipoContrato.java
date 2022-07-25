package uo.ri.amp.business.impl.admin.tipoContrato;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.TipoContrato;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.util.Jpa;

public class UpdateTipoContrato implements Command {

    private TipoContrato tipoContrato;

    /**
     * Constructor de la clase
     * 
     * @param tipoContrato
     */
    public UpdateTipoContrato(TipoContrato tipoContrato) {
	this.tipoContrato = tipoContrato;
    }

    public Object execute() throws BusinessException {

	Jpa.getManager().merge(tipoContrato);

	return null;
    }

}
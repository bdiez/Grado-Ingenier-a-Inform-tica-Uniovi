package uo.ri.amp.business.impl.admin.contrato;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.util.Jpa;

public class FindContratoById implements Command {
    private Long id;

    /**
     * Constructor de la clase
     * 
     * @param id
     */
    public FindContratoById(Long id) {
	this.id = id;
    }

    @Override
    public Object execute() throws BusinessException {
	return Jpa.getManager().find(Contrato.class, id);
    }

}

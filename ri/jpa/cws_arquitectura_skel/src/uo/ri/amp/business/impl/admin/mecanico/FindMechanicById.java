package uo.ri.amp.business.impl.admin.mecanico;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.util.Jpa;

public class FindMechanicById implements Command {

    private Long id;

    /**
     * Constructor de la clase
     * 
     * @param id
     */
    public FindMechanicById(Long id) {
	this.id = id;
    }

    public Object execute() throws BusinessException {

	return Jpa.getManager().find(Mecanico.class, id);

    }

}

package uo.ri.amp.business.impl.admin.mecanico;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.util.Jpa;

public class AddMechanic implements Command {

    private Mecanico mecanico;

    /**
     * Constructor de la clase
     * 
     * @param mecanico
     */
    public AddMechanic(Mecanico mecanico) {
	this.mecanico = mecanico;
    }

    public Object execute() throws BusinessException {
	Jpa.getManager().persist(mecanico);

	return null;
    }

}

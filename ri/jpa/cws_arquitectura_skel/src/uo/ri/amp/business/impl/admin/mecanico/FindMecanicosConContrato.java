package uo.ri.amp.business.impl.admin.mecanico;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.MecanicoFinder;

public class FindMecanicosConContrato implements Command {

    @Override
    public Object execute() throws BusinessException {
	return MecanicoFinder.findConContrato();
    }

}

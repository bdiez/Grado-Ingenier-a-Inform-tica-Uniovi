package uo.ri.amp.business.impl.admin.contrato;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.ContratoFinder;

public class FindAllContratos implements Command {

    @Override
    public Object execute() throws BusinessException {
	return ContratoFinder.findAll();
    }

}

package uo.ri.amp.business.impl.admin.contrato;

import java.util.List;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.ContratoFinder;

public class FindContratoMecanicos implements Command {
    private Long idMecanico;

    /**
     * Constructor de la clase
     * 
     * @param idMecanico
     */
    public FindContratoMecanicos(Long idMecanico) {
	this.idMecanico = idMecanico;
    }

    @Override
    public List<Contrato> execute() throws BusinessException {
	return ContratoFinder.findContratosMecanico(idMecanico);
    }

}

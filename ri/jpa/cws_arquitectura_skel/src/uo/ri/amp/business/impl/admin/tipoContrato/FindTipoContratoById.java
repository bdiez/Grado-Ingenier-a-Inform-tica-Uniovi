package uo.ri.amp.business.impl.admin.tipoContrato;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.TipoContrato;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.util.Jpa;

public class FindTipoContratoById implements Command {
	
    	private Long id;
    	
    	/**
    	 * Constructor de la clase
    	 * @param id
    	 */
	public FindTipoContratoById(Long id) {
		this.id = id;
	}

	@Override
	public Object execute() throws BusinessException {
		return Jpa.getManager().find(TipoContrato.class,id);
	}

}

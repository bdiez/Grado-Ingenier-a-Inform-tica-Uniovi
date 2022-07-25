package uo.ri.amp.business.impl.admin.tipoContrato;

import java.util.List;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.TipoContrato;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.ContratoFinder;

public class ListarTrabajadoresConContratoActivo implements Command {
    private TipoContrato tipoContrato;

    /**
     * Constructor de la clase
     * 
     * @param tipoContrato
     */
    public ListarTrabajadoresConContratoActivo(TipoContrato tipoContrato) {
	this.tipoContrato = tipoContrato;
    }

    @Override
    public Object execute() throws BusinessException {
	List<Contrato> contratos = ContratoFinder
		.buscarTipoContrato(tipoContrato);

	return contratos;
    }

}

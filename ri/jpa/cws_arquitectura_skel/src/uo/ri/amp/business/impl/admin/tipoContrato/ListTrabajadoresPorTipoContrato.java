package uo.ri.amp.business.impl.admin.tipoContrato;

import java.util.List;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.ContratoFinder;

public class ListTrabajadoresPorTipoContrato implements Command {
    private Long idTipo;

    /**
     * Constructor de la clase
     * 
     * @param idTipo
     */
    public ListTrabajadoresPorTipoContrato(Long idTipo) {
	this.idTipo = idTipo;
    }

    @Override
    public Object execute() throws BusinessException {
	List<Contrato> contratos = ContratoFinder
		.findContratosActivosPorTipo(idTipo);

	return contratos;
    }

}

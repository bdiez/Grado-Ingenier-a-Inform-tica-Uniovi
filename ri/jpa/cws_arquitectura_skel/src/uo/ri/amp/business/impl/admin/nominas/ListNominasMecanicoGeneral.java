package uo.ri.amp.business.impl.admin.nominas;

import java.util.List;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.Nomina;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.amp.persistence.NominasFinder;

public class ListNominasMecanicoGeneral implements Command {
    private Long mecanicoID;

    /**
     * Constructor de la clase
     * 
     * @param mecanicoID
     */
    public ListNominasMecanicoGeneral(Long mecanicoID) {
	this.mecanicoID = mecanicoID;
    }

    @Override
    public List<Nomina> execute() throws BusinessException {
	Mecanico mecanico = MecanicoFinder.findById(mecanicoID);
	List<Nomina> nominas = NominasFinder
		.findNominasGeneralMecanico(mecanico);
	if (nominas.size() == 0)
	    throw new BusinessException(
		    "El mecánico no tiene ninguna nómina asociada");
	return nominas;
    }
}

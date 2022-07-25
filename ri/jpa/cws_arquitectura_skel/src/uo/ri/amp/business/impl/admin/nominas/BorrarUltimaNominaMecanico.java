package uo.ri.amp.business.impl.admin.nominas;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.Nomina;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.NominasFinder;
import uo.ri.amp.persistence.util.Jpa;

public class BorrarUltimaNominaMecanico implements Command {
    private Long mecanicoID;

    /**
     * Constructor de la clase
     * 
     * @param mecanicoID
     */
    public BorrarUltimaNominaMecanico(Long mecanicoID) {
	this.mecanicoID = mecanicoID;
    }

    @Override
    public Object execute() throws BusinessException {
	Mecanico m = Jpa.getManager().find(Mecanico.class, mecanicoID);
	if (m == null)
	    throw new BusinessException(
		    "El mecánico introducido no se encuentra registrado");
	Long numeroNominasMecanico = NominasFinder
		.contarNominasMecanico(m);
	if (numeroNominasMecanico == 0)
	    throw new BusinessException(
		    "El mecánico no tiene ninguna nómina asociada");
	Nomina n = NominasFinder.findUltimaNominaMecanico(m);

	Jpa.getManager().remove(n);
	
	return null;
    }

}

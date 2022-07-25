package uo.ri.amp.business.impl.admin.mecanico;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.util.Jpa;

public class DeleteMechanic implements Command {

    private Long idMecanico;

    /**
     * Contructor de la clase
     * 
     * @param idMecanico
     */
    public DeleteMechanic(Long idMecanico) {
	this.idMecanico = idMecanico;
    }

    @Override
    public Object execute() throws BusinessException {
	Mecanico mecanico = Jpa.getManager().find(Mecanico.class, idMecanico);
	comprobarExisteMecanico(mecanico);

	if (mecanico.isEraseable())
	    Jpa.getManager().remove(mecanico);
	else {
	    throw new BusinessException("No puede borrarse el mecánico");
	}

	return null;
    }

    /**
     * Método que comprueba si el mecánico introducido existe dentro de la base
     * 
     * @param m
     * @throws BusinessException
     */
    private void comprobarExisteMecanico(Mecanico m) throws BusinessException {
	if (m == null)
	    throw new BusinessException(
		    "El mecánico introducido no está registrado");

    }
}

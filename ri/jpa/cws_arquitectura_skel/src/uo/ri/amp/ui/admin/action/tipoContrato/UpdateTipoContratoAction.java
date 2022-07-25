package uo.ri.amp.ui.admin.action.tipoContrato;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.TipoContrato;
import uo.ri.amp.model.exception.BusinessException;
import alb.util.console.Console;
import alb.util.menu.Action;

public class UpdateTipoContratoAction implements Action {

    @Override
    public void execute() throws BusinessException {
	// Pedir datos
	Long id = Console.readLong("Id del tipo de contrato");
	String nombre = Console.readString("Nombre");
	Integer indemnizacion = Console.readInt("Indenización");

	// Procesar
	AdminService as = ServicesFactory.getAdminService();

	TipoContrato t = as.findTipoContratoByID(id);
	System.out.println(t.toString());
	t.setNombre(nombre);
	t.setIndemnizacion(indemnizacion);

	as.updateTipoContrato(t);

	// Mostrar resultado
	Console.println("Tipo de contrato actualizado");
    }
}

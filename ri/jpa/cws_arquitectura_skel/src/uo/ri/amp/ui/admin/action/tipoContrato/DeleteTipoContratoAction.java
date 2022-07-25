package uo.ri.amp.ui.admin.action.tipoContrato;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.exception.BusinessException;
import alb.util.console.Console;
import alb.util.menu.Action;

public class DeleteTipoContratoAction implements Action {

    @Override
    public void execute() throws BusinessException {
	Long idTipo = Console.readLong("Id del tipo de contrato");

	AdminService as = ServicesFactory.getAdminService();

	as.deleteTipoContrato(idTipo);

	Console.println("Se ha eliminado el tipo de contrato");
    }
}
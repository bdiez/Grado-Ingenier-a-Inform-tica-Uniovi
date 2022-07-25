package uo.ri.amp.ui.admin.action.mecanico;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.exception.BusinessException;
import alb.util.console.Console;
import alb.util.menu.Action;

public class DeleteMechanicAction implements Action {

    @Override
    public void execute() throws BusinessException {
	Long idMecanico = Console.readLong("Id de mecánico");

	AdminService as = ServicesFactory.getAdminService();

	as.deleteMechanic(idMecanico);

	Console.println("Se ha eliminado el mecánico");
    }

 }

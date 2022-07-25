package uo.ri.amp.ui.admin.action.mecanico;

import java.util.List;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.ui.util.Printer;
import alb.util.console.Console;
import alb.util.menu.Action;

public class ListAllMechanicsAction implements Action {

    @Override
    public void execute() throws BusinessException {

	AdminService as = ServicesFactory.getAdminService();
	List<Mecanico> mechanics = as.findAllMechanics();

	Console.println("\nListado de todos lo mecánicos registrados\n");
	for (Mecanico m : mechanics) {
	    Printer.printMechanic(m);
	}

    }
}

package uo.ri.amp.ui.admin.action.nominas;

import uo.ri.amp.conf.ServicesFactory;
import alb.util.console.Console;
import alb.util.menu.Action;

public class GenerarNominasAction implements Action {

    @Override
    public void execute() throws Exception {
	ServicesFactory.getAdminService().generarNominas();

	Console.println("Nominas generadas");

    }

}

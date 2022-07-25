package uo.ri.amp.ui.admin.action.nominas;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.conf.ServicesFactory;
import alb.util.console.Console;
import alb.util.menu.Action;

public class BorrarUltimaNominaMecanicoAction implements Action {

    @Override
    public void execute() throws Exception {
	Long idMecanico = Console.readLong("id del mecánico");
	AdminService as = ServicesFactory.getAdminService();

	as.deleteNominasMecanico(idMecanico);

	Console.println("Se ha eliminado la nomina del mecanico");

    }

}

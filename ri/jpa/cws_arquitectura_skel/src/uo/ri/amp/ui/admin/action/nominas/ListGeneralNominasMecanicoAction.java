package uo.ri.amp.ui.admin.action.nominas;

import java.util.List;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Nomina;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.ui.util.Printer;
import alb.util.console.Console;
import alb.util.menu.Action;

public class ListGeneralNominasMecanicoAction implements Action {

    @Override
    public void execute() throws BusinessException {
	Long idMecanico = Console.readLong("id del mecanico");
	AdminService as = ServicesFactory.getAdminService();
	List<Nomina> nominas = as.listNominasGeneralMecanico(idMecanico);
	Console.println("\nListado de nóminas de un mecánico\n");

	double brutoTotal = 0;
	for (Nomina n : nominas) {
	    Printer.printNominaGeneral(n);
	    brutoTotal += n.getSalarioBase();
	}
	Console.println("Total bruto: " + brutoTotal);

    }

}

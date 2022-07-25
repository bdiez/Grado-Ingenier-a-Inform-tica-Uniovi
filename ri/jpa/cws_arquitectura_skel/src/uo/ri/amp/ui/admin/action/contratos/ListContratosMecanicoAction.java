package uo.ri.amp.ui.admin.action.contratos;

import java.util.List;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Contrato;
import uo.ri.amp.ui.util.Printer;
import alb.util.console.Console;
import alb.util.menu.Action;

public class ListContratosMecanicoAction implements Action {

    @Override
    public void execute() throws Exception {
	Long idMecanico = Console.readLong("id del mecanico");
	AdminService as = ServicesFactory.getAdminService();
	List<Contrato> contratos = as.findContratosMecanico(idMecanico);

	Console.println("\nListado de \n");
	for (Contrato contrato : contratos) {
	    Printer.printContrato(contrato);
	}

    }

}

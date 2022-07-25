package uo.ri.amp.ui.admin.action.tipoContrato;

import java.util.List;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Contrato;
import uo.ri.amp.ui.util.Printer;
import alb.util.console.Console;
import alb.util.menu.Action;

public class ListTrabajadoresPorTipoContratoAction implements Action {

    @Override
    public void execute() throws Exception {
	Long idTipo = Console.readLong("id del tipo");
	AdminService as = ServicesFactory.getAdminService();
	List<Contrato> contratos = as.listTrabajadoresPorTipoDeContrato(idTipo);

	Console.println("\nListado de trabajadores por tipo de contrato\n");
	double totalSalario = 0;
	int numeroMecanicos = 0;
	for (Contrato c : contratos) {
	    Printer.printMechanic(c.getMecanico());
	    totalSalario += c.getSalario();
	    numeroMecanicos++;

	}
	Console.println("Total salario: " + totalSalario
		+ "\tNúmero mecanicos: " + numeroMecanicos);

    }

}

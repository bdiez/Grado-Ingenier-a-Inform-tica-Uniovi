package uo.ri.amp.ui.admin.action.tipoContrato;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.TipoContrato;
import alb.util.console.Console;
import alb.util.menu.Action;

public class AddTipoContratoAction implements Action {

    @Override
    public void execute() throws Exception {

	// Pedir datos
	String nombreDelTipo = Console.readString("Nombre del tipo");
	Integer numeroDias = Console.readInt("Número días");

	// Procesar
	AdminService as = ServicesFactory.getAdminService();
	as.addTipoContrato(new TipoContrato(nombreDelTipo, numeroDias));

	// Mostrar resultado
	Console.println("Nuevo tipo de contrato añadido");

    }

}

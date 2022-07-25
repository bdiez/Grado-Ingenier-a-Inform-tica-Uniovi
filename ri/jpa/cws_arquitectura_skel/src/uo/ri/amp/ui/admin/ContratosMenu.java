package uo.ri.amp.ui.admin;

import uo.ri.amp.ui.admin.action.contratos.AddContratosAction;
import uo.ri.amp.ui.admin.action.contratos.DeleteContratoAction;
import uo.ri.amp.ui.admin.action.contratos.LiquidacionContratosMecanicoAction;
import uo.ri.amp.ui.admin.action.contratos.ListContratosMecanicoAction;
import uo.ri.amp.ui.admin.action.contratos.UpdateContratosAction;
import alb.util.menu.BaseMenu;

public class ContratosMenu extends BaseMenu {
    public ContratosMenu() {
	menuOptions = new Object[][] {
		{ "Administrador > Gestión de contratos", null },

		{ "Añadir contrato", AddContratosAction.class },
		{ "Modificar los datos de un contrato",
			UpdateContratosAction.class },
		{ "Eliminar contrato", DeleteContratoAction.class },
		{ "Listar contrato", ListContratosMecanicoAction.class },
		{ "Liquidación de un contrato",
			LiquidacionContratosMecanicoAction.class } };
    }

}

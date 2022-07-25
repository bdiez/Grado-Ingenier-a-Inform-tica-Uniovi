package uo.ri.amp.ui.admin;

import uo.ri.amp.ui.admin.action.nominas.BorrarUltimaNominaMecanicoAction;
import uo.ri.amp.ui.admin.action.nominas.GenerarNominasAction;
import uo.ri.amp.ui.admin.action.nominas.ListEspecificoNominasMecanicoAction;
import uo.ri.amp.ui.admin.action.nominas.ListGeneralNominasMecanicoAction;
import alb.util.menu.BaseMenu;

public class NominasMenu extends BaseMenu {
    public NominasMenu() {
	menuOptions = new Object[][] {
		{ "Administrador > Gestión de nóminas", null },

		{ "Generar nóminas", GenerarNominasAction.class },
		{ "Eliminar última nómina mecanico",
			BorrarUltimaNominaMecanicoAction.class },
		{ "Listado general nóminas de un mecanico",
			ListGeneralNominasMecanicoAction.class },
		{ "Listar  especifico nóminas de un mecanico",
			ListEspecificoNominasMecanicoAction.class } };
    }

}

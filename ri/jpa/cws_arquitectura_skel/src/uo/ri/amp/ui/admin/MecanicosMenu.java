package uo.ri.amp.ui.admin;

import uo.ri.amp.ui.admin.action.mecanico.AddMechanicAction;
import uo.ri.amp.ui.admin.action.mecanico.DeleteMechanicAction;
import uo.ri.amp.ui.admin.action.mecanico.ListAllMechanicsAction;
import uo.ri.amp.ui.admin.action.mecanico.ListMechanicsContratoAction;
import uo.ri.amp.ui.admin.action.mecanico.UpdateMechanicAction;
import alb.util.menu.BaseMenu;

public class MecanicosMenu extends BaseMenu {

    public MecanicosMenu() {
	menuOptions = new Object[][] {
		{ "Administrador > Gestión de mecánicos", null },

		{ "Añadir mecánico", AddMechanicAction.class },
		{ "Modificar datos de mecánico", UpdateMechanicAction.class },
		{ "Eliminar mecánico", DeleteMechanicAction.class },
		{ "Listar todos mecánicos", ListAllMechanicsAction.class },
		{ "Listar mecánicos con contrato",
			ListMechanicsContratoAction.class } };
    }

}

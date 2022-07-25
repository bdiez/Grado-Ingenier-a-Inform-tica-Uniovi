package uo.ri.amp.ui.admin;

import uo.ri.amp.ui.admin.action.tipoContrato.AddTipoContratoAction;
import uo.ri.amp.ui.admin.action.tipoContrato.DeleteTipoContratoAction;
import uo.ri.amp.ui.admin.action.tipoContrato.ListTrabajadoresPorTipoContratoAction;
import uo.ri.amp.ui.admin.action.tipoContrato.UpdateTipoContratoAction;
import alb.util.menu.BaseMenu;

public class TipoContratoMenu extends BaseMenu {
    public TipoContratoMenu() {
	menuOptions = new Object[][] {
		{ "Administrador > Gestión de tipos de contrato", null },

		{ "Añadir tipo de contrato", AddTipoContratoAction.class },
		{ "Lista Trabajadores por tipo de contrato",
			ListTrabajadoresPorTipoContratoAction.class },
		{ "Eliminar tipo de contrato", DeleteTipoContratoAction.class },
		{ "Modificar tipo de contrato", UpdateTipoContratoAction.class } };
    }
}

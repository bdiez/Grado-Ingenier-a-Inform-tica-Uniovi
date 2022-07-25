package uo.ri.amp.ui.admin;

import alb.util.menu.BaseMenu;
import alb.util.menu.NotYetImplementedAction;

public class CategoriasMenu extends BaseMenu {
	public CategoriasMenu() {
		menuOptions = new Object[][] {
				{ "Administrador > Gestión de categorias", null },

				{ "Añadir categoria", NotYetImplementedAction.class },
				{ "Actualizar categoria", NotYetImplementedAction.class },
				{ "Borrar categoria", NotYetImplementedAction.class },
				{ "Listar categorias", NotYetImplementedAction.class }, };
	}
}

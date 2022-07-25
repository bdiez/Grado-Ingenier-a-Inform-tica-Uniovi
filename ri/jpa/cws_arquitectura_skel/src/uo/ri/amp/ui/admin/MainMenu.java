package uo.ri.amp.ui.admin;

import alb.util.menu.BaseMenu;

public class MainMenu extends BaseMenu {

    public MainMenu() {
	menuOptions = new Object[][] { { "Administrador", null },
		{ "Gestión de mecánicos", MecanicosMenu.class },
		{ "Gestión de repuestos", RepuestosMenu.class },
		{ "Gestión de tipos de vehículo", TiposVehiculoMenu.class },
		{ "Gestión de contratos", ContratosMenu.class },
		{ "Gestión de nóminas", NominasMenu.class },
		{ "Gestión de tipos de contrato", TipoContratoMenu.class },
		{ "Gestión de categorias", CategoriasMenu.class } };
    }

    public static void main(String[] args) {
	try {
	    new MainMenu().execute();
	} catch (RuntimeException e) {
	    throw new RuntimeException("Error de conexión con la base");

	}
    }

}

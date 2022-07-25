package uo.ri.amp.ui.admin.action.contratos;

import java.util.Date;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.conf.ServicesFactory;
import alb.util.console.Console;
import alb.util.date.DateUtil;
import alb.util.menu.Action;

public class AddContratosAction implements Action {

    @Override
    public void execute() throws Exception {
	// Pedir datos
	String fechaInicio = Console.readString("fecha inicio");
	String fechaFin = Console.readString("fecha fin");
	Double salario = Console.readDouble("salario");
	Long mecanicoID = Console.readLong("mecanico ID");
	Long categoriaID = Console.readLong("Categoria ID");
	Long tipoContratoID = Console.readLong("Tipo contrato ID");
	Date fechaFinContrato = DateUtil.fromString(fechaFin);
	Date fechaInicioContrato = DateUtil.fromString(fechaInicio);

	// Procesar
	AdminService as = ServicesFactory.getAdminService();

	as.addContrato(mecanicoID, categoriaID, tipoContratoID, salario, fechaInicioContrato,
		fechaFinContrato);

	// Mostrar resultado
	Console.println("Nuevo contrato añadido");

    }

}

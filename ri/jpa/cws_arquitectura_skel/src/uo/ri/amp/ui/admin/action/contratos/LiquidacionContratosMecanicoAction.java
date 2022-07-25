package uo.ri.amp.ui.admin.action.contratos;

import java.util.Date;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.conf.ServicesFactory;
import alb.util.console.Console;
import alb.util.date.DateUtil;
import alb.util.menu.Action;

public class LiquidacionContratosMecanicoAction implements Action {

    @Override
    public void execute() throws Exception {
	//Pedir datos
	Long idContrato = Console.readLong("id del mecanico");
	String fecha = Console.readString("fecha liquidación");
	Date fechaLiquidacion = DateUtil.fromString(fecha);
	// Procesar
	AdminService as = ServicesFactory.getAdminService();
	as.liquidarContrato(idContrato, fechaLiquidacion);
			
	// Mostrar resultado
	Console.println("Contrato liquidado");

    }

}

package uo.ri.amp.ui.admin.action.contratos;

import java.util.Date;
import java.util.List;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.ui.util.Printer;
import alb.util.console.Console;
import alb.util.date.DateUtil;
import alb.util.menu.Action;

public class UpdateContratosAction implements Action {

    @Override
    public void execute() throws BusinessException {
	listarContratos();
	// Pedir datos
	Long id = Console.readLong("Id del contrato");

	// Procesar
	AdminService as = ServicesFactory.getAdminService();

	Contrato c = as.findContratoBy(id);
	if (c == null)
	    throw new BusinessException("El contrato no existe");
	String fechaIni = Console.readString("Fecha inicio contrato");
	String fecha = Console.readString("Fecha fin contrato");
	Date fechaInicio = DateUtil.fromString(fechaIni);
	Date fechaFin = DateUtil.fromString(fecha);
	Double salario = Console.readDouble("Salario");
	
	c.setFechaInicio(fechaInicio);
	c.setFechaFin(fechaFin);
	c.setSalario(salario);
	as.updateContrato(c);

	// Mostrar resultado
	Console.println("Contrato actualizado");

    }
    /**
     * Método que lista todos los contratos
     * @throws BusinessException 
     */
    private void listarContratos() throws BusinessException {
	AdminService as = ServicesFactory.getAdminService();
	List<Contrato> contratos = as.findAllContratos();
	for (Contrato contrato : contratos) {
	    Printer.printContrato(contrato);
	}
	
    }

}

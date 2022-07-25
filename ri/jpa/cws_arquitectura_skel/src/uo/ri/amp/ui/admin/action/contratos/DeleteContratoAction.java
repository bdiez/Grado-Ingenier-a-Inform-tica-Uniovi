package uo.ri.amp.ui.admin.action.contratos;

import java.util.List;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.ui.util.Printer;
import alb.util.console.Console;
import alb.util.menu.Action;

public class DeleteContratoAction implements Action {

    @Override
    public void execute() throws BusinessException {
	listarContratos();
	Long idContrato = Console.readLong("Id de Contrato");

	AdminService as = ServicesFactory.getAdminService();

	if (as.findContratoBy(idContrato) == null)
	    throw new BusinessException("El contrato no se ha encontrado");
	as.deleteContrato(idContrato);

	Console.println("Se ha eliminado el contrato");
    }

    /**
     * Método que lista todos los contratos
     * 
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

package uo.ri.amp.business.impl;

import java.util.Date;
import java.util.List;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.business.impl.admin.contrato.AniadirContrato;
import uo.ri.amp.business.impl.admin.contrato.DeleteContrato;
import uo.ri.amp.business.impl.admin.contrato.FindAllContratos;
import uo.ri.amp.business.impl.admin.contrato.FindContratoById;
import uo.ri.amp.business.impl.admin.contrato.FindContratoMecanicos;
import uo.ri.amp.business.impl.admin.contrato.LiquidacionContrato;
import uo.ri.amp.business.impl.admin.mecanico.AddMechanic;
import uo.ri.amp.business.impl.admin.mecanico.DeleteMechanic;
import uo.ri.amp.business.impl.admin.mecanico.FindAllMechanics;
import uo.ri.amp.business.impl.admin.mecanico.FindMecanicosConContrato;
import uo.ri.amp.business.impl.admin.mecanico.FindMechanicById;
import uo.ri.amp.business.impl.admin.nominas.BorrarUltimaNominaMecanico;
import uo.ri.amp.business.impl.admin.nominas.GenerarNominas;
import uo.ri.amp.business.impl.admin.nominas.ListNominasMecanicoGeneral;
import uo.ri.amp.business.impl.admin.tipoContrato.DeleteTipoContrato;
import uo.ri.amp.business.impl.admin.tipoContrato.FindTipoContratoById;
import uo.ri.amp.business.impl.admin.tipoContrato.ListTrabajadoresPorTipoContrato;
import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.Nomina;
import uo.ri.amp.model.TipoContrato;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.util.Jpa;

public class AdminServiceImpl implements AdminService {
    CommandExecutor executor = new CommandExecutor();

    @Override
    public void newMechanic(final Mecanico mecanico) throws BusinessException {
	executor.execute(new AddMechanic(mecanico));
    }

    @Override
    public void updateMechanic(final Mecanico mecanico)
	    throws BusinessException {
	executor.execute(new Command() {

	    @Override
	    public Object execute() throws BusinessException {
		Jpa.getManager().merge(mecanico);
		return null;
	    }
	});
    }

    @Override
    public void deleteMechanic(Long idMecanico) throws BusinessException {
	executor.execute(new DeleteMechanic(idMecanico));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Mecanico> findAllMechanics() throws BusinessException {
	return (List<Mecanico>) executor.execute(new FindAllMechanics());
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Mecanico> findContratoMechanics() throws BusinessException {
	return (List<Mecanico>) executor
		.execute(new FindMecanicosConContrato());
    }

    @Override
    public Mecanico findMechanicById(Long id) throws BusinessException {
	return (Mecanico) executor.execute(new FindMechanicById(id));
    }

    @Override
    public void addTipoContrato(final TipoContrato tipoContrato)
	    throws BusinessException {
	executor.execute(new Command() {

	    @Override
	    public Object execute() throws BusinessException {
		Jpa.getManager().persist(tipoContrato);
		return null;
	    }
	});

    }

    @Override
    public TipoContrato findTipoContratoByID(Long id) throws BusinessException {
	return (TipoContrato) executor.execute(new FindTipoContratoById(id));
    }

    @Override
    public void updateTipoContrato(final TipoContrato tipoContrato)
	    throws BusinessException {
	executor.execute(new Command() {

	    @Override
	    public Object execute() throws BusinessException {
		Jpa.getManager().merge(tipoContrato);
		return null;
	    }
	});

    }

    @Override
    public void deleteTipoContrato(Long idTipo) throws BusinessException {
	executor.execute(new DeleteTipoContrato(idTipo));

    }

    // Gestion de contratos

    @Override
    public void addContrato(final Long mecanicoID, final Long categoriaID,
	    final Long tipoContratoID, final Double salario, final Date fechaInicioContrato,
	    final Date fechaFinContrato) throws BusinessException {
	executor.execute(new AniadirContrato(mecanicoID, categoriaID,
		tipoContratoID, salario,fechaInicioContrato, fechaFinContrato));
    }

    @Override
    public Contrato findContratoBy(Long id) throws BusinessException {
	return (Contrato) executor.execute(new FindContratoById(id));
    }

    @Override
    public void updateContrato(final Contrato contrato)
	    throws BusinessException {
	executor.execute(new Command() {

	    @Override
	    public Object execute() throws BusinessException {
		Jpa.getManager().merge(contrato);
		return null;
	    }
	});

    }

    @Override
    public void deleteContrato(Long idContrato) throws BusinessException {
	executor.execute(new DeleteContrato(idContrato));

    }

    @Override
    public void generarNominas() throws BusinessException {
	executor.execute(new GenerarNominas());

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Contrato> findContratosMecanico(Long idMecanico)
	    throws BusinessException {
	return (List<Contrato>) executor.execute(new FindContratoMecanicos(
		idMecanico));
    }

    @Override
    public void deleteNominasMecanico(Long mecanicoID) throws BusinessException
    {
	executor.execute(new BorrarUltimaNominaMecanico(mecanicoID));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Contrato> listTrabajadoresPorTipoDeContrato(Long idTipo)
	    throws BusinessException {
	return (List<Contrato>) executor
		.execute(new ListTrabajadoresPorTipoContrato(idTipo));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Nomina> listNominasGeneralMecanico(Long idMecanico)
	    throws BusinessException {
	return (List<Nomina>) executor.execute(new ListNominasMecanicoGeneral(
		idMecanico));
    }

    @Override
    public void liquidarContrato(Long mecanicoID, Date fechaLiquidacion) throws BusinessException {
	executor.execute(new LiquidacionContrato(mecanicoID,fechaLiquidacion));

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Contrato> findAllContratos() throws BusinessException {
	return (List<Contrato>) executor.execute(new FindAllContratos());
    }

   

}

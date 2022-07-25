package uo.ri.amp.business.impl.admin.contrato;

import java.util.Calendar;
import java.util.Date;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.model.types.ContratoStatus;
import uo.ri.amp.persistence.ContratoFinder;
import uo.ri.amp.persistence.util.Jpa;

public class LiquidacionContrato implements Command {
    private Long mecanicoID;
    private Date fechaLiquidacion;

    public LiquidacionContrato(Long mecanicoID, Date fechaLiquidacion) {
	this.mecanicoID = mecanicoID;
	this.fechaLiquidacion = fechaLiquidacion;
    }

    @Override
    public Object execute() throws BusinessException {
	Calendar fechaInicioContrato = Calendar.getInstance();
	Calendar fechaLiquidacionCalendar = Calendar.getInstance();
	fechaLiquidacionCalendar.setTime(fechaLiquidacion);
	Mecanico mecanico = Jpa.getManager().find(Mecanico.class, mecanicoID);
	comprobarExisteMecanico(mecanico);
	Contrato contrato = ContratoFinder.buscarActivoPorMecanico(mecanico);
	comprobarExisteContrato(contrato);

	Double liquidacion = contrato.calcularLiquidacion(contrato
		.getTipoContrato().getIndemnizacion());
	contrato.setActivo(ContratoStatus.EXTINTO);
	contrato.setFechaLiquidacion(fechaLiquidacion);
	fechaInicioContrato.setTime(contrato.getFechaInicio());
	int duracionContrato = calcularDuracionContrato(fechaInicioContrato,
		fechaLiquidacionCalendar);
	liquidacion = (duracionContrato >= 1) ? liquidacion : 0.0;
	contrato.setLiquidacion(liquidacion);
	return null;
    }

    /**
     * Método que calcula la duración en años del contrato
     * 
     * @param fechaInicioContrato
     * @param fechaLiquidacion
     * @return número de años que duró el contrato
     */
    private int calcularDuracionContrato(Calendar fechaInicioContrato,
	    Calendar fechaLiquidacion) {
	return fechaLiquidacion.get(Calendar.YEAR)
		- fechaInicioContrato.get(Calendar.YEAR);
    }

    /**
     * Método que comprueba si el mecánico introducido existe dentro de la base
     * 
     * @param m
     * @throws BusinessException
     */
    private void comprobarExisteMecanico(Mecanico m) throws BusinessException {
	if (m == null)
	    throw new BusinessException(
		    "El mecánico introducido no está registrado");
	comprobarNumNominas(m);
    }

    /**
     * Método que comprueba si el contrato introducido existe dentro de la base
     * 
     * @param c
     * @throws BusinessException
     */
    private void comprobarExisteContrato(Contrato c) throws BusinessException {
	if (c == null)
	    throw new BusinessException(
		    "El contrato introducido no está registrado");

    }
    /**
     * Metodo que comprueba si el mecanico tiene nominas activas
     * @param mecanico
     * @throws BusinessException
     */
    private void comprobarNumNominas(Mecanico mecanico) throws BusinessException {
	Long numNominas = ContratoFinder.contarContratosActivos(mecanico);
	if (numNominas == 0)
	    throw new BusinessException("El mecánico no tiene nóminas activas");
    }
}

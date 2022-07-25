package uo.ri.amp.business.impl.admin.contrato;

import java.util.Date;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Categoria;
import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.TipoContrato;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.model.types.ContratoStatus;
import uo.ri.amp.persistence.ContratoFinder;
import uo.ri.amp.persistence.util.Jpa;

public class AniadirContrato implements Command {
    private Long mecanicoID;
    private Long categoriaID;
    private Long tipoContratoID;
    private double salario;
    private Date fechaInicioContrato;
    private Date fechaFinContrato;

    /**
     * Contructor de la clase
     * 
     * @param mecanicoID
     * @param categoriaID
     * @param tipoContratoID
     * @param salario
     * @param fechaFinContrato
     */

    public AniadirContrato(Long mecanicoID, Long categoriaID,
	    Long tipoContratoID, double salario, Date fechaInicioContrato,
	    Date fechaFinContrato) {
	this.mecanicoID = mecanicoID;
	this.categoriaID = categoriaID;
	this.tipoContratoID = tipoContratoID;
	this.salario = salario;
	this.fechaInicioContrato = fechaInicioContrato;
	this.fechaFinContrato = fechaFinContrato;
    }

    @Override
    public Object execute() throws BusinessException {
	Mecanico m = Jpa.getManager().find(Mecanico.class, mecanicoID);
	comprobarExisteMecanico(m);
	Categoria c = Jpa.getManager().find(Categoria.class, categoriaID);
	comprobarExisteCategoria(c);
	TipoContrato tc = Jpa.getManager().find(TipoContrato.class,
		tipoContratoID);
	comprobarExisteTipoContrato(tc);
	if (ContratoFinder.contarContratosActivos(m) != 0)
	    ponerContratoPrevioAExtinto(m);

	Contrato con = new Contrato(m, c, tc, salario, fechaInicioContrato,
		fechaFinContrato);
	Jpa.getManager().persist(con);
	return null;

    }

    /**
     * Método que comprueba si el tipo de contrato se encuentra en la base
     * 
     * @param tc
     * @throws BusinessException
     */
    private void comprobarExisteTipoContrato(TipoContrato tc)
	    throws BusinessException {
	if (tc == null)
	    throw new BusinessException(
		    "El tipo de contrato introducido no está registrado");

    }

    /**
     * Método que comprueba si la categoria introducida existe dentro de la base
     * 
     * @param c
     * @throws BusinessException
     */

    private void comprobarExisteCategoria(Categoria c) throws BusinessException {
	if (c == null)
	    throw new BusinessException(
		    "La categoria introducida no está registrada");

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

    }

    /**
     * Método que pone el anterior contrato de un mecánico como extinto
     * 
     * @param m
     *            mecánico del que se desea poner el contrato a extinto
     */
    private void ponerContratoPrevioAExtinto(Mecanico m) {
	Contrato c = ContratoFinder.buscarActivoPorMecanico(m);
	if (c != null && c.getActivo() == ContratoStatus.ACTIVO)
	    c.setActivo(ContratoStatus.EXTINTO);

    }

}

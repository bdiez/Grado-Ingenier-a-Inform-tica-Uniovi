package uo.ri.amp.business;

import java.util.Date;
import java.util.List;

import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.Nomina;
import uo.ri.amp.model.TipoContrato;
import uo.ri.amp.model.exception.BusinessException;

public interface AdminService {

    /**
     * Método que crea un mecanico nuevo
     * 
     * @param mecanico
     * @throws BusinessException
     */
    void newMechanic(Mecanico mecanico) throws BusinessException;

    /**
     * Método que elimina un mecanico
     * 
     * @param idMecanico
     * @throws BusinessException
     */
    void deleteMechanic(Long idMecanico) throws BusinessException;

    /**
     * Método que actualiza la informacion de un mecanico
     * 
     * @param mecanico
     * @throws BusinessException
     */
    void updateMechanic(Mecanico mecanico) throws BusinessException;

    /**
     * Método que busca todos los mecanicos con contrato en vigor
     * 
     * @return mecanicos con contrato en vigor
     * @throws BusinessException
     */
    List<Mecanico> findContratoMechanics() throws BusinessException;

    /**
     * Método qee busca un mecanico por su id
     * 
     * @param id
     * @return
     * @throws BusinessException
     */
    Mecanico findMechanicById(Long id) throws BusinessException;

    /**
     * Método que devuelve todos los mecanicos
     * 
     * @return
     * @throws BusinessException
     */
    List<Mecanico> findAllMechanics() throws BusinessException;

    // TIPOS DE CONTRATO
    /**
     * Añade un nuevo tipo de contrato
     * 
     * @param tipoContrato
     * @throws BusinessException
     */
    void addTipoContrato(TipoContrato tipoContrato) throws BusinessException;

    /**
     * Busca un tipo de contrato segun su id
     * 
     * @param id
     * @return
     * @throws BusinessException
     */
    TipoContrato findTipoContratoByID(Long id) throws BusinessException;

    /**
     * Actualiza la informacion de un tipo de contrato
     * 
     * @param t
     * @throws BusinessException
     */
    void updateTipoContrato(TipoContrato t) throws BusinessException;

    /**
     * Método que elimina un tipo de contrato si no tiene asocidos contratos
     * 
     * @param idTipo
     * @throws BusinessException
     */
    void deleteTipoContrato(Long idTipo) throws BusinessException;

    /**
     * Añade un nuevo contrato
     * 
     * @param salario
     * @param tipoContratoID
     * @param categoriaID
     * @param contrato
     * @throws BusinessException
     */
    /**
     * Método que lista los trabajadores de un tipo de contrato concreto
     * 
     * @param idTipo
     *            tipo del que se quieren mostrar los trabajadores
     * @return lista de contratos de ese mecánico
     * @throws BusinessException
     */
    List<Contrato> listTrabajadoresPorTipoDeContrato(Long idTipo)
	    throws BusinessException;

    // CONTRATOS
    void addContrato(Long mecanicoID, Long categoriaID, Long tipoContratoID,
	    Double salario, Date fechaInicioContrato, Date fechaFinContrato) throws BusinessException;

    /**
     * Metdo que busca un contrato segun su id
     * 
     * @param id
     * @return contrato buscado
     * @throws BusinessException
     */
    Contrato findContratoBy(Long id) throws BusinessException;

    /**
     * Método que actualiza la informacion de un determinado contrato
     * 
     * @param c
     *            contrato a modificar
     * @throws BusinessException
     */
    void updateContrato(Contrato c) throws BusinessException;

    /**
     * Método que elimina un contrato determinado
     * 
     * @param idContrato
     * @throws BusinessException
     */
    void deleteContrato(Long idContrato) throws BusinessException;

    /**
     * Método que liquida un contrato a petición del administrador
     * 
     * @param mecanicoID
     *            del contrato que se quiere liquidar
     * @param fechaLiquidacion 
     * @throws BusinessException
     */
    void liquidarContrato(Long mecanicoID, Date fechaLiquidacion) throws BusinessException;

    /**
     * Método que lista los contratos de un mecanico
     * 
     * @return contratos de ese mecanico
     * @throws BusinessException
     */
    List<Contrato> findContratosMecanico(Long idMecanico)
	    throws BusinessException;

    // NOMINAS
    /**
     * Método que genera nominas de manera automatica
     * 
     * @throws BusinessException
     */
    void generarNominas() throws BusinessException;

    /**
     * Elimna la ultima nomina de un mecanico
     * 
     * @param mecanico
     * @return
     * @throws BusinessException
     */

    void deleteNominasMecanico(Long mecanicoID) throws BusinessException;

    /**
     * Listado general de las nóminas de un mecanico
     * 
     * @param idMecanico
     *            mécanico del que se quieren mostrar las nominas
     * @return listado de las nominas de ese mecánico
     * @throws BusinessException
     */
    List<Nomina> listNominasGeneralMecanico(Long idMecanico)
	    throws BusinessException;
    /**
     * Metodo que lista todos los contratos
     * @return
     * @throws BusinessException 
     */
    List<Contrato> findAllContratos() throws BusinessException;
}

package uo.ri.amp.business.impl.admin.nominas;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.Nomina;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.ContratoFinder;
import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.amp.persistence.NominasFinder;
import uo.ri.amp.persistence.util.Jpa;

public class GenerarNominas implements Command {

    @Override
    public Object execute() throws BusinessException {
	Calendar hoy = new GregorianCalendar();
	Calendar fechaNomina = generarFechaNomina();
	List<Mecanico> mecanicos = MecanicoFinder.findConContrato();

	for (Mecanico mecanico : mecanicos) {
	    comprobarNoEstanGeneradas(mecanico, fechaNomina);
	    Contrato contrato = ContratoFinder
		    .buscarActivoPorMecanico(mecanico);
	    Nomina nomina = new Nomina(fechaNomina.getTime(), contrato);

	    nomina.setSalarioBase(contrato.getSalario());
	    nomina.asignarPagaExtra(hoy); // revisar que con esto va mejor

	    double porcentajePlusProductividad = contrato.getCategoria()
		    .getPlusProductividad();

	    double importeIntervenciones = mecanico
		    .calcularImporteIntervenciones(fechaNomina);

	    nomina.setPlusProductividad(importeIntervenciones
		    * porcentajePlusProductividad / 100);

	    double importeTrienio = contrato.calcularTrienios();
	    nomina.setTrienios(importeTrienio * contrato.calcularTrienios());

	    nomina.setDescuentosIRPF(nomina.calcularDescuentoIRPF()); // revisar
	    nomina.setDescuentoSS(nomina.calcularDescuentoSeguridadSocial());

	    Jpa.getManager().persist(nomina); // comprobar que sin esto funciona
	}

	return null;
    }

    /**
     * Método que comprueba que las nóminas no han sido generadas previamente
     * 
     * @param mecanico
     * @param fechaNomina
     * @throws BusinessException
     */
    private void comprobarNoEstanGeneradas(Mecanico mecanico,
	    Calendar fechaNomina) throws BusinessException {

	int anio = fechaNomina.get(Calendar.YEAR);
	int mes = fechaNomina.get(Calendar.MONTH);
	long numeroNominasMes = NominasFinder.contar(mes + 1, anio, mecanico);
	if (numeroNominasMes > 0)
	    throw new BusinessException(
		    "Las nominas ya fueron generadas previamente");
    }

    /**
     * Metodo que fija la fecha del próximo mes para la nómina
     * 
     * @return fecha de la nómina
     */
    private Calendar generarFechaNomina() {

	Calendar fecha = new GregorianCalendar();
	fecha.add(Calendar.MONTH, -1);
	return fecha;
    }

}

package uo.ri.amp.business.impl.admin.mecanico;

import java.util.List;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.persistence.MecanicoFinder;

public class FindAllMechanics implements Command {

    public List<Mecanico> execute() {

	return MecanicoFinder.findAll();

    }

}

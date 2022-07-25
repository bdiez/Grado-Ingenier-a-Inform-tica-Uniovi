package uo.ri.amp.business.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.util.Jpa;

public class CommandExecutor {

    public Object execute(Command command) throws BusinessException {

	EntityManager em = Jpa.createEntityManager();
	EntityTransaction trx = em.getTransaction();
	trx.begin();
	try {
	    Object res = command.execute();
	    trx.commit();
	    return res;
	} catch (BusinessException b) {
	    if (trx.isActive())
		trx.rollback();
	    throw b;
	} catch (PersistenceException pex) {
	    if (trx.isActive())
		trx.rollback();
	    throw pex;
	} finally {
	    em.close();
	}

    }

}

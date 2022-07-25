package uo.ri.amp.conf;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.business.impl.AdminServiceImpl;

public class ServicesFactory {

    public static AdminService getAdminService() {
	return new AdminServiceImpl();
    }

}

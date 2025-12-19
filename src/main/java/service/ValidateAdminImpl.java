package service;

import model.*;
import repo.*;
public class ValidateAdminImpl implements ValidateAdmin {

	ValidateAdminRepo var=new ValidateAdminRepoImpl();
	@Override
	public boolean verifyAdminLogin(Admin al) {
		
		return var.validateAdminLogin(al);
	}

}

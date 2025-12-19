package repo;
import java.sql.*;

import model.Admin;
import database.*;

public class ValidateAdminRepoImpl extends DbConfig implements ValidateAdminRepo {

	@Override
	public boolean validateAdminLogin(Admin al) {
		try {
			ps=con.prepareStatement("select * from admin where username=? and password=?");
			ps.setString(1,al.getUsername());
			ps.setString(2, al.getPassword());
			rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;

		}
	}
}

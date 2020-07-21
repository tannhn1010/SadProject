package tannhn.stress_project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tannhn.stress_project.config.DbConnectionUtils;
import tannhn.stress_project.dao.CustomerDao;
import tannhn.stress_project.dao.CustomerDaoImpl;
import tannhn.stress_project.entity.CustomerEntity;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DbConnectionUtils.getConnection();
		CustomerDao cusDao = new CustomerDaoImpl();
		List<CustomerEntity> listCus = new ArrayList<CustomerEntity>();
		listCus = cusDao.getAll();
		int count = 0;
		listCus.forEach(cus -> {
			System.out.println(cus.getName());
		});
		
		//Statement statement = DbConnectionUtils.conn.createStatement();
		//String sqlCommand = "UPDATE customer SET name='abc'";
		//int result = statement.executeUpdate(sqlCommand);
		//System.out.println(result);
		
		CustomerEntity cus = cusDao.getById(2);
		System.out.println(cus.getName());
		
		cus.setName("Tan Tan Tan");
		cus.setAddress("100 Ton Duc Thang");
		cus.setTeam("Contra");
		
		if(cusDao.update(cus)) {
			System.out.println("Update Successfull");
		}
		
		cusDao.delete(1);
	}

}

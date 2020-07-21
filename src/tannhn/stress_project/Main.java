package tannhn.stress_project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tannhn.stress_project.config.DbConnectionUtils;
import tannhn.stress_project.dao.CustomerDao;
import tannhn.stress_project.dao.DAO;
import tannhn.stress_project.entity.CustomerEntity;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DbConnectionUtils.getConnection();
		DAO dao = new CustomerDao();
		List<CustomerEntity> listCus = new ArrayList<CustomerEntity>();
		listCus = dao.getAll();
		int count = 0;
		listCus.forEach(cus -> {
			System.out.println(cus.getName());
		});
	}

}

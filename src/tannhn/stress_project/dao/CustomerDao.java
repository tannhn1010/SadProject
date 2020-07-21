package tannhn.stress_project.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import tannhn.stress_project.config.DbConnectionUtils;
import tannhn.stress_project.entity.CustomerEntity;

public class CustomerDao implements DAO<CustomerEntity> {
	public static Connection conn = DbConnectionUtils.conn;
	@Override
	public List<CustomerEntity> getAll() throws SQLException {
		List<CustomerEntity> listCus = new ArrayList<CustomerEntity>();
		Statement statement = conn.createStatement();
		String sqlCommand = "SELECT * FROM customer";
		ResultSet rs = statement.executeQuery(sqlCommand);
		
		while(rs.next()) {
			CustomerEntity cusEn = new CustomerEntity();
			cusEn.setId(rs.getInt(1));
			cusEn.setName(rs.getString(2));
			cusEn.setAddress(rs.getString(3));
			cusEn.setTeam(rs.getString(4));
			listCus.add(cusEn);
		}
		return listCus;
	}

	@Override
	public Optional getById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(CustomerEntity t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CustomerEntity t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CustomerEntity t) {
		// TODO Auto-generated method stub
		
	}

}

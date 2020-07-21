package tannhn.stress_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import tannhn.stress_project.config.DbConnectionUtils;
import tannhn.stress_project.entity.CustomerEntity;

public class CustomerDaoImpl implements CustomerDao {
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
	public CustomerEntity getById(int id) {
		String sql = "SELECT * FROM customer where id = ?";
		CustomerEntity cus = new CustomerEntity();
		try {
			PreparedStatement prepareStmt = conn.prepareStatement(sql);
			prepareStmt.setInt(1, id);
			ResultSet rs = prepareStmt.executeQuery();
			if (rs.next() != false) {
				cus.setId(rs.getInt(1));
				cus.setName(rs.getString(2));
				cus.setAddress(rs.getString(3));
				cus.setTeam(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cus;
	}

	@Override
	public boolean update(CustomerEntity t) {
		boolean result = true ;
		
		try {
			String sql = "UPDATE customer SET name = ?, address = ?, team = ? WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, t.getName());
			stmt.setString(2, t.getAddress());
			stmt.setString(3, t.getTeam());
			stmt.setInt(4, t.getId());
			int rs = stmt.executeUpdate();
			if(rs == 0) {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean delete(int id) {
		boolean result = true;
		
		try {
			String sql = "DELETE FROM customer WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			int rs = stmt.executeUpdate();
			if (rs == 0) {
				result = false;
			}
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		
		return result;
	}

}

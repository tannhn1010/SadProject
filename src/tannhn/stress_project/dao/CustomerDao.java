package tannhn.stress_project.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import tannhn.stress_project.entity.CustomerEntity;

public interface CustomerDao {
	List<CustomerEntity> getAll() throws SQLException;
	CustomerEntity getById(int id);
	boolean update(CustomerEntity t);
	boolean delete(int id);	
}
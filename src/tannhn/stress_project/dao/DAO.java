package tannhn.stress_project.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import tannhn.stress_project.entity.CustomerEntity;

public interface DAO<T> {
	List<T> getAll() throws SQLException;
	Optional getById();
	void save(T t);
	void update(T t);
	void delete(T t);	
}
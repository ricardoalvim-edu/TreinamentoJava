package br.com.fema.academicofx.dao.interfaces;

import java.sql.Connection;
import java.util.List;

public interface IGenericDAO<T> {
	public boolean insert(Connection conn, T object) throws Exception;
	public boolean update(Connection conn, T object) throws Exception;
	public boolean remove(Connection conn, Long id) throws Exception;
	public List<T> selectAll(Connection conn) throws Exception;
}

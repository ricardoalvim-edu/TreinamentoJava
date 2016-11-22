package br.com.fema.academicofx.dao.interfaces;

import java.sql.Connection;

import br.com.fema.academicofx.vo.CursoVO;

public interface ICursoDAO extends IGenericDAO<CursoVO>{
	public CursoVO selectById(Connection conn, Long id) throws Exception;
	public CursoVO selectBySigla(Connection conn, String sigla) throws Exception;
}

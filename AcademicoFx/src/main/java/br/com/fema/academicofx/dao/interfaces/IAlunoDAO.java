package br.com.fema.academicofx.dao.interfaces;

import java.sql.Connection;
import java.util.List;

import br.com.fema.academicofx.vo.AlunoVO;

public interface IAlunoDAO extends IGenericDAO<AlunoVO>{
	public List<AlunoVO> selectByCurso(Connection conn, Long id) throws Exception;
	public AlunoVO selectById(Connection conn, Long id) throws Exception;
	public AlunoVO selectByRA(Connection conn, String RA) throws Exception;
}

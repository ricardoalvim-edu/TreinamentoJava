package br.com.fema.academicofx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fema.academicofx.dao.interfaces.ICursoDAO;
import br.com.fema.academicofx.framework.db.DBConnectionFactory;
import br.com.fema.academicofx.vo.CursoVO;

public class CursoDAO implements ICursoDAO {

	@Override
	public boolean insert(Connection conn, CursoVO object) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("");
		sql.append("INSERT INTO cursos (ID_CURSO, CODIGO, DESCRICAO, SIGLA, QTDE_ANOS) VALUES"
				+ "  (?,?,?,?,?)");

		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			int index = 0;
			stmt.setLong(++index, object.getId());
			stmt.setString(++index, object.getCodigo());
			stmt.setString(++index, object.getDescricao());
			stmt.setString(++index, object.getSigla());
			stmt.setInt(++index, object.getQuantidadeAnos());
			int rows = stmt.executeUpdate();
			if (rows > 0)
				return true;
			else
				return false;
		} catch (Exception ex) {
			throw ex;
		} finally {
			stmt.close();
		}
	}

	@Override
	public boolean update(Connection conn, CursoVO object) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("");
		sql.append("UPDATE cursos (ID_CURSO, CODIGO, DESCRICAO, SIGLA, QTDE_ANOS)"
				+ " SET (?,?,?,?,?) WHERE ID_CURSO = ?");

		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

			int index = 0;
			stmt.setLong(++index, object.getId());
			stmt.setString(++index, object.getCodigo());
			stmt.setString(++index, object.getDescricao());
			stmt.setString(++index, object.getSigla());
			stmt.setInt(++index, object.getQuantidadeAnos());
			stmt.setLong(++index, object.getId());
			
			int rows = stmt.executeUpdate();
			if (rows > 0)
				return true;
			else
				return false;
		} catch (Exception ex) {
			throw ex;
		} finally {
			stmt.close();
		}
	}

	@Override
	public boolean remove(Connection conn, Long id) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("");
		sql.append("DELETE FROM cursos WHERE id_curso = ?");

		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			stmt.setLong(1, id);
			int rows = stmt.executeUpdate();
			if (rows > 0)
				return true;
			else
				return false;
		} catch (Exception ex) {
			throw ex;
		} finally {
			stmt.close();
		}
	}

	@Override
	public List<CursoVO> selectAll(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		try {
			conn = DBConnectionFactory.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("SELECT id_curso, codigo, descricao, sigla, qtde_anos FROM curso");
			PreparedStatement ps = conn.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = ps.executeQuery();
			List<CursoVO> cursos = new ArrayList<>();
			while (rs.next()) {
				CursoVO curso;
				curso = new CursoVO(rs.getLong(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				cursos.add(curso);
			}
			// ends ResultSet conn
			rs.close();
			// closes PS conn
			ps.close();
			// closes database connection
			conn.close();
			
			return cursos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CursoVO selectById(Connection conn, Long id) throws Exception {
		// TODO Auto-generated method stub
		try {
			conn = DBConnectionFactory.getInstance().getConnection();
			StringBuilder sql = new StringBuilder(
					"SELECT id_curso, codigo, descricao, sigla, qtde_anos FROM curso WHERE id_curso = ?");
			PreparedStatement ps = conn.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			CursoVO curso = null;
			while (rs.next()) {
				curso = new CursoVO(rs.getLong(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
			// ends ResultSet conn
			rs.close();
			// closes PS conn
			ps.close();
			// closes database connection
			conn.close();
			
			return curso;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CursoVO selectBySigla(Connection conn, String sigla) throws Exception {
		// TODO Auto-generated method stub
		try {
			conn = DBConnectionFactory.getInstance().getConnection();
			StringBuilder sql = new StringBuilder(
					"SELECT id_curso, codigo, descricao, sigla, qtde_anos FROM curso WHERE sigla = ?");
			PreparedStatement ps = conn.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, sigla);
			ResultSet rs = ps.executeQuery();
			CursoVO curso = null;
			while (rs.next()) {
				curso = new CursoVO(rs.getLong(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
			// ends ResultSet conn
			rs.close();
			// closes PS conn
			ps.close();
			// closes database connection
			conn.close();
			return curso;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

package br.com.fema.academicofx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.fema.academicofx.dao.interfaces.IAlunoDAO;
import br.com.fema.academicofx.framework.db.DBConnectionFactory;
import br.com.fema.academicofx.vo.AlunoVO;
import br.com.fema.academicofx.vo.CursoVO;

public class AlunoDAO implements IAlunoDAO {

	@Override
	public boolean insert(Connection conn, AlunoVO object) throws Exception {
		StringBuilder sql = new StringBuilder("");
		sql.append("INSERT INTO alunos (" + "ID_ALUNO, RA, NOME, SEXO, DT_NASC, EMAIL, ID_CURSO, FG_ATIVO" + ") VALUES"
				+ "  (?,?,?,?,?)");

		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			int index = 0;
			stmt.setLong(++index, object.getId());
			stmt.setString(++index, object.getRa());
			stmt.setString(++index, object.getNome());
			stmt.setString(++index, object.getSexo());
			stmt.setTimestamp(++index, new Timestamp(object.getDataNascimento().getTime()));
			stmt.setString(++index, object.getEmail());
			stmt.setLong(++index, object.getCurso().getId());
			stmt.setBoolean(++index, object.getFgAtivo());

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
	public boolean update(Connection conn, AlunoVO object) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Connection conn, Long id) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("");
		sql.append("DELETE FROM alunos WHERE id_aluno = ?");

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
	public List<AlunoVO> selectAll(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		try {
			conn = DBConnectionFactory.getInstance().getConnection();
			StringBuilder sql = new StringBuilder(
					"SELECT " + "ID_ALUNO, RA, NOME, SEXO, DT_NASC, EMAIL, ID_CURSO, FG_ATIVO" + "FROM " + "alunos");
			PreparedStatement ps = conn.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = ps.executeQuery();
			List<AlunoVO> alunos = new ArrayList<>();

			while (rs.next()) {
				int index = 0;
				CursoDAO cursoDAO = new CursoDAO();
				CursoVO curso = cursoDAO.selectById(conn, rs.getLong(7));

				AlunoVO aluno = new AlunoVO(rs.getLong(++index), rs.getString(++index), rs.getString(++index),
						rs.getString(++index), rs.getDate(++index), rs.getString(++index), rs.getBoolean(++index),
						curso);
				alunos.add(aluno);
			}
			// ends ResultSet conn
			rs.close();
			// closes PS conn
			ps.close();
			// closes database connection
			conn.close();

			return alunos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AlunoVO> selectByCurso(Connection conn, Long id) throws Exception {
		try {
			conn = DBConnectionFactory.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("SELECT "
					+ "ID_ALUNO, RA, NOME, SEXO, DT_NASC, EMAIL, ID_CURSO, FG_ATIVO" + "FROM aluno WHERE ID_CURSO = ?");
			PreparedStatement ps = conn.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			List<AlunoVO> alunos = null;
			AlunoVO aluno = null;
			while (rs.next()) {
				int index = 0;
				CursoDAO cursoDAO = new CursoDAO();
				CursoVO curso = cursoDAO.selectById(conn, rs.getLong(7));

				aluno = new AlunoVO(rs.getLong(++index), rs.getString(++index), rs.getString(++index),
						rs.getString(++index), rs.getDate(++index), rs.getString(++index), rs.getBoolean(++index),
						curso);
				alunos.add(aluno);
			}
			// ends ResultSet conn
			rs.close();
			// closes PS conn
			ps.close();
			// closes database connection
			conn.close();

			return alunos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AlunoVO selectById(Connection conn, Long id) throws Exception {
		// TODO Auto-generated method stub
		try {
			conn = DBConnectionFactory.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("SELECT "
					+ "ID_ALUNO, RA, NOME, SEXO, DT_NASC, EMAIL, ID_CURSO, FG_ATIVO" + "FROM aluno WHERE ID_ALUNO = ?");
			PreparedStatement ps = conn.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			AlunoVO aluno = null;
			while (rs.next()) {
				int index = 0;
				CursoDAO cursoDAO = new CursoDAO();
				CursoVO curso = cursoDAO.selectById(conn, rs.getLong(7));

				aluno = new AlunoVO(rs.getLong(++index), rs.getString(++index), rs.getString(++index),
						rs.getString(++index), rs.getDate(++index), rs.getString(++index), rs.getBoolean(++index),
						curso);
			}
			// ends ResultSet conn
			rs.close();
			// closes PS conn
			ps.close();
			// closes database connection
			conn.close();

			return aluno;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AlunoVO selectByRA(Connection conn, String RA) throws Exception {
		// TODO Auto-generated method stub
		try {
			conn = DBConnectionFactory.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("SELECT "
					+ "ID_ALUNO, RA, NOME, SEXO, DT_NASC, EMAIL, ID_CURSO, FG_ATIVO" + "FROM aluno WHERE RA = ?");
			PreparedStatement ps = conn.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, RA);
			ResultSet rs = ps.executeQuery();
			AlunoVO aluno = null;
			while (rs.next()) {
				int index = 0;
				CursoDAO cursoDAO = new CursoDAO();
				CursoVO curso = cursoDAO.selectById(conn, rs.getLong(7));

				aluno = new AlunoVO(rs.getLong(++index), rs.getString(++index), rs.getString(++index),
						rs.getString(++index), rs.getDate(++index), rs.getString(++index), rs.getBoolean(++index),
						curso);
			}
			// ends ResultSet conn
			rs.close();
			// closes PS conn
			ps.close();
			// closes database connection
			conn.close();

			return aluno;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

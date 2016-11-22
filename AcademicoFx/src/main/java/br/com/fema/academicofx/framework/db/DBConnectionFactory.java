package br.com.fema.academicofx.framework.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * TREINAMENTO JAVA
 * 
 * FÁBRICA DE OBJETOS DE CONEXÃO DE BANCO DE DADOS
 */
public class DBConnectionFactory {
	private static DBConnectionFactory INSTANCE = null;	
	
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String DATABASE = "academico";
	private static final String HOST = "jdbc:postgresql://localhost:5432/"+DATABASE;
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "root";
	
	private DBConnectionFactory() throws Exception{	
		try{
			Class.forName(DRIVER);			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public static DBConnectionFactory getInstance() 
			throws Exception{
		if (INSTANCE == null){
			INSTANCE = new DBConnectionFactory();
		}
		return INSTANCE;
	}
	
	public Connection getConnection() throws Exception{
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void test(){
		try{			
			Connection conn = DBConnectionFactory.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("SELECT NOW() AGORA");
			PreparedStatement ps = conn.prepareStatement(sql.toString(), 
					ResultSet.TYPE_FORWARD_ONLY, 
					ResultSet.CONCUR_READ_ONLY);			
			ResultSet rs = ps.executeQuery();	
			while (rs.next()){
				System.out.println(new java.util.Date(rs.getTimestamp("AGORA").getTime()).toString());
			}	
			// ends ResultSet conn
			rs.close();
			// closes PS conn
			ps.close();
			// closes database connection
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		DBConnectionFactory.test();
	}
}


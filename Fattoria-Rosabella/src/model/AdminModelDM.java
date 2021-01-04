package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import beans.Admin;

public class AdminModelDM implements Model<Admin>{

	@Override
	public Admin doRetrieveByKey(String var1) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Admin bean = new Admin();
		
		String selectSQL = "SELECT * FROM gestore WHERE email = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1, var1);
			
			System.out.println("doRetrieveByKey: "+ preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
			}
			System.out.println(bean);
		} finally {
			try {
				if(preparedStatement != null) 
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return bean;
	}

	@Override
	public Collection<Admin> doRetrieveAll(String var1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doSave(Admin var1) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doUpdate(Admin var1) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doDelete(Admin var1) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}

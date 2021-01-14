package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import beans.PrenotazioneAttivita;

/**
 * 
 * @author pa.ni.ca
 * @see Model
 */
public class PrenotazioneAttivitaModelDM implements Model<PrenotazioneAttivita> {

	@Override
	public PrenotazioneAttivita doRetrieveByKey(String var1) throws SQLException {
		Connection connection = null;
	      PreparedStatement preparedStatement = null;
	      PrenotazioneAttivita bean = new PrenotazioneAttivita();
	      String selectSQL = "SELECT * FROM prenotazione WHERE id_prenotazione = ?";

	      try {
	         connection = DriverManagerConnectionPool.getConnection();
	         preparedStatement = connection.prepareStatement(selectSQL);
	         preparedStatement.setInt(1, Integer.parseInt(var1));
	         System.out.println("doRetrieveByKey: " + preparedStatement.toString());
	         ResultSet rs = preparedStatement.executeQuery();

	         while(rs.next()) {
	            bean.setId_prenotazione(rs.getInt("id_prenotazione"));
	            bean.setId_attivita(rs.getInt("id_attivita"));
	            bean.setOra(rs.getString("ora"));
	            bean.setDate(rs.getString("date"));
	         }

	         System.out.println(bean);
	         return bean;
	      } finally {
	         try {
	            if (preparedStatement != null) {
	               preparedStatement.close();
	            }
	         } finally {
	            DriverManagerConnectionPool.releaseConnection(connection);
	         }
	      }
	}

	@Override
	public Collection<PrenotazioneAttivita> doRetrieveAll(String var1) throws SQLException {
		Connection connection = null;
	      PreparedStatement preparedStatement = null;
	      Collection<PrenotazioneAttivita> formi = new LinkedList<PrenotazioneAttivita>();
	      String selectSQL = "SELECT * FROM prenotozione";

	      try {
	         connection = DriverManagerConnectionPool.getConnection();
	         preparedStatement = connection.prepareStatement(selectSQL);
	         System.out.println("DoRetreiveAll: " + preparedStatement.toString());
	         ResultSet rs = preparedStatement.executeQuery();

	         while(rs.next()) {
	            PrenotazioneAttivita bean = new PrenotazioneAttivita();
	            bean.setId_prenotazione(rs.getInt("id_prenotazione"));
	            bean.setId_attivita(rs.getInt("id_attivita"));
	            bean.setOra(rs.getString("ora"));
	            bean.setDate(rs.getString("date"));
	            formi.add(bean);
	         }
	      } finally {
	         try {
	            if (preparedStatement != null) {
	               preparedStatement.close();
	            }
	         } finally {
	            DriverManagerConnectionPool.releaseConnection(connection);
	         }
	      }
	      return formi;
	}

	@Override
	public void doSave(PrenotazioneAttivita product) throws SQLException {
		 Connection connection = null;
	      PreparedStatement preparedStatement = null;
	      String insertSQL = "INSERT INTO prenotazione(id_prenotazione, id_attivita, data, ora ) VALUES (?, ?, ?, ?)";

	      try {
	         connection = DriverManagerConnectionPool.getConnection();
	         preparedStatement = connection.prepareStatement(insertSQL);
	         preparedStatement.setInt(1, product.getId_prenotazione());
	         preparedStatement.setInt(2, product.getId_attivita());
	         preparedStatement.setString(3, product.getDate());
	         preparedStatement.setString(4, product.getOra());
	         
	         System.out.println("doSave: " + preparedStatement.toString());
	         preparedStatement.executeUpdate();
	         connection.commit();
	      } finally {
	         try {
	            if (preparedStatement != null) {
	               preparedStatement.close();
	            }
	         } finally {
	            DriverManagerConnectionPool.releaseConnection(connection);
	         }
	      }
	}

	@Override
	public void doUpdate(PrenotazioneAttivita product) throws SQLException {
		 Connection connection = null;
	      PreparedStatement preparedStatement = null;
	      String updateSQL = "UPDATE prenotazione SET id_prenotazione = ?, id_attivita = ?, data=?, ora=?,  WHERE id_prenotazione = ?";

	      try {
	         connection = DriverManagerConnectionPool.getConnection();
	         preparedStatement = connection.prepareStatement(updateSQL);
	         preparedStatement.setInt(1, product.getId_prenotazione());
	         preparedStatement.setInt(2, product.getId_attivita());
	         preparedStatement.setString(3, product.getDate());
	         preparedStatement.setString(4, product.getOra());
	         
	         preparedStatement.setInt(5, product.getId_prenotazione());
	         System.out.println("doUpdate: " + preparedStatement.toString());
	         preparedStatement.executeUpdate();
	         connection.commit();
	      } finally {
	         try {
	            if (preparedStatement != null) {
	               preparedStatement.close();
	            }
	         } finally {
	            DriverManagerConnectionPool.releaseConnection(connection);
	         }
	      }
	}

	@Override
	public void doDelete(PrenotazioneAttivita product) throws SQLException {
		 Connection connection = null;
	      PreparedStatement preparedStatement = null;
	      String deleteSQL = "DELETE FROM prenotazione WHERE id_prenotazione = ?";

	      try {
	         connection = DriverManagerConnectionPool.getConnection();
	         preparedStatement = connection.prepareStatement(deleteSQL);
	         preparedStatement.setInt(1, product.getId_prenotazione());
	         System.out.println("doDelete: " + preparedStatement.toString());
	         preparedStatement.executeUpdate();
	      } finally {
	         try {
	            if (preparedStatement != null) {
	               preparedStatement.close();
	            }
	         } finally {
	            DriverManagerConnectionPool.releaseConnection(connection);
	         }
	      }
	   }

}

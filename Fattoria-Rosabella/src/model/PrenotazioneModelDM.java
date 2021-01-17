package model;

import beans.Prenotazione;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

/**
 * 
 * @author pa.ni.ca
 * @see Model
 */
public class PrenotazioneModelDM implements Model<Prenotazione> {
	
   public Collection<Prenotazione> doRetrieveByCarr(int code) throws SQLException {
	   	Connection connection = null;
	      PreparedStatement preparedStatement = null;
	      Collection<Prenotazione> formi = new LinkedList<Prenotazione>();
	      String selectSQL = "SELECT * FROM prenotazione WHERE id_riepilogo = ?";

	      try {
	         connection = DriverManagerConnectionPool.getConnection();
	         preparedStatement = connection.prepareStatement(selectSQL);
	         preparedStatement.setInt(1, code);
	         System.out.println("DoRetreiveByCarr: " + preparedStatement.toString());
	         ResultSet rs = preparedStatement.executeQuery();

	         while(rs.next()) {
	            Prenotazione bean = new Prenotazione();
	            bean.setId_prenotazione(rs.getInt("id_prenotazione"));
	            bean.setId_riepilogo(rs.getInt("id_riepilogo"));
	            bean.setPrezzo(rs.getInt("prezzo"));
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

   public Prenotazione doRetrieveByKey(String code) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      Prenotazione bean = new Prenotazione();
      String selectSQL = "SELECT * FROM prenotazione WHERE id_prenotazione = ?";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(selectSQL);
         preparedStatement.setInt(1, Integer.parseInt(code));
         System.out.println("doRetrieveByKey: " + preparedStatement.toString());
         ResultSet rs = preparedStatement.executeQuery();

         while(rs.next()) {
            bean.setId_prenotazione(rs.getInt("id_prenotazione"));
            bean.setId_riepilogo(rs.getInt("id_riepilogo"));
            bean.setPrezzo(rs.getInt("prezzo"));
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

   public Collection<Prenotazione> doRetrieveAll(String order) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      Collection<Prenotazione> formi = new LinkedList<Prenotazione>();
      String selectSQL = "SELECT * FROM prenotazione";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(selectSQL);
         System.out.println("DoRetreiveAll: " + preparedStatement.toString());
         ResultSet rs = preparedStatement.executeQuery();

         while(rs.next()) {
            Prenotazione bean = new Prenotazione();
            bean.setId_prenotazione(rs.getInt("id_prenotazione"));
            bean.setId_riepilogo(rs.getInt("id_riepilogo"));
            bean.setPrezzo(rs.getInt("prezzo"));
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

   public void doSave(Prenotazione product) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      String insertSQL = "INSERT INTO prenotazione(id_prenotazione, prezzo, id_riepilogo) VALUES (?, ?, ?)";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(insertSQL);
         preparedStatement.setInt(1, product.getId_prenotazione());
         preparedStatement.setInt(2, product.getPrezzo());
         preparedStatement.setInt(3, product.getId_riepilogo());
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

   public void doUpdate(Prenotazione product) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      String updateSQL = "UPDATE prenotazione SET id_prenotazione = ?, prezzo = ?,id_riepilogo = ?,  WHERE id_prenotazione = ?";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(updateSQL);
         preparedStatement.setInt(1, product.getId_prenotazione());
         preparedStatement.setInt(4, product.getPrezzo());
         preparedStatement.setInt(5, product.getId_riepilogo());
         preparedStatement.setInt(6, product.getId_prenotazione());
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

   public void doDelete(Prenotazione product) throws SQLException {
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

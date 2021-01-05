package model;

import beans.Utente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class UtenteModelDM implements Model<Utente> {
   public Utente doRetrieveByKey(String code) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      Utente bean = new Utente();
      String selectSQL = "SELECT * FROM utente WHERE email = ?";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(selectSQL);
         preparedStatement.setString(1, code);
         System.out.println("doRetrieveByKey: " + preparedStatement.toString());
         ResultSet rs = preparedStatement.executeQuery();

         while(rs.next()) {
            bean.setEmail(rs.getString("email"));
            bean.setNome(rs.getString("nome"));
            bean.setCognome(rs.getString("cognome"));
            bean.setCitta(rs.getString("citta"));
            bean.setIndirizzo(rs.getString("indirizzo"));
            bean.setPassword(rs.getString("password"));
            bean.setData_nascita(rs.getString("data_nascita"));
            bean.setAttivo(rs.getInt("attivo"));
            bean.setId_riepilogo(rs.getInt("id_riepilogo"));
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
   
   public Utente doRetrieveByKeyAndInattiveState(String code, String id) throws SQLException {
	      Connection connection = null;
	      PreparedStatement preparedStatement = null;
	      Utente bean = new Utente();
	      String selectSQL = "SELECT * FROM utente WHERE email = ? AND id_riepilogo = ? AND attivo = '0'";

	      try {
	         connection = DriverManagerConnectionPool.getConnection();
	         preparedStatement = connection.prepareStatement(selectSQL);
	         preparedStatement.setString(1, code);
	         preparedStatement.setString(2, id);
	         System.out.println("doRetrieveByKeyAndInattiveState: " + preparedStatement.toString());
	         ResultSet rs = preparedStatement.executeQuery();

	         while(rs.next()) {
	            bean.setEmail(rs.getString("email"));
	            bean.setNome(rs.getString("nome"));
	            bean.setCognome(rs.getString("cognome"));
	            bean.setCitta(rs.getString("citta"));
	            bean.setIndirizzo(rs.getString("indirizzo"));
	            bean.setPassword(rs.getString("password"));
	            bean.setData_nascita(rs.getString("data_nascita"));
	            bean.setAttivo(rs.getInt("attivo"));
	            bean.setId_riepilogo(rs.getInt("id_riepilogo"));
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

   public Collection<Utente> doRetrieveAll(String order) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      Collection<Utente> clienti = new LinkedList<Utente>();
      String selectSQL = "SELECT * FROM utente";
      if (order != null && !order.equals("")) {
         selectSQL = selectSQL + " ORDER BY " + order;
      }

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(selectSQL);
         System.out.println("doRetrieveAll:" + preparedStatement.toString());
         ResultSet rs = preparedStatement.executeQuery();

         while(rs.next()) {
            Utente bean = new Utente();
            bean.setEmail(rs.getString("email"));
            bean.setNome(rs.getString("nome"));
            bean.setCognome(rs.getString("cognome"));
            bean.setCitta(rs.getString("citta"));
            bean.setIndirizzo(rs.getString("indirizzo"));
            bean.setPassword(rs.getString("password"));
            bean.setData_nascita(rs.getString("data_nascita"));
            bean.setId_riepilogo(rs.getInt("id_riepilogo"));
            clienti.add(bean);
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

      return clienti;
   }

   public void doSave(Utente product) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      String insertSQL = "INSERT INTO utente (email, password, nome, cognome, data_nascita, citta, indirizzo, id_riepilogo, attivo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(insertSQL);
         preparedStatement.setString(1, product.getEmail());
         preparedStatement.setString(2, product.getPassword());
         preparedStatement.setString(3, product.getNome());
         preparedStatement.setString(4, product.getCognome());
         preparedStatement.setString(5, product.getData_nascita());
         preparedStatement.setString(6, product.getCitta());
         preparedStatement.setString(7, product.getIndirizzo());
         preparedStatement.setInt(8, product.getId_riepilogo());
         preparedStatement.setInt(9, product.getAttivo());
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

   public void doUpdate(Utente product) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      String updateSQL = "UPDATE utente SET email = ?, password = ?, nome = ?, cognome = ?,data_nascita = ?, citta = ?, indirizzo = ? WHERE email = ? ";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(updateSQL);
         preparedStatement.setString(1, product.getEmail());
         preparedStatement.setString(2, product.getPassword());
         preparedStatement.setString(3, product.getNome());
         preparedStatement.setString(4, product.getCognome());
         preparedStatement.setString(5, product.getData_nascita());
         preparedStatement.setString(6, product.getCitta());
         preparedStatement.setString(7, product.getIndirizzo());
         
         preparedStatement.setString(8, product.getEmail());
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
   
   public void doUpdateState(Utente product) throws SQLException {
	      Connection connection = null;
	      PreparedStatement preparedStatement = null;
	      String updateSQL = "UPDATE utente SET attivo = '1' WHERE email = ? ";

	      try {
	         connection = DriverManagerConnectionPool.getConnection();
	         preparedStatement = connection.prepareStatement(updateSQL);
	         preparedStatement.setString(1, product.getEmail());
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

   public void doDelete(Utente product) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      String deleteSQL = "DELETE FROM utente WHERE email = ?";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(deleteSQL);
         preparedStatement.setString(1, product.getEmail());
         System.out.println("doDelete: " + preparedStatement.toString());
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

}

package model;

import beans.Formare;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class FormareModelDM implements Model<Formare> {
   public Formare doRetrieveByKey(String code) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      Formare bean = new Formare();
      String selectSQL = "SELECT * FROM formare WHERE id_attivita = ?";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(selectSQL);
         preparedStatement.setInt(1, Integer.parseInt(code));
         System.out.println("doRetrieveByKey: " + preparedStatement.toString());
         ResultSet rs = preparedStatement.executeQuery();

         while(rs.next()) {
            bean.setId_attivita(rs.getInt("id_attivita"));
            bean.setDate(rs.getString("date"));
            bean.setId_riepilogo(rs.getInt("id_riepilogo"));
            bean.setOra(rs.getString("ora"));
            bean.setPartecipanti(rs.getInt("partecipanti"));
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

   public Collection<Formare> doRetrieveAll(String order) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      Collection<Formare> formi = new LinkedList<Formare>();
      String selectSQL = "SELECT * FROM formare";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(selectSQL);
         System.out.println("DoRetreiveAll: " + preparedStatement.toString());
         ResultSet rs = preparedStatement.executeQuery();

         while(rs.next()) {
            Formare bean = new Formare();
            bean.setId_attivita(rs.getInt("id_attivita"));
            bean.setDate(rs.getString("date"));
            bean.setId_riepilogo(rs.getInt("id_riepilogo"));
            bean.setOra(rs.getString("ora"));
            bean.setPartecipanti(rs.getInt("partecipanti"));
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

   public void doSave(Formare product) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      String insertSQL = "INSERT INTO formare(id_attivita, id_riepilogo, data, ora, partecipanti) VALUES (?, ?, ?, ?, ?)";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(insertSQL);
         preparedStatement.setInt(1, product.getId_attivita());
         preparedStatement.setInt(2, product.getId_riepilogo());
         preparedStatement.setString(3, product.getDate());
         preparedStatement.setString(4, product.getOra());
         preparedStatement.setInt(5, product.getPartecipanti());
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

   public void doUpdate(Formare product) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      String updateSQL = "UPDATE formare SET id_attivita = ?, id_riepilogo = ?, data=?, ora = ?, partecipanti = ?  WHERE numero = ?";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(updateSQL);
         preparedStatement.setInt(1, product.getId_attivita());
         preparedStatement.setInt(2, product.getId_riepilogo());
         preparedStatement.setString(3, product.getDate());
         preparedStatement.setString(4, product.getOra());
         preparedStatement.setInt(5, product.getPartecipanti());
         preparedStatement.setInt(6, product.getId_attivita());
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

   public void doDelete(Formare product) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      String deleteSQL = "DELETE FROM formare WHERE id_riepilogo = ?";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(deleteSQL);
         preparedStatement.setInt(1, product.getId_riepilogo());
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

   public ArrayList<Formare> doRetrieveByIdCarrello(int id_riepilogo) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      ArrayList<Formare> formi = new ArrayList<Formare>();
      String selectSQL = "SELECT * FROM formare WHERE id_riepilogo = ?";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(selectSQL);
         preparedStatement.setInt(1, id_riepilogo);
         System.out.println("DoRetreiveAll: " + preparedStatement.toString());
         ResultSet rs = preparedStatement.executeQuery();

         while(rs.next()) {
            Formare bean = new Formare();
            bean.setId_attivita(rs.getInt("id_attivita"));
            bean.setDate(rs.getString("date"));
            bean.setId_riepilogo(rs.getInt("id_riepilogo"));
            bean.setOra(rs.getString("ora"));
            bean.setPartecipanti(rs.getInt("partecipanti"));
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

}

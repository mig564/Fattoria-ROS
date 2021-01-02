package model;

import beans.RiepilogoOrdine;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class RiepilogoOrdineModelDM implements Model<RiepilogoOrdine> {
   public RiepilogoOrdine doRetrieveByKey(String code) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      RiepilogoOrdine bean = new RiepilogoOrdine();
      String selectSQL = "SELECT * FROM riepilogoOrdine WHERE id_riepilogo = ?";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(selectSQL);
         preparedStatement.setInt(1, Integer.parseInt(code));
         System.out.println("doRetrieveByKey: " + preparedStatement.toString());
         ResultSet rs = preparedStatement.executeQuery();

         while(rs.next()) {
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

   public Collection<RiepilogoOrdine> doRetrieveAll(String order) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      Collection<RiepilogoOrdine> formi = new LinkedList<RiepilogoOrdine>();
      String selectSQL = "SELECT * FROM riepilogoOrdine";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(selectSQL);
         System.out.println("DoRetreiveAll: " + preparedStatement.toString());
         ResultSet rs = preparedStatement.executeQuery();

         while(rs.next()) {
            RiepilogoOrdine bean = new RiepilogoOrdine();
            bean.setId_riepilogo(rs.getInt("id_riepilogo"));
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

   public void doSave(RiepilogoOrdine product) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      String insertSQL = "INSERT INTO riepilogoOrdine(id_riepilogo) VALUES (?)";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(insertSQL);
         preparedStatement.setInt(1, product.getId_riepilogo());
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

   public void doUpdate(RiepilogoOrdine product) throws SQLException {
   }

   public void doDelete(RiepilogoOrdine product) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      String deleteSQL = "DELETE FROM riepilogoOrdine WHERE id_riepilogo = ?";

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

}

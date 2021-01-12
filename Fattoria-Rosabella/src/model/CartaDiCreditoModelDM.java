package model;

import beans.CartaDiCredito;
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
public class CartaDiCreditoModelDM implements Model<CartaDiCredito> {
   public CartaDiCredito doRetrieveByKey(String code) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      CartaDiCredito bean = new CartaDiCredito();
      String selectSQL = "SELECT * FROM cartaDiCredito WHERE email = ?";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(selectSQL);
         preparedStatement.setString(1, code);
         System.out.println("doRetrieveByKey: " + preparedStatement.toString());
         ResultSet rs = preparedStatement.executeQuery();

         while(rs.next()) {
            bean.setNumero(rs.getInt("numero"));
            bean.setIntestatrio(rs.getString("intestatario"));
            bean.setCvv(rs.getInt("cvv"));
            bean.setEmail(rs.getString("email"));
            bean.setScadenza(rs.getString("scadenza"));
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

   public Collection<CartaDiCredito> doRetrieveAll(String order) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      Collection<CartaDiCredito> carte = new LinkedList<CartaDiCredito>();
      String selectSQL = "SELECT * FROM cartaDiCredito WHERE email = ?";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(selectSQL);
         preparedStatement.setString(1, order);
         System.out.println("DoRetreiveAll: " + preparedStatement.toString());
         ResultSet rs = preparedStatement.executeQuery();

         while(rs.next()) {
            CartaDiCredito bean = new CartaDiCredito();
            bean.setNumero(rs.getInt("numero"));
            bean.setIntestatrio(rs.getString("intestatario"));
            bean.setCvv(rs.getInt("cvv"));
            bean.setEmail(rs.getString("email"));
            bean.setScadenza(rs.getString("scadenza"));
            carte.add(bean);
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

      return carte;
   }

   public void doSave(CartaDiCredito product) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      String insertSQL = "INSERT INTO cartaDiCredito(numero, intestatario, scadenza, cvv, email) VALUES (?, ?, ?, ?, ?)";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(insertSQL);
         preparedStatement.setInt(1, product.getNumero());
         preparedStatement.setString(2, product.getIntestatrio());
         preparedStatement.setString(3, product.getScadenza());
         preparedStatement.setInt(4, product.getCvv());
         preparedStatement.setString(5, product.getEmail());
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

   public void doUpdate(CartaDiCredito product) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      String updateSQL = "UPDATE cartaDiCredito SET numero = ?, intestatario = ?, scadenza=?, cvv = ?, email= ?  WHERE numero = ?";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(updateSQL);
         preparedStatement.setInt(1, product.getNumero());
         preparedStatement.setString(2, product.getIntestatrio());
         preparedStatement.setString(3, product.getScadenza());
         preparedStatement.setInt(4, product.getCvv());
         preparedStatement.setString(5, product.getEmail());
         preparedStatement.setInt(6, product.getNumero());
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

   public void doDelete(CartaDiCredito product) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      String deleteSQL = "DELETE FROM cartaDiCredito WHERE numero = ?";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(deleteSQL);
         preparedStatement.setInt(1, product.getNumero());
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

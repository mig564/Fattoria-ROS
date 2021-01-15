package model;

import beans.Calendario;
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
public class CalendarioModelDM implements Model<Calendario> {
	
   public Calendario doRetrieveByKey(String code) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      Calendario bean = new Calendario();
      String selectSQL = "SELECT * FROM calendario WHERE data = ?";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(selectSQL);
         preparedStatement.setString(1, code);
         System.out.println("doRetrieveByKey: " + preparedStatement.toString());
         ResultSet rs = preparedStatement.executeQuery();

         while(rs.next()) {
            bean.setDate(rs.getString("data"));
            bean.setOra(rs.getString("ora"));
            bean.setId_attivita(rs.getInt("id_attivita"));
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
   
   public Collection<Calendario> doRetrieveByIdAttivita(int code) throws SQLException {
	      Connection connection = null;
	      PreparedStatement preparedStatement = null;
	      Collection<Calendario> calendari = new LinkedList<Calendario>();
	      String selectSQL = "SELECT * FROM calendario WHERE id_attivita = ?";

	      try {
	         connection = DriverManagerConnectionPool.getConnection();
	         preparedStatement = connection.prepareStatement(selectSQL);
	         preparedStatement.setInt(1, code);
	         System.out.println("doRetrieveByIdAttivita: " + preparedStatement.toString());
	         ResultSet rs = preparedStatement.executeQuery();

	         while(rs.next()) {
	        	Calendario bean = new Calendario();
	            bean.setDate(rs.getString("data"));
	            bean.setOra(rs.getString("ora"));
	            bean.setId_attivita(rs.getInt("id_attivita"));
	            calendari.add(bean);
	         }
	         return calendari;
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

   public Collection<Calendario> doRetrieveByAtt(int id, String data) throws SQLException {
	   Connection connection = null;
	      PreparedStatement preparedStatement = null;
	      Collection<Calendario> calendari = new LinkedList<Calendario>();
	      String selectSQL = "SELECT * FROM calendario WHERE id_attivita = ? AND data = ?";

	      try {
	         connection = DriverManagerConnectionPool.getConnection();
	         preparedStatement = connection.prepareStatement(selectSQL);
	         preparedStatement.setInt(1, id);
	         preparedStatement.setString(2, data);
	         System.out.println("DoRetreiveByAtt: " + preparedStatement.toString());
	         ResultSet rs = preparedStatement.executeQuery();

	         while(rs.next()) {
	            Calendario bean = new Calendario();
	            bean.setDate(rs.getString("data"));
	            bean.setOra(rs.getString("ora"));
	            bean.setId_attivita(rs.getInt("id_attivita"));
	            calendari.add(bean);
	         }
	         return calendari;
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
   
   public Collection<Calendario> doRetrieveAll(String order) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      Collection<Calendario> calendari = new LinkedList<Calendario>();
      String selectSQL = "SELECT * FROM calendario";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(selectSQL);
         System.out.println("DoRetreiveAll: " + preparedStatement.toString());
         ResultSet rs = preparedStatement.executeQuery();

         while(rs.next()) {
            Calendario bean = new Calendario();
            bean.setDate(rs.getString("data"));
            bean.setOra(rs.getString("ora"));
            bean.setId_attivita(rs.getInt("id_attivita"));
            calendari.add(bean);
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
      return calendari;
   }

   public void doSave(Calendario product) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      String insertSQL = "INSERT INTO calendario(data, ora, partecipanti, id_attivita) VALUES (?, ?, ?, ?)";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(insertSQL);
         preparedStatement.setString(1, product.getDate());
         preparedStatement.setString(2, product.getOra());
         preparedStatement.setInt(3, product.getPartecipanti());
         preparedStatement.setInt(4, product.getId_attivita());
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

   public void doUpdate(Calendario product) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      String updateSQL = "UPDATE calendario SET data = ?, ora = ?, id_attivita=? WHERE id_attivita = ?";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(updateSQL);
         preparedStatement.setString(1, product.getDate());
         preparedStatement.setString(2, product.getOra());
         preparedStatement.setInt(3, product.getId_attivita());
         preparedStatement.setInt(4, product.getId_attivita());
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

   public void doDelete(Calendario product) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      String deleteSQL = "DELETE FROM calendario WHERE id_attivita = ? AND data = ? AND ora = ?";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(deleteSQL);
         preparedStatement.setInt(1, product.getId_attivita());
         preparedStatement.setString(2, product.getDate());
         preparedStatement.setString(3, product.getOra());
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

public Calendario doRetrieveAllAttribute(String data, String ora, int id) throws SQLException {
	Connection connection = null;
    PreparedStatement preparedStatement = null;
    Calendario bean = new Calendario();
    String selectSQL = "SELECT * FROM calendario WHERE data = ? AND ora=? AND id_attivita=?";

    try {
       connection = DriverManagerConnectionPool.getConnection();
       preparedStatement = connection.prepareStatement(selectSQL);
       preparedStatement.setString(1, data);
       preparedStatement.setString(2, ora);
       preparedStatement.setInt(3, id);
       System.out.println("doRetrieveByKey: " + preparedStatement.toString());
       ResultSet rs = preparedStatement.executeQuery();

       while(rs.next()) {
          bean.setDate(rs.getString("data"));
          bean.setOra(rs.getString("ora"));
          bean.setId_attivita(rs.getInt("id_attivita"));
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

}

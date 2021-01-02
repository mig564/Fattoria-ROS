package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DriverManagerConnectionPool {
   private static List<Connection> freeDbConnections = new LinkedList<Connection>();

   static {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
      } catch (ClassNotFoundException var1) {
         System.out.println("DB driver not found:" + var1.getMessage());
      }

   }

   public DriverManagerConnectionPool() {
      freeDbConnections = new LinkedList<Connection>();
   }

   private static synchronized Connection createDBConnection() throws SQLException {
      Connection newConnection = null;
      String ip = "localhost";
      String port = "3306";
      String db = "fattoria";
      String username = "panica";
      String password = "panica";
      newConnection = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/?user=" + username + "&password=" + password + "&serverTimezone=Europe/Rome");
      newConnection.setAutoCommit(false);
      PreparedStatement ps = newConnection.prepareStatement("use " + db);
      int result = ps.executeUpdate();
      if (result > 0) {
         System.out.println("Database cambiato");
      }

      return newConnection;
   }

   public static synchronized Connection getConnection() throws SQLException {
      Connection connection;
      if (!freeDbConnections.isEmpty()) {
         connection = (Connection)freeDbConnections.get(0);
         freeDbConnections.remove(0);

         try {
            if (connection.isClosed()) {
               connection = getConnection();
            }
         } catch (SQLException var2) {
            connection.close();
            connection = getConnection();
         }
      } else {
         connection = createDBConnection();
      }

      return connection;
   }

   public static synchronized void releaseConnection(Connection connection) throws SQLException {
      if (connection != null) {
         freeDbConnections.add(connection);
      }

   }
}

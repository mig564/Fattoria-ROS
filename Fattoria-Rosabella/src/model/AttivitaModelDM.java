package model;

import beans.Attivita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class AttivitaModelDM implements Model<Attivita> {
   
	public Attivita doRetrieveByKey(String code) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      Attivita bean = new Attivita();
      String selectSQL = "SELECT * FROM attivita WHERE id_attivita = ?";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(selectSQL);
         preparedStatement.setInt(1, Integer.parseInt(code));
         System.out.println("doRetrieveByKey: " + preparedStatement.toString());
         ResultSet rs = preparedStatement.executeQuery();

         while(rs.next()) {
            bean.setId_attivita(rs.getInt("id_attivita"));
            bean.setCategoria(rs.getString("categoria"));
            bean.setNome(rs.getString("nome"));
            bean.setDescrizione(rs.getString("descrizione"));
            bean.setMax_persone(rs.getInt("max_persone"));
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

	public Collection<Attivita> doRetrieveByAtti(String data, String categoria ) throws SQLException {
		   Connection connection = null;
		   PreparedStatement preparedStatement = null;
		   Collection<Attivita> attivita = new LinkedList<Attivita>();
		   String selectSQL;
		   
		   try {
		   connection = DriverManagerConnectionPool.getConnection();
		   switch (categoria) {
		   case "TUTTE":
			   selectSQL = "SELECT DISTINCT a.id_attivita, a.categoria, a.nome, a.descrizione, a.max_persone, a.prezzo FROM calendario AS c, attivita AS a WHERE c.data = ? AND a.id_attivita = c.id_attivita AND c.ora='09:00'";
			   break;
		   default: selectSQL = "SELECT DISTINCT a.id_attivita, a.categoria, a.nome, a.descrizione, a.max_persone, a.prezzo FROM calendario AS c, attivita AS a WHERE c.data = ? AND a.categoria = ? AND a.id_attivita = c.id_attivita AND c.ora='09:00'";
		   }
		   preparedStatement = connection.prepareStatement(selectSQL);
		   preparedStatement.setString(1, data);
		   preparedStatement.setString(2, categoria);
		   System.out.println("DoRetreiveAll: " + preparedStatement.toString());
		   ResultSet rs = preparedStatement.executeQuery();

		   while(rs.next()) {
			   Attivita bean = new Attivita();
		       bean.setId_attivita(rs.getInt("id_attivita"));
		       bean.setCategoria(rs.getString("categoria"));
		       bean.setNome(rs.getString("nome"));
		       bean.setDescrizione(rs.getString("descrizione"));
		       bean.setMax_persone(rs.getInt("max_persone"));
		       bean.setPrezzo(rs.getInt("prezzo"));
		       attivita.add(bean);;
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
		      return attivita;
	   	}
	
   public Collection<Attivita> doRetrieveAll(String order) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      Collection<Attivita> attivita = new LinkedList<Attivita>();
      String selectSQL = "SELECT * FROM attivita";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(selectSQL);
         System.out.println("DoRetreiveAll: " + preparedStatement.toString());
         ResultSet rs = preparedStatement.executeQuery();

         while(rs.next()) {
            Attivita bean = new Attivita();
            bean.setId_attivita(rs.getInt("id_attivita"));
            bean.setCategoria(rs.getString("categoria"));
            bean.setNome(rs.getString("nome"));
            bean.setDescrizione(rs.getString("descrizione"));
            bean.setMax_persone(rs.getInt("max_persone"));
            bean.setPrezzo(rs.getInt("prezzo"));
            attivita.add(bean);
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
      return attivita;
   }

   public void doSave(Attivita product) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      String insertSQL = "INSERT INTO attivita(id_attivita, categoria, nome, descrizione, max_persone, prezzo) VALUES (?, ?, ?, ?, ? , ?)";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(insertSQL);
         preparedStatement.setInt(1, product.getId_attivita());
         preparedStatement.setString(2, product.getCategoria());
         preparedStatement.setString(3, product.getNome());
         preparedStatement.setString(4, product.getDescrizione());
         preparedStatement.setInt(5, product.getMax_persone());
         preparedStatement.setInt(6, product.getPrezzo());
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

   public void doUpdate(Attivita product) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      String updateSQL = "UPDATE attivita SET id_attivita=?, categoria=?, nome=?, descrizione=?, max_persone=?, prezzo=? WHERE id_attivita = ?";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(updateSQL);
         preparedStatement.setInt(1, product.getId_attivita());
         preparedStatement.setString(2, product.getCategoria());
         preparedStatement.setString(3, product.getNome());
         preparedStatement.setString(4, product.getDescrizione());
         preparedStatement.setInt(5, product.getMax_persone());
         preparedStatement.setInt(6, product.getPrezzo());
         preparedStatement.setInt(7, product.getId_attivita());
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

   public void doDelete(Attivita product) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      String deleteSQL = "DELETE FROM attivita WHERE id_attivita = ?";

      try {
         connection = DriverManagerConnectionPool.getConnection();
         preparedStatement = connection.prepareStatement(deleteSQL);
         preparedStatement.setInt(1, product.getId_attivita());
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

package model;

import java.sql.SQLException;
import java.util.Collection;

/**
 * 
 * @author pa.ni.ca
 *
 * Questa interfaccia ha i metodi per gestire le transazione con il datatbase
 *
 * @param <T> beans da gestire
 */
public interface Model<T> {
	/**
	 * Questo metodo ricerca un bens per chiave passato come parametro
	 * 
	 * @param var1 chiave per cercare il beans
	 * @return bean se trovato
	 * @throws SQLException errore nella connessione, query del db
	 */
   T doRetrieveByKey(String var1) throws SQLException;

   /**
    * Questo ritorna tuttu i beans
    * 
    * @param var1 ordine
    * @return lista con i beans
    * @throws SQLException errore nella connessione, query del db
    */
   Collection<T> doRetrieveAll(String var1) throws SQLException;

   /**
    * Questo metodo salva un nuovo bens
    * 
    * @param var1 bean da salvare
    * @throws SQLException errore nella connessione, query del db
    */
   void doSave(T var1) throws SQLException;

   /**
    * Questo metodo aggiorna il bens
    * 
    * @param var1 bean da aggiornare
    * @throws SQLException errore nella connessione, query del db
    */
   void doUpdate(T var1) throws SQLException;
   
   /**
    * Questo metodo elimina un nuovo
    * 
    * @param var1 bean da eliminare
    * @throws SQLException errore nella connessione, query del db
    */
   void doDelete(T var1) throws SQLException;
}

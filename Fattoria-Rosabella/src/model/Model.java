package model;

import java.sql.SQLException;
import java.util.Collection;

public interface Model<T> {
   T doRetrieveByKey(String var1) throws SQLException;

   Collection<T> doRetrieveAll(String var1) throws SQLException;

   void doSave(T var1) throws SQLException;

   void doUpdate(T var1) throws SQLException;

   void doDelete(T var1) throws SQLException;
}

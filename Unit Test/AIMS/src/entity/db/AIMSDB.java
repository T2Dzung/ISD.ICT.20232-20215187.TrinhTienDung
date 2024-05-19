package entity.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class AIMSDB {

  private static Connection connect;

  
  /** 
   * @return Connection
   */
  public static Connection getConnection() {
    if (connect != null) {
      return connect;
    }
    try {
      Class.forName("org.sqlite.JDBC");
      String url = "jdbc:sqlite:src/assets/db/aims.db";
      connect = DriverManager.getConnection(url);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    Statement statement = null;
    try {
        statement = connect.createStatement();
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    String query = "SELECT * FROM Media";
    try {
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("title");

            System.out.println("ID: " + id);
            System.out.println("title: " + name);
            System.out.println("--------------------");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return connect;
  }

  
  /** 
   * @param args
   */
  public static void main(String[] args) {
    AIMSDB.getConnection();
  }
}

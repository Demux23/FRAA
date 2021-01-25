package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DriverManagerConnectionPool {

  private static List<Connection> freeDbConnections;

  static {
    freeDbConnections = new LinkedList<Connection>();
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("DB driver not found:" + e.getMessage());
    }
  }

  public DriverManagerConnectionPool() {
    freeDbConnections = new LinkedList<Connection>();
  }

  public static synchronized Connection createDbConnection() {
    try {
      Connection newConnection = null;
      String ip = "localhost";
      String port = "3306";
      String db =
          "medqueue?serverTimezone=UTC&useLegacyDatetimeCode=false&useUnicode=true"
                  + "&useJDBCCompliantTimezoneShift=true&zeroDateTimeBehavior=convertToNull"
                  + "&autoReconnect=true&useSSL=false";
      String username = "root";
      String password = "angelo99";

      newConnection =
          DriverManager.getConnection(
              "jdbc:mysql://" + ip + ":" + port + "/" + db, username, password);

      newConnection.setAutoCommit(true);
      return newConnection;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public static synchronized Connection getConnection() throws SQLException {
    Connection connection;

    if (!freeDbConnections.isEmpty()) {
      connection = freeDbConnections.get(0);
      freeDbConnections.remove(0);

      try {
        if (connection.isClosed()) {
          connection = getConnection();
        }
      } catch (SQLException e) {
        connection.close();
        connection = getConnection();
      }
    } else {
      connection = createDbConnection();
    }

    return connection;
  }

  public static synchronized void releaseConnection(Connection connection) throws SQLException {
    if (connection != null) {
      freeDbConnections.add(connection);
    }
  }
}

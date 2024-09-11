package org.example;

public class DBConnection {

  private static volatile DBConnection INSTANCE;

  private String hostname;
  private String userName;
  private String password;
  private String port;

  private DBConnection(String hostName, String userName, String password, String port) {
    this.hostname = hostName;
    this.userName = userName;
    this.password = password;
    this.port = port;
  }

  private DBConnection() {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public static DBConnection getInstance(String hostName, String userName, String password, String port) {
    if (INSTANCE == null) {
      synchronized (DBConnection.class) {
        if (INSTANCE == null) {
          INSTANCE = new DBConnection(hostName, userName, password, port);
        }
      }
    }

    return INSTANCE;
  }

  public static DBConnection getInstance() {
    if (INSTANCE == null) {
      synchronized (DBConnection.class) {
         if (INSTANCE == null) {
          INSTANCE = new DBConnection();
        }
      }
    }

    return INSTANCE;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public String getHostname() {
    return this.hostname;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

  public void executeQuery(String query) {
    System.out.println("Executing query: " + query);
  }
}

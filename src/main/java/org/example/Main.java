package org.example;

public class Main {
  public static void main(String[] args) {
    DBConnection dbConnection = DBConnection.getInstance("proxy.master.local", "username", "admin", "6612");




    DBConnection dbConnection2 = DBConnection.getInstance("localhost", "root", "password", "3306");

    Util util = new Util();
    util.getDBInstance();
    System.out.println(dbConnection);
    System.out.println(dbConnection2);
    System.out.println(dbConnection == dbConnection2);

    System.out.println("\n-----------------\n");

    System.out.println(dbConnection.getHostname());
    System.out.println(dbConnection2.getHostname());

    System.out.println("\n-----------------\n");

    dbConnection.setHostname("localhost");
    dbConnection.setUserName("root");
    dbConnection.setPassword("password");
    dbConnection.setPort("3306");

    System.out.println(dbConnection.getHostname());
    System.out.println(dbConnection2.getHostname());
    util.getHostname();

    System.out.println("\n-----------------\n");

    dbConnection.setHostname("proxy.master.local");
    dbConnection.setUserName("username");
    dbConnection.setPassword("admin");
    dbConnection.setPort("6612");

    System.out.println(dbConnection.getHostname());
    System.out.println(dbConnection2.getHostname());
    util.getHostname();

    System.out.println("\n-----------------\n");

    dbConnection.executeQuery("SELECT * FROM users");
//
    System.out.println("\n-----------------\n");

    Thread threadFoo = new Thread(new Thread1());
    Thread threadBar = new Thread(new Thread2());
    threadFoo.start();
    threadBar.start();
  }

  static class Thread1 implements Runnable {
    @Override
    public void run() {
      DBConnection singleton = DBConnection.getInstance("proxy.master.local", "username", "admin", "6612");
      System.out.println(singleton.getHostname());
    }
  }

  static class Thread2 implements Runnable {
    @Override
    public void run() {
      DBConnection singleton = DBConnection.getInstance("localhost", "root", "password", "3306");
      System.out.println(singleton.getHostname());
    }
  }
}
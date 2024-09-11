package org.example;

public class Util {

  public void getHostname() {
    System.out.println("Util class printing hostName " + DBConnection.getInstance().getHostname());
  }

  public void getDBInstance() {
    System.out.println("Util class printing DBInstance " + DBConnection.getInstance());
  }
}

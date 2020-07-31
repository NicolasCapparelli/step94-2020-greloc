package com.google.sps.data;

public class User {
  long type;
  String email;
  String id;

  public User(long type, String email, String id) {
    this.type = type;
    this.email = email;
    this.id = id;
  }

  public long getType() {
    return this.type;
  }

  public String getEmail() {
    return this.email;
  }

  public String getID() {
    return this.id;
  }
}

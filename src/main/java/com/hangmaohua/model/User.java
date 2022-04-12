package com.hangmaohua.model;

import java.sql.Date;

public class User {

  private long id;
  private String username;
  private String password;
  private String email;
  private String gender;
  private Date birthdate;

  public User() {

  }

  public User(long id, String username, String password, String email, String gender, Date birthdate) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.gender = gender;
    this.birthdate = birthdate;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public java.sql.Date getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(java.sql.Date birthdate) {
    this.birthdate = birthdate;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", gender='" + gender + '\'' +
            ", birthdate=" + birthdate +
            '}';
  }
}

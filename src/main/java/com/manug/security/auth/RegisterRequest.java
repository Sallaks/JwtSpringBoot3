package com.manug.security.auth;

import java.util.Objects;

public class RegisterRequest {

  private String firstName;
  private String lastName;
  private String email;
  private String password;


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "RegisterRequest{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    RegisterRequest that = (RegisterRequest) o;

    if (!Objects.equals(firstName, that.firstName)) {
      return false;
    }
    if (!Objects.equals(lastName, that.lastName)) {
      return false;
    }
    if (!Objects.equals(email, that.email)) {
      return false;
    }
    return Objects.equals(password, that.password);
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    return result;
  }
}

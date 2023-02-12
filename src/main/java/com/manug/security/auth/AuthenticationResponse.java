package com.manug.security.auth;

public class AuthenticationResponse {

  private String token;

  public String getToken() {
    return token;
  }

  public AuthenticationResponse setToken(String token) {
    this.token = token;
    return this;
  }

  @Override
  public String toString() {
    return "AuthenticationResponse{" +
        "token='" + token + '\'' +
        '}';
  }
}

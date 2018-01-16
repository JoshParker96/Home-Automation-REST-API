package com.teamtreehouse.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamtreehouse.core.BaseEntity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User extends BaseEntity {
  public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
  @NotNull
  @Size(min = 2, max = 20)
  private String name;
  @NotNull
  @Size(min = 1)
  private String[] roles;
  @NotNull
  @Size(min = 2, max = 20)
  @JsonIgnore
  private String password;

  protected User() {
    super();
  }

  public User(String name, String[] roles, String password) {
    this();
    this.name = name;
    this.roles = roles;
    this.password = PASSWORD_ENCODER.encode(password);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String[] getRoles() {
    return roles;
  }

  public void setRoles(String[] roles) {
    this.roles = roles;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = PASSWORD_ENCODER.encode(password);
  }
}

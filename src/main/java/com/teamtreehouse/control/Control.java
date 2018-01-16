package com.teamtreehouse.control;

import com.teamtreehouse.core.BaseEntity;
import com.teamtreehouse.device.Device;
import com.teamtreehouse.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Control extends BaseEntity {
  @NotNull
  @Size(min = 2, max = 20)
  private String name;
  @ManyToOne
  private Device device;
  @NotNull
  private int value;
  @OneToOne
  private User lastModifiedBy;

  protected Control() {
    super();
  }

  public Control(String name, Device device, int value, User lastModifiedBy) {
    this();
    this.name = name;
    this.device = device;
    this.value = value;
    this.lastModifiedBy = lastModifiedBy;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Device getDevice() {
    return device;
  }

  public void setDevice(Device device) {
    this.device = device;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public User getLastModifiedBy() {
    return lastModifiedBy;
  }

  public void setLastModifiedBy(User lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }
}

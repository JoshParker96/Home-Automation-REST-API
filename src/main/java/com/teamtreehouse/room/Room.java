package com.teamtreehouse.room;

import com.teamtreehouse.core.BaseEntity;
import com.teamtreehouse.device.Device;
import com.teamtreehouse.user.User;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Room extends BaseEntity {
  @NotNull
  @Size(min = 2, max = 20)
  private String name;
  @NotNull
  private int area;
  @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
  private List<Device> devices;
  @ManyToMany(cascade = CascadeType.MERGE)
  private List<User> administrators;

  protected Room() {
    super();
    this.devices = new ArrayList<>();
    this.administrators = new ArrayList<>();
  }

  public Room(String name, int area) {
    this();
    this.name = name;
    this.area = area;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getArea() {
    return area;
  }

  public void setArea(int area) {
    this.area = area;
  }

  public List<Device> getDevices() {
    return devices;
  }

  public void addDevice(Device device) {
    devices.add(device);
  }

  public List<User> getAdministrators() {
    return administrators;
  }

  public void addAdministrator(User user) {
    administrators.add(user);
  }
}

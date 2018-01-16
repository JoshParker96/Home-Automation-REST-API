package com.teamtreehouse.device;

import com.teamtreehouse.control.Control;
import com.teamtreehouse.core.BaseEntity;
import com.teamtreehouse.room.Room;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Device extends BaseEntity{
  @NotNull
  @Size(min = 2, max = 20)
  private String name;
  @ManyToOne
  private Room room;
  @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
  private List<Control> controls;

  protected Device() {
    super();
    this.controls = new ArrayList<>();
  }

  public Device(String name, Room room) {
    this();
    this.name = name;
    this.room = room;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public List<Control> getControls() {
    return controls;
  }

  public void addControl(Control control) {
    controls.add(control);
  }
}

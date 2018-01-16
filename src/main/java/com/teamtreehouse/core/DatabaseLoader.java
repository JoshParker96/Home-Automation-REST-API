package com.teamtreehouse.core;

import com.teamtreehouse.control.Control;
import com.teamtreehouse.control.ControlRepository;
import com.teamtreehouse.device.Device;
import com.teamtreehouse.device.DeviceRepository;
import com.teamtreehouse.room.Room;
import com.teamtreehouse.room.RoomRepository;
import com.teamtreehouse.user.User;
import com.teamtreehouse.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements ApplicationRunner {

  private final RoomRepository rooms;

  private final UserRepository users;

  private final DeviceRepository devices;

  private ControlRepository controls;

  @Autowired
  public DatabaseLoader(RoomRepository rooms, UserRepository users,
                        DeviceRepository devices,
                        ControlRepository controls) {
    this.rooms = rooms;
    this.users = users;
    this.devices = devices;
    this.controls = controls;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    List<User> userList = Arrays.asList(
        new User("admin", new String[] {"ROLE_USER", "ROLE_ADMIN"}, "abc"),
        new User("user", new String[] {"ROLE_USER"}, "def"),
        new User("admin2", new String[] {"ROLE_USER", "ROLE_ADMIN"}, "ghi")
    );
    users.save(userList);

    List<Room> roomList = new ArrayList<>();
    List<Device> deviceList  = new ArrayList<>();
    List<Control> controlList = new ArrayList<>();

    IntStream.range(1, 100)
        .forEach(i -> {
          Room room = new Room("room" + i, 10);
          Device device = new Device("device" + i, room);
          Control control = new Control("control" + i, device, 0, userList.get(0));

          room.addDevice(device);
          room.addAdministrator(userList.get(0));
          device.addControl(control);

          roomList.add(room);
          deviceList.add(device);
          controlList.add(control);
        });

    rooms.save(roomList);
    devices.save(deviceList);
    controls.save(controlList);
  }
}

package kz.mediQR.impl;

import kz.mediQR.model.Room;
import kz.mediQR.register.RoomRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomRegisterImpl {
    @Autowired
    private RoomRegister roomRegister;

    public int addRoom(Room room) {
        return roomRegister.addRoom(room);
    }
}

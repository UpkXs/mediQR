package kz.mediQR.controller;

import kz.mediQR.impl.RoomRegisterImpl;
import kz.mediQR.model.Room;
import kz.mediQR.model.RoomLinks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RoomController {

    private final RoomRegisterImpl roomRegister;

    @Autowired
    public RoomController(RoomRegisterImpl roomRegister) {
        this.roomRegister = roomRegister;
    }

    @PostMapping("/addRoom/room")
    public int addRoom(@RequestBody Room room) {
        return roomRegister.addRoom(room);
    }

    @PostMapping("/get-room-by-verification-code/verificationCode")
    public Room getRoomLinksByVerificationCode(@RequestBody String verificationCode) {
        return roomRegister.getRoomByVerificationCode(verificationCode);
    }
}

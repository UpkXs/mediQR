package kz.mediQR.controller;

import kz.mediQR.impl.RoomLinksRegisterImpl;
import kz.mediQR.model.RoomLinks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RoomLinksController {

    private final RoomLinksRegisterImpl roomLinksRegister;

    @Autowired
    public RoomLinksController(RoomLinksRegisterImpl roomLinksRegister) {
        this.roomLinksRegister = roomLinksRegister;
    }

    @PostMapping("/get-room-links-by-verification-code/verificationCode")
    public RoomLinks getRoomLinksByVerificationCode(@RequestBody String verificationCode) {
        return roomLinksRegister.getRoomLinksByVerificationCode(verificationCode);
    }

}

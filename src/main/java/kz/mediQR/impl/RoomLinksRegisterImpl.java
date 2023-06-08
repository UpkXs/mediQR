package kz.mediQR.impl;

import kz.mediQR.model.RoomLinks;
import kz.mediQR.register.RoomLinksRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomLinksRegisterImpl {
    @Autowired
    private RoomLinksRegister roomLinksRegister;

    public int addRoomLinks(RoomLinks roomLinks) {
        return roomLinksRegister.addRoomLinks(roomLinks);
    }

    public RoomLinks getRoomLinksByVerificationCode(String verificationCode) {
        return roomLinksRegister.getRoomLinksByVerificationCode(verificationCode);
    }
}

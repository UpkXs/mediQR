package kz.mediQR.impl;

import kz.mediQR.model.Room;
import kz.mediQR.model.RoomLinks;
import kz.mediQR.register.RoomLinksRegister;
import kz.mediQR.register.RoomRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RoomRegisterImpl {
    @Autowired
    private RoomRegister roomRegister;

    @Autowired
    private RoomLinksRegister roomLinksRegister;

    public int addRoom(Room room) {
        roomRegister.addRoom(room);


        String verificationCode = getVerificationCode(room.getVerificationCode());

        RoomLinks roomLinks = generateRoomLinks(verificationCode);

        addRoomLinks(roomLinks);

        return 1;
    }

    private RoomLinks generateRoomLinks(String verificationCode) {
        RoomLinks roomLinks = new RoomLinks();
        roomLinks.setVerificationCode(verificationCode);

        roomLinks.setQrLink("https://mediqr.kz/algamed/room/" + verificationCode);

        roomLinks.setQrPoster("https://mediqr.kz/poster/algamed/room/" + verificationCode);

        String rndString = generateRandomString(15);

        roomLinks.setRoomLink("https://mediqr.kz/algamed/room/" + verificationCode + "/" + rndString);

        return roomLinks;
    }

    public int addRoomLinks(RoomLinks roomLinks) {
        return roomLinksRegister.addRoomLinks(roomLinks);
    }

    public String getVerificationCode(String roomNumber) {
        return roomRegister.getVerificationCode(roomNumber);
    }

    public static String generateRandomString(int length) {
        String symbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(symbols.length());
            char randomChar = symbols.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }

}

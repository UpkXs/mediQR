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

    public Room getRoomByVerificationCode(String verificationCode) {
        return roomRegister.getRoomByVerificationCode(verificationCode);
    }

    public int addRoom(Room room) {
        System.out.println("6W648I4P :: room : " + room.getPhoneNumber());
        roomRegister.addRoom(room);
        System.out.println("08d3pKHf :: room : " + room.getVerificationCode());


        String verificationCode = getVerificationCode(room.getRoomNumber());
        System.out.println("A6YRXQIZ :: room : " + verificationCode);

        RoomLinks roomLinks = generateRoomLinks(verificationCode);
        System.out.println("QMBsif39 :: room : " + room.getName());


        addRoomLinks(roomLinks);
        System.out.println("6utxRrDK :: room : " + room.getSurname());

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

    public String getVerificationCode(long roomNumber) {
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

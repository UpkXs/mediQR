package kz.mediQR.register;

import kz.mediQR.model.Queue;
import kz.mediQR.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoomRegister extends JpaRepository<Room, Long> {

    @Modifying
    @Query(value = "insert into room (verification_code, " +
            "name, " +
            "surname, " +
            "patronymic, " +
            "phone_number, " +
            "room_number, " +
            "reasons_one, " +
            "reasons_two, " +
            "reasons_three)" +
            " values (:#{#room.verificationCode}, " +
            ":#{#room.name}, " +
            ":#{#room.surname}, " +
            ":#{#room.patronymic}, " +
            ":#{#room.phoneNumber}, " +
            ":#{#room.roomNumber}, " +
            ":#{#room.reasonsOne}, " +
            ":#{#room.reasonsTwo}, " +
            ":#{#room.reasonsThree})", nativeQuery = true)
    @Transactional
    int addRoom(@Param("room") Room room);

    @Query(value = "select verification_code from room where room_number = :roomNumber", nativeQuery = true)
    String getVerificationCode(@Param("roomNumber") String roomNumber);

}

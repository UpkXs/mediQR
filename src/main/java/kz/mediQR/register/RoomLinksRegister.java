package kz.mediQR.register;

import kz.mediQR.model.RoomLinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoomLinksRegister extends JpaRepository<RoomLinks, Long> {

    @Modifying
    @Query(value = "insert into queue (verification_code, " +
            "qr_link, " +
            "qr_poster, " +
            "room_link)" +
            " values (:#{#roomLinks.verificationCode}, " +
            ":#{#roomLinks.qrLink}, " +
            ":#{#roomLinks.qrPoster}, " +
            ":#{#roomLinks.roomLink})", nativeQuery = true)
    @Transactional
    int addRoomLinks(@Param("roomLinks") RoomLinks roomLinks);

    @Query(value = "select * from roomLinks where verification_code = :verificationCode", nativeQuery = true)
    RoomLinks getRoomLinksByVerificationCode(@Param("verificationCode") String verificationCode);
}

package kz.mediQR.register;

import kz.mediQR.model.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface QueueRegister extends JpaRepository<Queue, Long> {

    @Modifying
    @Query(value = "insert into queue (queue_id, " +
            "verification_code, " +
            "queue_code, " +
            "queue_number, " +
            "reason, " +
            "is_leaved)" +
            " values (:#{#queue.queueId}, " +
            ":#{#queue.verificationCode}, " +
            ":#{#queue.queueCode}, " +
            ":#{#queue.queueNumber}, " +
            ":#{#queue.reason}, " +
            ":#{#queue.leaved})", nativeQuery = true)
    @Transactional
    int addQueue(@Param("queue") Queue queue);
}

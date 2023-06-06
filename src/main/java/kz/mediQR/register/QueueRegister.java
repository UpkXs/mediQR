package kz.mediQR.register;

import kz.mediQR.model.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface QueueRegister extends JpaRepository<Queue, Long> {

    @Modifying
    @Query(value = "insert into queue (queue_id, " +
            "verification_code, " +
            "queue_code, " +
            "queue_number, " +
            "reason, " +
            "is_leaved, " +
            "is_your_turn)" +
            " values (:#{#queue.queueId}, " +
            ":#{#queue.verificationCode}, " +
            ":#{#queue.queueCode}, " +
            ":#{#queue.queueNumber}, " +
            ":#{#queue.reason}, " +
            ":#{#queue.leaved}, " +
            ":#{#queue.isYourTurn})", nativeQuery = true)
    @Transactional
    int addQueue(@Param("queue") Queue queue);

    @Query(value = "select count(*) from queue where is_leaved = false and is_your_turn = false", nativeQuery = true)
    long loadQueueCount();

    @Query(value = "select count(*) from queue where is_leaved = false and is_your_turn = false and queue_id != :queueId", nativeQuery = true)
    long loadQueueCountWithoutMe(@Param("queueId") String queueId);

    @Modifying
    @Query(value = "update queue set is_leaved = true where queue_id = :queueId", nativeQuery = true)
    @Transactional
    int leaveQueueById(@Param("queueId") String queueId);

    @Modifying
    @Query(value = "update queue set is_leaved = true where queue_number = :queueNumber", nativeQuery = true)
    @Transactional
    int leaveQueueByNumber(@Param("queueNumber") long queueNumber);

    @Query(value = "select * from queue where is_leaved = false and is_your_turn = false", nativeQuery = true)
    List<Queue> loadAllQueue();

    @Modifying
    @Query(value = "update queue set is_your_turn = true where queue_number = :queueNumber", nativeQuery = true)
    @Transactional
    int setIsYourTurnTrue(long queueNumber);
}

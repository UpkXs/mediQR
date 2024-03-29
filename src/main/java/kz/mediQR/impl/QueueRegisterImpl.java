package kz.mediQR.impl;

import kz.mediQR.model.Queue;
import kz.mediQR.register.QueueRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueueRegisterImpl {

    @Autowired
    private QueueRegister queueRegister;

    public int addQueue(Queue queue) {
        return queueRegister.addQueue(queue);
    }

    public long loadQueueCount() {
        return queueRegister.loadQueueCount();
    }

    public long loadQueueCountWithoutMe(String queueId) {
        return queueRegister.loadQueueCountWithoutMe(queueId);
    }

    public int leaveQueueById(String queueId) {
        return queueRegister.leaveQueueById(queueId);
    }

    public int leaveQueueByNumber(long queueNumber) {
        return queueRegister.leaveQueueByNumber(queueNumber);
    }

    public List<Queue> loadAllQueue() {
        return queueRegister.loadAllQueue();
    }

    public int setIsYourTurnTrue(long queueNumber) {
        return queueRegister.setIsYourTurnTrue(queueNumber);
    }

    public void removeQueuesByNumber(List<Long> queueNumbers) {
        queueNumbers.forEach((queueNumber) -> {
            queueRegister.removeQueuesByNumber(queueNumber);
        });
    }

    public long loadAllQueueCount() {
        return queueRegister.loadAllQueueCount();
    }

    public long loadFrontMeQueueCountWithoutMe(String queueId) {
        System.out.println("5Lw2vlL2 :: queueId :  " + queueId);
        if (queueId.isEmpty()) {
            System.out.println("5Lw2vlL2 :: queueId :  " + queueId);
            return 0;
        }

        long orderIndex = queueRegister.getQueueOrderIndexById(queueId);

        return queueRegister.loadFrontMeQueueCountWithoutMe(queueId, orderIndex);
    }

    public boolean getItsYourTurn(String queueId) {
        return queueRegister.getItsYourTurn(queueId);
    }

    public boolean getIsLeaved(String queueId) {
        return queueRegister.getIsLeaved(queueId);
    }
}

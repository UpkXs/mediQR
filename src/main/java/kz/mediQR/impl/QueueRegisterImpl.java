package kz.mediQR.impl;

import kz.mediQR.model.Queue;
import kz.mediQR.register.QueueRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

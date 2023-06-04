package kz.mediQR.controller;

import kz.mediQR.impl.QueueRegisterImpl;
import kz.mediQR.model.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QueueRegisterController {

    private final QueueRegisterImpl queueRegister;

    @Autowired
    public QueueRegisterController(QueueRegisterImpl queueRegister) {
        this.queueRegister = queueRegister;
    }

    @PostMapping("/addQueue/queue")
    public int addQueue(@RequestBody Queue queue) {
        return queueRegister.addQueue(queue);
    }

    @PostMapping("/load-queue-count")
    public long loadQueueCount() {
        return queueRegister.loadQueueCount();
    }

    @PostMapping("/load-queue-count-without-me/queueId")
    public long loadQueueCountWithoutMe(@RequestBody String queueId) {
        return queueRegister.loadQueueCountWithoutMe(queueId);
    }

    @PostMapping("/leave-queue-by-id/queueId")
    public int leaveQueueById(@RequestBody String queueId) {
        return queueRegister.leaveQueueById(queueId);
    }
}

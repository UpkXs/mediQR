package kz.mediQR.controller;

import kz.mediQR.impl.QueueRegisterImpl;
import kz.mediQR.model.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/leave-queue-by-number/queueNumber")
    public int leaveQueueByNumber(@RequestBody long queueNumber) {
        return queueRegister.leaveQueueByNumber(queueNumber);
    }

    @PostMapping("/load-all-queue")
    public List<Queue> loadAllQueue() {
        return queueRegister.loadAllQueue();
    }

    @PostMapping("/set-is-your-turn/queueNumber")
    public int setIsYourTurnTrue(@RequestBody long queueNumber) {
        return queueRegister.setIsYourTurnTrue(queueNumber);
    }

    @PostMapping("/remove-queues-by-number/queueNumbers")
    public void removeQueuesByNumber(@RequestBody List<Long> queueNumbers) {
        queueRegister.removeQueuesByNumber(queueNumbers);
    }

    @PostMapping("/load-all-queue-count")
    public long loadAllQueueCount() {
        return queueRegister.loadAllQueueCount();
    }

    @PostMapping("/load-front-me-queue-count-without-me/queueId")
    public long loadFrontMeQueueCountWithoutMe(@RequestBody String queueId) {
        return queueRegister.loadFrontMeQueueCountWithoutMe(queueId);
    }

    @PostMapping("/get-is-your-turn/queueId")
    public boolean getItsYourTurn(@RequestBody String queueId) {
        return queueRegister.getItsYourTurn(queueId);
    }

    @PostMapping("/get-is-leaved/queueId")
    public boolean getIsLeaved(@RequestBody String queueId) {
        return queueRegister.getIsLeaved(queueId);
    }
}

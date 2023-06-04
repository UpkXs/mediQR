package kz.mediQR.controller;

import kz.mediQR.impl.QueueRegisterImpl;
import kz.mediQR.model.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class QueueRegisterController {

    private final QueueRegisterImpl queueRegister;

    @Autowired
    public QueueRegisterController(QueueRegisterImpl queueRegister) {
        this.queueRegister = queueRegister;
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/addQueue/queue")
    public int addQueue(@RequestBody Queue queue) {
        return queueRegister.addQueue(queue);
    }
}

package kz.mediQR.controller;

import kz.mediQR.impl.ReasonRegisterImpl;
import kz.mediQR.model.Reason;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReasonRegisterController {

    private final ReasonRegisterImpl reasonRegister;

    @Autowired
    public ReasonRegisterController(ReasonRegisterImpl reasonRegister) {
        this.reasonRegister = reasonRegister;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        reasonRegister.addReason(new Reason("ot6hO0w25x", "Doctor''s appointment"));
        reasonRegister.addReason(new Reason("wzHuT2M7gs", "Analyzes"));
        reasonRegister.addReason(new Reason("a72b5SkBpI", "Ultrasound"));
        reasonRegister.addReason(new Reason("s7xhlBna8p", "X-Ray"));
        reasonRegister.addReason(new Reason("K2qoGiz255", "Certificate of illness"));
        reasonRegister.addReason(new Reason("5K9zQ70iw7", "Sick leave"));
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/reasons")
    public List<Reason> loadReasons() {
        return reasonRegister.loadReasons();
    }
}

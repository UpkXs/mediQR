package kz.mediQR.impl;

import kz.mediQR.model.Reason;
import kz.mediQR.register.ReasonRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReasonRegisterImpl {

    @Autowired
    private ReasonRegister reasonRegister;

    public List<Reason> loadReasons() {
        return reasonRegister.findAll();
    }

    public void addReason(Reason reason) {
        this.reasonRegister.addReason(reason.getId(), reason.getName());
    }

}

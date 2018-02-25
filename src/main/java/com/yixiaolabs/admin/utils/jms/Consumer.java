package com.yixiaolabs.admin.utils.jms;


import com.yixiaolabs.admin.model.AdminLog;
import com.yixiaolabs.admin.service.AdminLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    private AdminLogService adminLogService;
    @JmsListener(destination = "sample.queue")
    public void receiveQueue(AdminLog log) {
        adminLogService.save(log);
    }
}

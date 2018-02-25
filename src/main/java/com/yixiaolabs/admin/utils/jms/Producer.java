package com.yixiaolabs.admin.utils.jms;

import com.yixiaolabs.admin.model.AdminLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void sendLog(AdminLog log) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, log);
    }

}

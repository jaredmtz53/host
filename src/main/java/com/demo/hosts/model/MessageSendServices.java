package com.demo.hosts.model;
import com.demo.hosts.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageSendServices {
    @Autowired
    private MessageSendRepo messageSendRepo;

    public MessageSend createMessageSend(MessageSend messageSend) {
        return messageSendRepo.save(messageSend);
    }


    public List<MessageSend> getAllMessageSends() {
        return messageSendRepo.findAll();
    }


    public MessageSend getMessageSendById(int messageId) {
        return messageSendRepo.findById(messageId).orElse(null);
    }


    public boolean deleteMessageSend(int messageId) {
        if (messageSendRepo.existsById(messageId)) {
            messageSendRepo.deleteById(messageId);
            return true;
        }
        return false;
    }


    public List<MessageSend> getMessagesBySender(String sender) {
        return messageSendRepo.findBySender(sender);
    }
}


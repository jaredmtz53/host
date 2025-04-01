package com.demo.hosts.model;
import com.demo.hosts.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessagesReplyServices {
    @Autowired
    private MessageReplyRepo messageReplyRepo;


    public MessageReply saveReplyMessage(MessageReply messageReply) {
        return messageReplyRepo.save(messageReply);
    }


    public Optional<MessageReply> getReplyMessageById(int messageID) {
        return messageReplyRepo.findById(messageID);
    }

    public List<MessageReply> getRepliesByReceiver(String receiver) {
        return messageReplyRepo.findByReceiver(receiver);
    }

    public List<MessageReply> getRepliesBySender(String sender) {
        return messageReplyRepo.findBySender(sender);
    }

    public void deleteReplyMessage(int messageID) {
        messageReplyRepo.deleteById(messageID);
    }




}

package com.demo.hosts.model;

import jakarta.persistence.*;
@Entity
public class MessageReply extends MessageSend {
    @Column(nullable = false)
    private String receiver;

    public MessageReply() {
        super();
    }
    public MessageReply(String sender, String receiver){
        super(sender);
        this.receiver = receiver;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}

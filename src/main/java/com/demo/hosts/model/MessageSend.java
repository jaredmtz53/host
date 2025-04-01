package com.demo.hosts.model;
import jakarta.persistence.*;


@Entity
public class MessageSend extends Messages{
    @Column(nullable = false)
    private String sender;

    public MessageSend(){
        super();
    }

    public MessageSend(String sender){
        this.sender = sender;
    }


    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}

package com.demo.hosts.model;
import java.time.Instant;
import jakarta.persistence.*;
@Entity
@Table(name = "messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageID;
    @Column(nullable = false)
    private String messageBody;
    private Instant time;
    @Column(nullable = false)  // Ensure this is not null in the DB
    private String sender;
    @Column(nullable = false)
    private String receiver;
    @Column(nullable = false, insertable = false, updatable = false)
    private String dtype;  // Quick fix to match database




    public Messages(){}
    public Messages(int messageID, String messageBody, Instant time, String sender, String receiver, String dtype){
        this.messageID = messageID;
        this.messageBody = messageBody;
        this.time = time;
        this.sender = sender;
        this.receiver = receiver;
        this.dtype = dtype;
    }


    //Setters
    public int getMessageID() {
        return messageID;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public Instant getTime() {
        return time;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSender() {
        return sender;
    }

    public String getDtype() {
        return dtype;
    }

    //Getters
    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

}

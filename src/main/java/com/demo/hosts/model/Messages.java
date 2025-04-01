package com.demo.hosts.model;
import jakarta.persistence.*;
import java.time.Instant;
@Entity
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageID;
    @Column(nullable = false)
    private String messageBody;
    private Instant time;




    public Messages(){}
    public Messages(int messageID, String messageBody, Instant time){
        this.messageID = messageID;
        this.messageBody = messageBody;
        this.time = time;
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
}

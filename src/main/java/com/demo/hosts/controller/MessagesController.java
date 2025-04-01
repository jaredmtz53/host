package com.demo.hosts.controller;
import com.demo.hosts.model.*;
import com.demo.hosts.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessagesController {




    @Autowired
    private MessagesRepo messagesRepo;

    //Create new message
    @PostMapping
    public ResponseEntity<Messages> createAMessage(@RequestBody Messages messages) {
        System.out.println("Received message: " + messages.getMessageBody());
        messages.setTime(Instant.now());
        Messages savedMessages = messagesRepo.save(messages);
        return ResponseEntity.ok(savedMessages);
    }


    //Get all messages
    @GetMapping
    public ResponseEntity<List<Messages>> getAllMessages() {
        List<Messages> messages = messagesRepo.findAll();
        return ResponseEntity.ok(messages);
    }

    //Delete a message
    @DeleteMapping("/{messageId}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int messageId) {
        if (messagesRepo.existsById(messageId)) {
            messagesRepo.deleteById(messageId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

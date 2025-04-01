package com.demo.hosts.controller;
import com.demo.hosts.model.*;
import com.demo.hosts.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.Instant;
import java.util.Optional;
@RestController
@RequestMapping("/messages")
public class MessagesController {

    @Autowired
    private MessagesRepo messagesRepo;

    //Create new message
    @PostMapping
    public ResponseEntity<Messages> createAMessage(@RequestBody Messages messages) {
        messages.setTime(Instant.now());
        Messages savedMessages = messagesRepo.save(messages);
        return ResponseEntity.ok(savedMessages);
    }
    // Get a message by ID
    @GetMapping("/{messageId}")
    public ResponseEntity<Messages> getMessageById(@PathVariable int messageId) {
        return messagesRepo.findById(messageId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }



@GetMapping("/messages/all")
public ResponseEntity<List<Messages>> getAllMessages() {
    List<Messages> messages = messagesRepo.findAllMessages();  // Call custom query method
    if (messages.isEmpty()) {
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(messages);
}

    //Delete a message
    @DeleteMapping("/{messageId}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int messageId){
        if (messagesRepo.existsById(messageId)) {
            messagesRepo.deleteById(messageId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Get messages by sender
    @GetMapping("/sender/{sender}")
    public ResponseEntity<List<Messages>> getMessagesBySender(@PathVariable String sender) {
        List<Messages> messages = messagesRepo.findBySender(sender);
        if (messages.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/receiver/{receiver}")
    public ResponseEntity<List<Messages>> getMessagesByReceiver(@PathVariable String receiver) {
        List<Messages> messages = messagesRepo.findByReceiver(receiver);
        if (messages.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(messages);
    }
}

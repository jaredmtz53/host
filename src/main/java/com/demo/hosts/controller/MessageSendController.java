package com.demo.hosts.controller;
import com.demo.hosts.repository.*;
import com.demo.hosts.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/messages/send")
public class MessageSendController {
    @Autowired
    private MessageSendServices messageSendService;



    @PostMapping
    public ResponseEntity<MessageSend> createMessageSend(@RequestBody MessageSend messageSend) {
        MessageSend savedMessage = messageSendService.createMessageSend(messageSend);
        return ResponseEntity.ok(savedMessage);
    }

    @GetMapping
    public List<MessageSend> getAllMessageSends() {
        return messageSendService.getAllMessageSends();
    }


    @GetMapping("/sender/{sender}")
    public List<MessageSend> getMessagesBySender(@PathVariable String sender) {
        return messageSendService.getMessagesBySender(sender);
    }


    @GetMapping("/{messageId}")
    public ResponseEntity<MessageSend> getMessageSendById(@PathVariable int messageId) {
        MessageSend messageSend = messageSendService.getMessageSendById(messageId);
        if (messageSend != null) {
            return ResponseEntity.ok(messageSend);
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{messageId}")
    public ResponseEntity<Void> deleteMessageSend(@PathVariable int messageId) {
        if (messageSendService.deleteMessageSend(messageId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

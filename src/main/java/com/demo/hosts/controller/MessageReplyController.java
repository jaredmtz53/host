package com.demo.hosts.controller;
import com.demo.hosts.repository.*;
import com.demo.hosts.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;
@RestController
@RequestMapping("/api/reply-messages")
public class MessageReplyController {
    @Autowired
    private MessagesReplyServices messageReplyService;



    @PostMapping
    public ResponseEntity<MessageReply> createReplyMessage(@RequestBody MessageReply messageReply) {
        try {
            MessageReply savedMessage = messageReplyService.saveReplyMessage(messageReply);
            return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @GetMapping("/{messageID}")
    public ResponseEntity<MessageReply> getReplyMessageById(@PathVariable int messageID) {
        Optional<MessageReply> messageReply = messageReplyService.getReplyMessageById(messageID);

        if (messageReply.isPresent()) {
            return new ResponseEntity<>(messageReply.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/receiver/{receiver}")
    public ResponseEntity<List<MessageReply>> getRepliesByReceiver(@PathVariable String receiver) {
        List<MessageReply> replies = messageReplyService.getRepliesByReceiver(receiver);

        if (!replies.isEmpty()) {
            return new ResponseEntity<>(replies, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(replies, HttpStatus.NO_CONTENT);
        }
    }


    @GetMapping("/sender/{sender}")
    public ResponseEntity<List<MessageReply>> getRepliesBySender(@PathVariable String sender) {
        List<MessageReply> replies = messageReplyService.getRepliesBySender(sender);

        if (!replies.isEmpty()) {
            return new ResponseEntity<>(replies, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(replies, HttpStatus.NO_CONTENT);
        }
    }


    @DeleteMapping("/{messageID}")
    public ResponseEntity<Void> deleteReplyMessage(@PathVariable int messageID) {
        try {
            messageReplyService.deleteReplyMessage(messageID);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

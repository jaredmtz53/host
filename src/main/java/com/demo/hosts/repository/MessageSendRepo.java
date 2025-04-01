package com.demo.hosts.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.demo.hosts.model.*;
@Repository
public interface MessageSendRepo extends JpaRepository<MessageSend, Integer>{
    List<MessageSend> findBySender(String sender);

}

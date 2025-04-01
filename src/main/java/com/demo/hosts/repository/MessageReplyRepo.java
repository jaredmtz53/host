package com.demo.hosts.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.demo.hosts.model.*;
import com.demo.hosts.repository.*;
@Repository
public interface MessageReplyRepo extends JpaRepository<MessageReply, Integer> {

}

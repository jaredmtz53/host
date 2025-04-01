package com.demo.hosts.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.demo.hosts.model.*;
import java.time.Instant;
import java.util.List;
@Repository
public interface MessagesRepo extends JpaRepository<Messages,Integer>{
    // List<Messages> getLast10Messages();
    // List<Messages> getMessagesByTime(Instant intialTime, Instant endTime);


}

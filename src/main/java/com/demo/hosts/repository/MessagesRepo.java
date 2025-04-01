package com.demo.hosts.repository;
import com.demo.hosts.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MessagesRepo extends JpaRepository<Messages,Integer> {
    //stuff
}

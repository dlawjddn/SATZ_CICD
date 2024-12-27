package com.example.stazcicd.repository;

import com.example.stazcicd.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u.name from User u")
    List<String> findAllUsername();

    @Query("select u.nickname from User u")
    List<String> findAllUserNickname();
}

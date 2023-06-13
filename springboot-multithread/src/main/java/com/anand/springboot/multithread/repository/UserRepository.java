package com.anand.springboot.multithread.repository;

import com.anand.springboot.multithread.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}

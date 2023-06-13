package com.anand.authservice.repository;

import com.anand.authservice.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials,Integer> {
}

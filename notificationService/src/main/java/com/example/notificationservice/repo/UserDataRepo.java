package com.example.notificationservice.repo;

import com.example.notificationservice.domain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepo extends JpaRepository<UserData,Long> {

}

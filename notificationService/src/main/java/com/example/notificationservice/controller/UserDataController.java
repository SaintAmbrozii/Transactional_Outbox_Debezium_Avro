package com.example.notificationservice.controller;

import com.example.notificationservice.domain.UserData;
import com.example.notificationservice.service.UserDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/userdata")
public class UserDataController {

    private final UserDataService userDataService;

    public UserDataController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @GetMapping
    public List<UserData> getAll() {
        return userDataService.findAll();
    }
}

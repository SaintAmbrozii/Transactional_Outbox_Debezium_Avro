package com.example.contactform.controller;

import com.example.contactform.domain.ContactForm;
import com.example.contactform.service.ConctactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contacts")
public class ContactFormController {

    private final ConctactService conctactService;

    public ContactFormController(ConctactService conctactService) {
        this.conctactService = conctactService;
    }

    @PostMapping
    public ContactForm addContact(@RequestBody ContactForm form) {
        return conctactService.create(form);
    }

    @GetMapping
    public List<ContactForm> getAll() {
        return conctactService.getAll();
    }
}

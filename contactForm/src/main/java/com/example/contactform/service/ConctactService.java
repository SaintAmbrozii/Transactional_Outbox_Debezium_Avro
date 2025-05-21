package com.example.contactform.service;

import com.example.contactform.domain.ContactForm;
import com.example.contactform.repo.ContactRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConctactService {

    private final ContactRepo contactRepo;

    public ConctactService(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public ContactForm create(ContactForm contactForm) {
        ContactForm newForm = new ContactForm();
        newForm.setName(contactForm.getName());
        newForm.setPhone(contactForm.getPhone());
        return contactRepo.save(newForm);
    }

    public List<ContactForm> getAll() {
        return contactRepo.findAll();
    }
}

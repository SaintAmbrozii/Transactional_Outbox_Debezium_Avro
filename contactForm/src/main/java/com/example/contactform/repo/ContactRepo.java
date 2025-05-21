package com.example.contactform.repo;

import com.example.contactform.domain.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<ContactForm,Long> {
}

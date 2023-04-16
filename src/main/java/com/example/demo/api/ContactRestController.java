package com.example.demo.api;

import com.example.demo.classes.Contact;
import com.example.demo.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path="/api/contacts")
public class ContactRestController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping(path="/all")
    public Iterable<Contact> showContacts() {
        return contactRepository.findAll();
    }

    @PostMapping("/add")
    public @ResponseBody Integer addContact(@RequestBody Contact contact) {
        contactRepository.save(contact);
        return contact.getId();
    }
}

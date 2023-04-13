package com.example.contact;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class ContactService {

    private static final String FILE_NAME = "contact.json";
    private static final Path CONTACT_FILE = Paths.get(FILE_NAME);

    public void saveContact(Contact contact) {
        try {
            if (!Files.exists(CONTACT_FILE)) {
                Files.createFile(CONTACT_FILE);
                Files.writeString(CONTACT_FILE, "[]");
            }

            List<Contact> contacts = readContacts();
            contacts.add(contact);

            String json = new ObjectMapper().writeValueAsString(contacts);
            Files.writeString(CONTACT_FILE, json, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save contact information.", e);
        }
    }

    private List<Contact> readContacts() throws IOException {
        String json = Files.readString(CONTACT_FILE);
        return new ObjectMapper().readValue(json, new TypeReference<List<Contact>>() {});
    }
    
}

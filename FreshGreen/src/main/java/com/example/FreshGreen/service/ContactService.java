package com.example.FreshGreen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FreshGreen.model.FGcontact;
import com.example.FreshGreen.repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;

    private final List<FGcontact> messageStore = new ArrayList<>();

    public String saveMessage(FGcontact message) {
        try {
            messageStore.add(message);
            System.out.println("Received message: " + message);
            return repository.save(message)!=null?"Message saved successfully.":"Failed to save message.";
        } catch (Exception e) {
            System.out.println("Error saving contact message: ");
            return e.getMessage();
        }
    }

    public List<FGcontact> getAllMessages() {
        return repository.findAll();
    }

    public List<FGcontact> getMessageStore() {
        return messageStore;
    }
}


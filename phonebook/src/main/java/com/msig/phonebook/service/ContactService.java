package com.msig.phonebook.service;

import com.msig.phonebook.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Contact addContact(Contact contact);
    void deleteContact(Long id);
    Optional<Contact> getContact(Long id);
    List<Contact> getAllContacts();
    List<Contact> getFilteredContacts(String name, String phoneNumber, String email);
    Contact updateContact(Long id, Contact updatedContact);
}

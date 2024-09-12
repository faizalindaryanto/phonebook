package com.msig.phonebook.service.impl;

import com.msig.phonebook.entity.Contact;
import com.msig.phonebook.repository.ContactRepository;
import com.msig.phonebook.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Optional<Contact> getContact(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> getFilteredContacts(String name, String phoneNumber, String email) {
        return contactRepository.findFiltered(name, phoneNumber, email);
    }

    @Override
    public Contact updateContact(Long id, Contact updatedContact) {
        Contact contact = contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not Found"));;
        contact.setName(updatedContact.getName());
        contact.setPhoneNumber(updatedContact.getPhoneNumber());
        contact.setEmail(updatedContact.getEmail());
        return contactRepository.save(contact);
    }


}

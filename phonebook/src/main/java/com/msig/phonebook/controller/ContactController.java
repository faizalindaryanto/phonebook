package com.msig.phonebook.controller;

import com.msig.phonebook.entity.Contact;
import com.msig.phonebook.service.ContactService;
import com.msig.phonebook.utility.ApiResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "*")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/addContact")
    public ResponseEntity<ApiResponse> addContact(@RequestBody Contact contact) {
        Contact data = contactService.addContact(contact);
        return ResponseEntity.ok(new ApiResponse(true, "Data Berhasil Ditambahkan", data));
    }

    @GetMapping("/getAllContacts")
    public ResponseEntity<ApiResponse> getAllContacts(@RequestParam(required = false) String name,
                                                      @RequestParam(required = false) String phoneNumber,
                                                      @RequestParam(required = false) String email) {
        List<Contact> data = contactService.getFilteredContacts(name, phoneNumber, email);
        return ResponseEntity.ok(new ApiResponse(true, "Success", data));
    }

    @DeleteMapping("/deleteContact/{id}")
    public ResponseEntity<ApiResponse> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return ResponseEntity.ok(new ApiResponse(true, "Success"));
    }

    @GetMapping("/getContact/{id}")
    public ResponseEntity<ApiResponse> getContact(@PathVariable Long id) {
        Optional<Contact> data = contactService.getContact(id);
        return ResponseEntity.ok(new ApiResponse(true, "Success", data));
    }

    @PutMapping("/updateContact/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        return ResponseEntity.ok(contactService.updateContact(id, contact));
    }

}

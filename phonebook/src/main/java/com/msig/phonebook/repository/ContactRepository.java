package com.msig.phonebook.repository;

import com.msig.phonebook.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("SELECT c FROM Contact c WHERE " +
            "(:name IS NULL OR c.name ILIKE %:name%) AND " +
            "(:phoneNumber IS NULL OR c.phoneNumber ILIKE %:phoneNumber%) AND " +
            "(:email IS NULL OR c.email ILIKE %:email%)")
    List<Contact> findFiltered(@Param("name") String name,
                               @Param("phoneNumber") String phoneNumber,
                               @Param("email") String email);
}

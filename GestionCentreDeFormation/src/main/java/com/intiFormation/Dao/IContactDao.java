package com.intiFormation.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Contact;

public interface IContactDao extends JpaRepository<Contact, Integer> {

}

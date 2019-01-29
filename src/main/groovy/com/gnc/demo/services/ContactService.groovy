package com.gnc.demo.services

import com.gnc.demo.domain.Contact
import com.gnc.demo.domain.Customer
import grails.gorm.services.Service
import javax.inject.Singleton
import javax.validation.Valid

@Singleton
@Service(Contact)
interface ContactService {
    Contact save(@Valid Contact contact)

    List<Contact> findAll(Map args)

    List<Contact> findAllByCustomer(Customer customer)

    Number count()

    Contact get(String id)
}

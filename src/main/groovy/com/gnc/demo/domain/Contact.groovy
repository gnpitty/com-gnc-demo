package com.gnc.demo.domain

import grails.gorm.annotation.Entity

@Entity
class Contact {
    Long id
    Long version

    Customer customer
    static belongsTo = Customer


    String email
    String phone
    String cellPhone
    String address
}

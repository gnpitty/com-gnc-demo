package com.gnc.demo.domain

import grails.gorm.annotation.Entity

@Entity
class Customer {
    Long id
    Long version
    String driverId
    String name
    String lastName

    static hasMany = [contacts: Contact, loans: Loan]
    static constraints = {
        contacts nullable: true
        loans nullable: true
    }

    static mapping = {
       contacts lazy: false
        loans lazy: false
    }
}

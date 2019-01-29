package com.gnc.demo.domain

import grails.gorm.annotation.Entity

@Entity
class Loan {
    Long id
    Long version

    Customer customer
    static belongsTo = Customer

    BigDecimal ammount
    long term
    BigDecimal rate

}

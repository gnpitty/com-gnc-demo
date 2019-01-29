package com.gnc.demo.services

import com.gnc.demo.domain.Customer
import com.gnc.demo.domain.Loan
import grails.gorm.services.Service
import javax.inject.Singleton
import javax.validation.Valid

@Singleton
@Service(Loan)
interface LoanService {

    void delete(Serializable id)

    Loan save(@Valid Loan loan)

    List<Loan> findAll(Map args)
    List<Loan> findAllByCustomer(  Customer customer )

    Number count()
    Loan get(String id)


}

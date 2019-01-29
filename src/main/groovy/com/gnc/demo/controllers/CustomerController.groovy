package com.gnc.demo.controllers


import com.gnc.demo.domain.Customer

import com.gnc.demo.services.ContactService
import com.gnc.demo.services.CustomerService
import com.gnc.demo.services.LoanService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import org.slf4j.Logger
import org.slf4j.LoggerFactory


@Controller("/customer")
class CustomerController {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);


    final CustomerService customerService
    final LoanService loanService
    final ContactService contactService

    CustomerController(CustomerService customerService, LoanService loanService, ContactService contactService) {
        this.customerService = customerService
        this.loanService = loanService
        this.contactService = contactService
    }

    @Get("/")
    String index() {
        return "Hola ! " + new Date()
    }

    @Get("/all/{offset}/{max}")
    List<Customer> getCustomers(String offset, String max) {
        List<Customer> customers = customerService.findAll([offset: offset, max: max])
        try {
            customers.each { customer ->
                // LOG.info(">>> Loans   :" +customer.loans.size())
                customer.contacts = []
                customer.loans = []
            }
        } catch (Exception e) {
            LOG.info(">>> Error :" + e)
        }


        return customers
    }

    @Get("/{id}")
    Customer getCustomers(String id) {
        Customer customer = customerService.get(id)
        customer?.contacts = []
        customer?.loans = []

        customer?.contacts = contactService.findAllByCustomer(customer)
        customer?.loans = loanService.findAllByCustomer(customer)
        return customer

    }
}
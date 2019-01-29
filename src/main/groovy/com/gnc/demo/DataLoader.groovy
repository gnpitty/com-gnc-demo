package com.gnc.demo

import com.gnc.demo.domain.Contact
import com.gnc.demo.domain.Customer
import com.gnc.demo.domain.Loan
import com.gnc.demo.services.ContactService
import com.gnc.demo.services.CustomerService
import com.gnc.demo.services.LoanService
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.runtime.server.event.ServerStartupEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.inject.Singleton

@Slf4j
@CompileStatic
@Singleton
class DataLoader implements ApplicationEventListener<ServerStartupEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(DataLoader.class);

    final CustomerService customerService
    final LoanService loanService
    final ContactService contactService

    DataLoader(CustomerService customerService, LoanService loanService, ContactService contactService) {
        this.customerService = customerService
        this.loanService = loanService
        this.contactService = contactService
    }

    @Override
    void onApplicationEvent(ServerStartupEvent event) {
        Contact contact = new Contact(version: 1, email: "franklin2020@coco.com", phone: "999-888-2898-0128", cellPhone: "999-888-2898-012998", address: "Pelican Bay Road #82187 zip 99123")
        HashSet<Contact>  contacts = new HashSet()
        contacts.add(contact)

        Loan loan = new Loan(version: 1, ammount: 5300.00, rate: 15.45, term: 48)
        HashSet<Loan> loans = new HashSet()
        loans.add(loan)



        Customer customer = new Customer(version: 1, name: "Franklin", lastName: "Wilson", driverId: "CA-MNC-2612777", loans: loans, contacts: contacts)
        loan.customer = customer
        contact.customer =customer

       // customerService.save(customer)

    }


}
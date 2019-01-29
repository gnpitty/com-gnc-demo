package com.gnc.demo.services

import com.gnc.demo.domain.Customer
import grails.gorm.services.Service
import javax.inject.Singleton
import javax.validation.Valid

@Singleton
@Service(Customer)
interface CustomerService {
   void delete(Serializable id)

    Customer save(@Valid Customer customer)

    List<Customer> findAll(Map args)
    List<Customer> findByNameLike(  String name,Map args)

    Number count()
    Customer get(String id)
    Customer findByNameAndLastName(String name, String lastName)


}

package com.pancras.datasource2.repository.jpa.customer;


import com.pancras.datasource2.domain.customer.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,String> {
}

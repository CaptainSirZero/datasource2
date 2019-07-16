package com.pancras.datasource2.domain.customer;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Data
@Entity(name = "company")
public class Person {

    @Id
    private String id;

    private String abbreviation;
}

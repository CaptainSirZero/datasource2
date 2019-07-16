package com.pancras.datasource2.domain.employee;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


@Entity(name = "announcement")
@Data
public class Student{
    @Id
    private Long id;

    private String content;

}

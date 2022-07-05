package com.practice.springjdbc.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "find_all_persons", query = "select p from Person p"),
        @NamedQuery(name = "find_by_name", query = "select p from Person p where p.name = :name"),
        @NamedQuery(name = "find_by_name_and_location", query = "select p from Person p where p.name = :name AND p.location = :location")

}
)
public class Person {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String location;
    private Date birthDate;

    /*
    this is required whenever we use the class in other class as bean or entity
    otherwise it will throw bean exception
    NoSuchMethodException
     */
    public Person() {

    }

    public Person(int id, String name, String location, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public Person(String name, String location, Date birthDate) {
        super();
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /*
    toString will convert the hashCode result into string format in console
     */
    @Override
    public String toString() {
        return String.format("\nPerson [id=%s, name=%s, location=%s, birthDate=%s]", id, name, location, birthDate);
    }

}
package com.gp225.rsexample;

import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

// the XmlRootElement annotation is required if you want to be able to send XML representations of Employee objects
@XmlRootElement(name = "employee")
public class Employee {

    String nin;         // national insurance number
    String name;        // name
    String surname;     // surname
    Date dateOfBirth;   // date of birth

    // default constructor
    public Employee() {
    }

    // the XmlAttribute annotation is required if you want to be able to send XML representations of Employee objects
    // note that the annotation MUST be set before the public getter method for each field
    @XmlAttribute
    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    // the XmlAttribute annotation is required if you want to be able to send XML representations of Employee objects
    // note that the annotation MUST be set before the public getter method for each field
    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // the XmlAttribute annotation is required if you want to be able to send XML representations of Employee objects
    // note that the annotation MUST be set before the public getter method for each field
    @XmlAttribute
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    // the XmlAttribute annotation is required if you want to be able to send XML representations of Employee objects
    // note that the annotation MUST be set before the public getter method for each field
    @XmlAttribute
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}

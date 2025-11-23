package com.example.demo.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "getStudentResponse", namespace = "http://example.com/demo/soap")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetStudentResponse {

    @XmlElement(name = "id", namespace = "http://example.com/demo/soap")
    private int id;

    @XmlElement(name = "name", namespace = "http://example.com/demo/soap")
    private String name;

    @XmlElement(name = "grade", namespace = "http://example.com/demo/soap")
    private double grade;

    public GetStudentResponse() {}

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

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

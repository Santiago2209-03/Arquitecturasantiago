package com.example.demo.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "getStudentRequest", namespace = "http://example.com/demo/soap")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetStudentRequest {

    @XmlElement(name = "id", namespace = "http://example.com/demo/soap")
    private int id;

    public GetStudentRequest() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

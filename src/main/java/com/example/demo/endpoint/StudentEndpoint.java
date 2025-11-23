package com.example.demo.endpoint;

import com.example.demo.service.StudentService;
import com.example.demo.soap.GetStudentRequest;
import com.example.demo.soap.GetStudentResponse;
import com.example.demo.model.Student;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentEndpoint {

    private static final String NAMESPACE = "http://example.com/demo/soap";

    private final StudentService studentService;

    public StudentEndpoint(StudentService studentService) {
        this.studentService = studentService;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "getStudentRequest")
    @ResponsePayload
    public GetStudentResponse getStudent(@RequestPayload GetStudentRequest request) {
        GetStudentResponse response = new GetStudentResponse();
        Long id = (long) request.getId();
        Student s = studentService.findById(id).orElse(null);
        if (s != null) {
            response.setId(s.getId().intValue());
            response.setName(s.getName());
            response.setGrade(s.getGrade() == null ? 0.0 : s.getGrade());
        } else {
            response.setId(request.getId());
            response.setName("Not found");
            response.setGrade(0.0);
        }
        return response;
    }
}

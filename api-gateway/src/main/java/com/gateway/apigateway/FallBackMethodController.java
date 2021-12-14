package com.gateway.apigateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/employeeAPIFallBack")
    public String employeeAPIFallBackMethod() {
        return "Employee API is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/departmentAPIFallBack")
    public String departmentAPIFallBackMethod() {
        return "Department API is taking longer than Expected." +
                " Please try again later";
    }
}
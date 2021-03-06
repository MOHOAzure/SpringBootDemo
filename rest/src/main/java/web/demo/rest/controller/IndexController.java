package web.demo.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String sayHello() {
        return "Hello and Welcome to this demo application. You can create a new Product by making a POST request to /api/products endpoint, and view all created products by /api/products endpoint.";
    }
}

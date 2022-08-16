package kz.halykacademy.bookstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
public class NoAuthController {
    public void hello() {
        System.out.println("hii");
    }
}

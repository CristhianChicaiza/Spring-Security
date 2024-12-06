package com.app.controller;

import jakarta.annotation.security.PermitAll;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.Generated;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
public class TestAuthController {

    @GetMapping("/get")
    @PreAuthorize("hasAuthority('CREATE')")
    public String helloGet(){
        return "Hello with GET";
    }

    @PostMapping("/post")
    @PreAuthorize("hasRole('ADMIN')")
    public String helloPost(){
        return "Hello with POST";
    }

    @PutMapping("/put")
    public String helloPut(){
        return "Hello with PUT";
    }

    @DeleteMapping("/delete")
    public String helloDelete(){
        return "Hello with DELETE";
    }

    @PatchMapping("/patch")
    public String helloPatch(){
        return "Hello with PATCH";
    }
}























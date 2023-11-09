package com.example.demo.api.controller;

import com.example.demo.service.NameService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class NameController {

    private NameService nameService = new NameService();

    @GetMapping("/name")
    public String getName() {
        return nameService.getName();
    }

    @PutMapping("/name")
    public void updateName( String name) {
        nameService.setName(name);
    }
}

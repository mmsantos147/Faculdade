package com.example.demo.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@NoArgsConstructor
public class NameService {

    private String name;

    public String getName() {
        return "Matheus Matheus Matheus Matheus";
    }
}

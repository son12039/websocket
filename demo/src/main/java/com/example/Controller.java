package com.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/test")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class Controller {
    
    @GetMapping("/")
    public ResponseEntity chatGET(){
        log.info("췍췍");
        return ResponseEntity.ok(null);
    }
 
}

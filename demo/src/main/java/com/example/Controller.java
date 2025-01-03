package com.example;

import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@org.springframework.stereotype.Controller
@Log4j2
public class Controller {
    
    @GetMapping("/")
    public String chatGET(){
        log.info("@ChatController, chat GET()");
        return "forward:/websocket.html";
    }
 
}

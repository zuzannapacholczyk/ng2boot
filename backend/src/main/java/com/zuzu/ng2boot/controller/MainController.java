package com.zuzu.ng2boot.controller;

import com.zuzu.ng2boot.repository.EventRepository;
import com.zuzu.ng2boot.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZPACHOLC on 05.05.2017.
 */
@RestController
public class MainController {

    @Autowired
    EventRepository er;

    @Autowired
    ResourceRepository rr;

    @RequestMapping("/api")
    @ResponseBody
    String home() {
        return "Welcome zuzu!";
    }
}

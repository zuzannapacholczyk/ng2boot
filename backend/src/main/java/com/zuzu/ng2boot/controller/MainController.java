package com.zuzu.ng2boot.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.zuzu.ng2boot.domain.Event;
import com.zuzu.ng2boot.domain.Resource;
import com.zuzu.ng2boot.repository.EventRepository;
import com.zuzu.ng2boot.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

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
        return "Welcome!";
    }

    @RequestMapping("/api/resources")
    Iterable<Resource> resources() {
        return rr.findAll();
    }

    @GetMapping("/api/events")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    Iterable<Event> events(@RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
                           @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) {
        return er.findBetween(from, to);
    }

    @RequestMapping("/api/events/create")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Transactional
    Event createEvent(@RequestBody EventCreateParams params) {
        Resource r = rr.findOne(params.resource);

        Event e = new Event();
        e.setStart(params.start);
        e.setEnd(params.end);
        e.setText(params.text);
        e.setResource(r);

        er.save(e);

        return e;
    }

    public static class EventCreateParams {
        public LocalDateTime start;
        public LocalDateTime end;
        public String text;
        public Long resource;
    }
}

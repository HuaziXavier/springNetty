package com.lepp.no1.controller;

import com.lepp.no1.model.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/hello")
@Controller
public class HelloCOntroller {

    @ResponseBody
    @RequestMapping("/hello1")
    public Object hello() {
        List<Ticket> tickets = new ArrayList<Ticket>();
        for(int i=0;i<100;i++){
            Ticket ticket = new Ticket();
            ticket.setId(UUID.randomUUID().toString());
            ticket.setName("哈哈"+0+i);
            tickets.add(ticket);
        }
        return tickets;
    }
}

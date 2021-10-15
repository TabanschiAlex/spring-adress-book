package com.semester.springadressbook.controller;

import com.semester.springadressbook.entity.AddressBook;
import com.semester.springadressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/book")
public class AddressBookController {
    @Autowired
    private AddressBookService service;

    @GetMapping()
    public String index(Model model, @RequestParam(required = false) Optional<String> text) {
        List<AddressBook> list;

        if (text.isPresent()) {
            list = service.findByAttributes(text);
        } else {
            list = service.getAll();
        }

        model.addAttribute("addresses", list);
        return "index";
    }
}

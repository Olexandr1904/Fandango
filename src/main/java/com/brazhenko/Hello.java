package com.brazhenko;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Admin on 29.07.2015.
 */
@Controller
@RequestMapping("/fandango")
public class Hello {

    @RequestMapping(value = "/index")
    public String logIn() {
        return "hello";
    }

}
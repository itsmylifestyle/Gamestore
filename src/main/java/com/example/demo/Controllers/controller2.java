package com.example.demo.Controllers;

import com.example.demo.enti.post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller2 {

    @GetMapping("/cont2")
    public String cont2(Model model) {
        return "cont2";
    }


}

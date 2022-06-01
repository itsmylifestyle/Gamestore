package com.example.demo.Controllers;

import com.example.demo.enti.post;
import com.example.demo.enti.repositories.inter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class controller3 {

    @Autowired
    private inter zapisi;

    @GetMapping("/posts")
    public String posts(Model model) {
        Iterable<post> posts = zapisi.findAll();
        model.addAttribute("posts", posts);
        return "posts";
    }


    @GetMapping("/posts/add")
    public String postadd(Model model) {

        return "postsadd";
    }

    @PostMapping("/posts/add")
    public String postaddform(@RequestParam String title,@RequestParam String anons,@RequestParam String fulltext, Model model) {
        post addpost = new post(title, anons, fulltext);
        zapisi.save(addpost);
        return "redirect:/posts";
    }

    @GetMapping("posts/{id}")
    public String postdeta(@PathVariable(value="id") long id, Model model) {
        if(!zapisi.existsById(id)) {
            return "redirect:/posts";
        }

        Optional<post> pos1 = zapisi.findById(id);
        ArrayList<post> res = new ArrayList<>();
        pos1.ifPresent(res::add);
        model.addAttribute("post", pos1);
        return "postdeta";
    }

    @GetMapping("posts/{id}/edit")
        public String postedit(@PathVariable(value="id") long id, Model model) {
        if(!zapisi.existsById(id)) {
            return "redirect:/posts";
        }

        Optional<post> pos1 = zapisi.findById(id);
        ArrayList<post> res = new ArrayList<>();
        pos1.ifPresent(res::add);
        model.addAttribute("post", pos1);
        return "edit";
    }
}


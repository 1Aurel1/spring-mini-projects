package com.sessionattributes.demosessionattributes.controller;

import com.sessionattributes.demosessionattributes.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/inController")
@SessionAttributes("todosInController")
public class HomeController {

    @ModelAttribute("todosInController")
    public List<Todo> todos(){

        List<Todo> todos = new ArrayList<>();
        return todos;
    }

    @GetMapping("/")
    public String getHome(Model model, @ModelAttribute("todosInController") List<Todo> todos){

        model.addAttribute("todos", todos);

        model.addAttribute("newTodo", new Todo());

        return "index";
    }

    @PostMapping("/")
    public String postHome(@ModelAttribute Todo todo, @ModelAttribute("todosInController") List<Todo> todos){

        todos.add(todo);

        return "redirect:/inController/";
    }
}

package com.sessionattributes.demosessionattributes.controller;

import com.sessionattributes.demosessionattributes.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/inBean")
public class Home2Controller {

    private List<Todo> todos;

    @Autowired
    public Home2Controller(List<Todo> todos) {
        this.todos = todos;
    }

    @GetMapping("/")
    public String getHome(Model model){

        model.addAttribute("todos", todos);

        model.addAttribute("newTodo", new Todo());

        return "index2";
    }

    @PostMapping("/")
    public String postHome(@ModelAttribute Todo todo){

        todos.add(todo);

        return "redirect:/inBean/";
    }
}

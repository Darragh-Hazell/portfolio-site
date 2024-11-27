package software.darragh.website.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("current", "about");
        return "index";
    }

    @GetMapping("/{content}")
    public String content(@PathVariable String content, Model model) {
        model.addAttribute("current", content);
        return "index";
    }
}
